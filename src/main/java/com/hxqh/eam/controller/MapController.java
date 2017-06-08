package com.hxqh.eam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lh on 2017-6-6 11:14:18
 */

@Controller
@RequestMapping("/map")
public class MapController {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String getAuthorDetail() {
        return "success";
    }


}
