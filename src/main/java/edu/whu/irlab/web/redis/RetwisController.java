package edu.whu.irlab.web.redis;

import edu.whu.irlab.module.redis.sdr.NoSuchDataException;
import edu.whu.irlab.module.redis.sdr.RetwisSecurity;
import edu.whu.irlab.module.redis.sdr.entity.Post;
import edu.whu.irlab.module.redis.sdr.entity.Range;
import edu.whu.irlab.module.redis.sdr.entity.WebPost;
import edu.whu.irlab.module.redis.sdr.repository.RetwisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Roger on 2016/6/15.
 */
@Controller
@RequestMapping("/retwis")
public class RetwisController {

    @Autowired
    private RetwisRepository retwis;

    @RequestMapping("/")
    public String root(@RequestParam(required = false) Integer page, Model model) {
        if (RetwisSecurity.isSignedIn()) {
            return "redirect:/!" + RetwisSecurity.getName();
        }
        return timeline(page, model);
    }

    @RequestMapping("/signUp")
    public String signUp(String name, String pass, String pass2, Model model, HttpServletResponse response) {
        if (retwis.isUserValid(name)) {
            model.addAttribute("errorduplicateuser", Boolean.TRUE);
            return "redis/sdr/signin";
        }

        if (!StringUtils.hasText(pass) || !StringUtils.hasText(pass2) || !pass.equals(pass2)) {
            model.addAttribute("errormatch", Boolean.TRUE);
            return "redis/sdr/signin";
        }

        String auth = retwis.addUser(name, pass);
        addAuthCookie(auth, name, response);

        return "redirect:/!" + name;
    }

    @RequestMapping("/signIn")
    public String signIn(@RequestParam(required = false) String name, @RequestParam(required = false) String pass, Model model, HttpServletResponse response) {
        // add tracing cookie
        if (retwis.auth(name, pass)) {
            addAuthCookie(retwis.addAuth(name), name, response);
            return "redirect:!" + name;
        }
        else if (StringUtils.hasText(name) || StringUtils.hasText(pass)) {
            model.addAttribute("errorpass", Boolean.TRUE);
        }
        // go back to sign in screen
        return "redis/sdr/signin";
    }

    private void addAuthCookie(String auth, String name, HttpServletResponse response) {
        RetwisSecurity.setUser(name, retwis.findUid(name));

        // Cookie cookie = new Cookie(CookieInterceptor.RETWIS_COOKIE, auth);
        // cookie.setComment("Retwis-J demo");
        // // cookie valid for up to 1 week
        // cookie.setMaxAge(60 * 60 * 24 * 7);
        // response.addCookie(cookie);
    }

    @RequestMapping(value = "/!{name}", method = RequestMethod.GET)
    public String posts(@PathVariable String name, @RequestParam(required = false) String replyto, @RequestParam(required = false) String replypid, @RequestParam(required = false) Integer page, Model model) {
        checkUser(name);
        String targetUid = retwis.findUid(name);
        model.addAttribute("post", new Post());
        model.addAttribute("name", name);
        model.addAttribute("followers", retwis.getFollowers(targetUid));
        model.addAttribute("following", retwis.getFollowing(targetUid));

        if (RetwisSecurity.isSignedIn()) {
            model.addAttribute("replyTo", replyto);
            model.addAttribute("replyPid", replypid);
            model.addAttribute("loggedIn", Boolean.TRUE);
            if (!targetUid.equals(RetwisSecurity.getUid())) {
                model.addAttribute("also_followed", retwis.alsoFollowed(RetwisSecurity.getUid(), targetUid));
                model.addAttribute("common_followers", retwis.commonFollowers(RetwisSecurity.getUid(), targetUid));
                model.addAttribute("follows", retwis.isFollowing(RetwisSecurity.getUid(), targetUid));
                model.addAttribute("loggedUser", RetwisSecurity.getName());
            }
        }
        // sanitize page attribute
        page = (page != null ? Math.abs(page) : 1);
        model.addAttribute("page", page + 1);
        Range range = new Range(page);
        model.addAttribute("moreposts", (RetwisSecurity.isUserSignedIn(targetUid) ? retwis.hasMoreTimeline(targetUid,
                range) : retwis.hasMorePosts(targetUid, range)));
        model.addAttribute("posts", (RetwisSecurity.isUserSignedIn(targetUid) ? retwis.getTimeline(targetUid, range)
                : retwis.getPosts(targetUid, range)));

        return "redis/sdr/user";
    }

    @RequestMapping(value = "/!{name}", method = RequestMethod.POST)
    public String posts(@PathVariable String name, WebPost post, Model model, HttpServletRequest request) {
        checkUser(name);
        retwis.post(name, post);
        return "redirect:/!" + name;
    }

    @RequestMapping("/!{name}/follow")
    public String follow(@PathVariable String name) {
        checkUser(name);
        retwis.follow(name);
        return "redirect:/!" + name;
    }

    @RequestMapping("/!{name}/stopfollowing")
    public String stopFollowing(@PathVariable String name) {
        checkUser(name);
        retwis.stopFollowing(name);
        return "redirect:/!" + name;
    }

    @RequestMapping("/!{name}/mentions")
    public String mentions(@PathVariable String name, Model model) {
        checkUser(name);
        model.addAttribute("name", name);
        String targetUid = retwis.findUid(name);

        model.addAttribute("posts", retwis.getMentions(targetUid, new Range()));
        model.addAttribute("followers", retwis.getFollowers(targetUid));
        model.addAttribute("following", retwis.getFollowing(targetUid));

        if (RetwisSecurity.isSignedIn() && !targetUid.equals(RetwisSecurity.getUid())) {
            model.addAttribute("also_followed", retwis.alsoFollowed(RetwisSecurity.getUid(), targetUid));
            model.addAttribute("common_followers", retwis.commonFollowers(RetwisSecurity.getUid(), targetUid));
            model.addAttribute("follows", retwis.isFollowing(RetwisSecurity.getUid(), targetUid));
        }

        return "mentions";
    }

    @RequestMapping("/timeline")
    public String timeline(@RequestParam(required = false) Integer page, Model model) {
        // sanitize page attribute
        page = (page != null ? Math.abs(page) : 1);
        model.addAttribute("page", page + 1);
        Range range = new Range(page);
        model.addAttribute("moreposts", retwis.hasMoreTimeline(range));
        model.addAttribute("posts", retwis.timeline(range));
        model.addAttribute("users", retwis.newUsers(new Range()));
        return "redis/sdr/timeline";
    }

    @RequestMapping("/logout")
    public String logout() {
        String user = RetwisSecurity.getName();
        // invalidate auth
        retwis.deleteAuth(user);
        return "redirect:";
    }

    @RequestMapping("/status")
    public String status(String pid, Model model) {
        checkPost(pid);
        model.addAttribute("posts", retwis.getPost(pid));
        return "status";
    }

    private void checkUser(String username) {
        if (!retwis.isUserValid(username)) {
            throw new NoSuchDataException(username, true);
        }
    }

    private void checkPost(String pid) {
        if (!retwis.isPostValid(pid)) {
            throw new NoSuchDataException(pid, false);
        }
    }

    @ExceptionHandler(NoSuchDataException.class)
    public String handleNoUserException(NoSuchDataException ex) {
        //		model.addAttribute("data", ex.getData());
        //		model.addAttribute("nodatatype", ex.isPost() ? "nodata.post" : "nodata.user");
        return "nodata";
    }
}
