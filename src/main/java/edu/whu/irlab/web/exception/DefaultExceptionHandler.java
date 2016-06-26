package edu.whu.irlab.web.exception;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 捕获Controller中的异常
 * 只有使用shiro基于注解的权限认证才能通过 @ExceptionHandler 来捕获认证异常
 * Created by Roger on 2016/5/25.
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    // @ModelAttribute
    // public void init(){
    //     System.out.println("this is init!");
    // }

    @ExceptionHandler({UnauthenticatedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthenticatedException e) {
        System.out.println("UnauthenticatedException");
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", "UnauthenticatedException");
        mv.setViewName("account/login");
        return mv;
    }

    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        System.out.println("UnauthorizedException");
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", "UnauthorizedException");
        mv.setViewName("account/login");
        return mv;
    }

    @ExceptionHandler({UnknownAccountException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnknownAccountException(NativeWebRequest request, UnknownAccountException e){
        System.out.println("UnknownAccountException");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", "用户不存在");
        modelAndView.setViewName("account/login");
        return modelAndView;
    }

    @ExceptionHandler({IncorrectCredentialsException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processIncorrectCredentialsException(Model model){
        System.out.println("IncorrectCredentialsException");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", "密码错误不存在");
        modelAndView.setViewName("account/login");
        return modelAndView;
    }

    @ExceptionHandler({ExcessiveAttemptsException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processExcessiveAttemptsException(Model model){
        System.out.println("ExcessiveAttemptsException");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", "尝试次数过多");
        modelAndView.setViewName("account/login");
        return modelAndView;
    }
}
