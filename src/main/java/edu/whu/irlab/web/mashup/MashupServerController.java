package edu.whu.irlab.web.mashup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

/**
 * 输出JsonP格式的Mashup 服务端, 支持被跨域调用.
 *
 * Created by Roger on 2016/5/26.
 */
@Controller
@RequestMapping("/mashup")
public class MashupServerController {

    private static final String DEFAULT_JQUERY_JSONP_CALLBACK_PARM_NAME = "callback";

    @RequestMapping(value = "/jsonp", produces = "application/javascript;charset=UTF-8")
    @ResponseBody
    public String mashup(@RequestParam(value = DEFAULT_JQUERY_JSONP_CALLBACK_PARM_NAME) String callbackName){
        System.out.println(callbackName);
        Map<String, String> map = Collections.singletonMap("content", "<p>基于JQuery的JSONP实现，绕过浏览器对Ajax不能访问跨域名网站内容的限制实现Mashup。</p>");
        /*// 设置需要被格式化为JSOn字符串的内容
        Map<String, String> map = Collections.singletonMap("content", "<p>基于JQuery的JSONP实现，绕过浏览器对Ajax不能访问跨域名网站内容的限制实现Mashup。</p>");
        JSONPObject jsonpObject = new JSONPObject(callbackName);
        // jsonpObject.setFunction(callbackName);
        jsonpObject.addParameter(map);
        System.out.println(jsonpObject.toJSONString());*/
        String text = callbackName+"("+JSON.toJSONString(map)+")";
        return text;
    }
}
