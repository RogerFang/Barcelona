package edu.whu.irlab.web.account;

import edu.whu.irlab.model.User;
import edu.whu.irlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Roger on 2016/5/25.
 */
@Controller
@RequestMapping(value = "/admin/user")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users", users);
        return "account/adminUserList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id){
        userService.deleteByPrimaryKey(id);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id, Model model){
        System.out.println(id);
        User user = userService.selectByPrimaryKey(id);
        System.out.println(user.getUsername());
        model.addAttribute("user", user);
        return "account/adminUserUpdate";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user){
        System.out.println(user.getUsername());
        userService.updateByPrimaryKeySelective(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user){
        userService.register(user);
        return "redirect:/admin/user";
    }
}
