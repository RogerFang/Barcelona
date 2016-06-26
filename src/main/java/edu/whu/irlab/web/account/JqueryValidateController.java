package edu.whu.irlab.web.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 测试前端验证
 * 1、jquery.validate.js
 * 2、messages_bs_zh.js
 * 3、validate.css
 * 4、unchecked.gif
 * Created by Roger on 2016/5/25.
 */
@Controller
@RequestMapping("/jquery")
public class JqueryValidateController {

    @RequestMapping(method = RequestMethod.GET)
    public String jquery(){
        return "validate/jquery";
    }
}
