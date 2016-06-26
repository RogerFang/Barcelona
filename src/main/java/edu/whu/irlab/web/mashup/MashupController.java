package edu.whu.irlab.web.mashup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Roger on 2016/5/26.
 */
@Controller
@RequestMapping("/mashup")
public class MashupController {

    @RequestMapping(method = RequestMethod.GET)
    public String mashup(){
        return "mashup/mashup_client";
    }
}
