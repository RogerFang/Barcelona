package edu.whu.irlab.web.redis;

import edu.whu.irlab.module.redis.springdataredis.pub.PublisheService;
import edu.whu.irlab.module.redis.springdataredis.sub.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Roger on 2016/6/14.
 */
@Controller
@RequestMapping("/redis")
public class SpringDataRedisController {
    @Autowired
    private PublisheService publisheService;

    @Autowired
    private SubscribeService subscribeService;

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    public String sub(Model model){
        model.addAttribute("messageList", subscribeService.getMessageList());
        return "redis/subResult";
    }

    @RequestMapping(value = "/pub", method = RequestMethod.GET)
    public String pub(){
        return "redis/pub";
    }

    @RequestMapping(value = "/pub", method = RequestMethod.POST)
    public String pub(String message){
        publisheService.publish("user:topic", message);
        return "redis/pubResult";
    }
}
