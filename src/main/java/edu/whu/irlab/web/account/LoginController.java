package edu.whu.irlab.web.account;

import edu.whu.irlab.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 1、涉及shiro验证, a:shiro自带login , 下面的fail()方法, 此时只需要考虑验证失败的情况; b:自己getSubject().login,用于捕获异常,下面的login() post
 * 2、涉及jsp表单标签, spring提供的form标签, 首次请求表单页面时, 需要传入一个新创建的对象
 * 3、涉及校验hibernate-validator, 需要在spring-mvc.xml里配置validator, 利用spring的form标签<form:errors>进行校验信息显示
 * Created by Roger on 2016/5/24.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        // 进入login页面时, 若要使用spring的form标签,则应该创建一个User对象,否则会抛出异常
        model.addAttribute("user", new User());
        return "account/login";
    }

    /**
     * 对传入的参数user,进行validate(hibernate-validator)
     * 通过subject.login(token)进行认证, 根据捕获相应的异常进行对应的消息提示
     * @param user
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String login(@Validated User user, BindingResult result, Model model){
        if (result.hasErrors()){
            for (ObjectError error: result.getAllErrors()){
                System.out.println(error.getDefaultMessage());
            }
            // hibernate-validator, 返回检验错误信息
            return "account/login";
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("UnknownAccountException");
            model.addAttribute("username", user.getUsername());
            return "redirect:/login";
        }catch (IncorrectCredentialsException e){
            System.out.println("IncorrectCredentialsException");
            model.addAttribute("username", user.getUsername());
            return "redirect:/login";
        }catch (ExcessiveAttemptsException e){
            System.out.println("ExcessiveAttemptsException");
            model.addAttribute("username", user.getUsername());
            return "redirect:/login";
        }

        // 验证通过后
        if (subject.isAuthenticated()){
            System.out.println("验证通过!");
            return "redirect:/";
        }else {
            return "redirect:/login";
        }
    }

    /**
     * shiro权限认证, /login=authc, 会自动进行认证, 所以此处只需考虑认证失败的情况
     * @param user
     * @param model
     * @return
     */
    /*@RequestMapping(method = RequestMethod.POST)
    public String fail(User user, Model model){
        // 验证失败后返回输入的用户名
        model.addAttribute("username", user.getUsername());
        return "account/login";
    }*/
}
