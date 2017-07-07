package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.dto.Mob88Dto;
import com.hxqh.eam.model.dto.Mob91Dto;
import com.hxqh.eam.model.dto.Mob92Dto;
import com.hxqh.eam.model.dto.VMob87Dto;
import com.hxqh.eam.model.view.VMob86;
import com.hxqh.eam.model.view.VMob92;
import com.hxqh.eam.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/mobile")
@SessionAttributes(value = "sessionInfo")
public class MobileController {

    @Autowired
    private MobileService mobileService;


    /**
     * mobile87 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mobile87", method = RequestMethod.GET)
    public String mobile87() {
        return "mobile/mob87";
    }

    /**
     * vMob87Data 数据接口
     * Access 2017-6-26 11:19:23
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vMob87Data", method = RequestMethod.GET)
    public VMob87Dto vMob87Data() {
        VMob87Dto dig13List = mobileService.vMob87Data();
        return dig13List;
    }


    /**
     * mobile86 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mobile86", method = RequestMethod.GET)
    public String mobile86() {
        return "mobile/mob86";
    }

    /**
     * vMob86Data 数据接口
     * Access 2017-6-26 11:19:42
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vMob86Data", method = RequestMethod.GET)
    public List<VMob86> vMob86Data() {
        List<VMob86> dig13List = mobileService.vMob86Data();
        return dig13List;
    }

    /**
     * mobile88 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mobile88", method = RequestMethod.GET)
    public String mobile88() {
        return "mobile/mob88";
    }

    /**
     * vMob88Data 数据接口
     * Access 2017-6-26 11:19:56
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vMob88Data", method = RequestMethod.GET)
    public Mob88Dto vMob88Data() {
        Mob88Dto mob88Dto = mobileService.getMob88Data();
        return mob88Dto;
    }


    /**
     * mobile91 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mobile91", method = RequestMethod.GET)
    public String mobile91() {
        return "mobile/mob91";
    }

    /**
     * vMob91Data 数据接口
     * Access  2017-6-26 11:20:24
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vMob91Data", method = RequestMethod.GET)
    public Mob91Dto vMob91Data() {
        Mob91Dto dig13List = mobileService.vMob91Data();
        return dig13List;
    }

    /**
     * mobile91 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mobile92", method = RequestMethod.GET)
    public String mobile92() {
        return "mobile/mob92";
    }

    //TODO 无数据补零暂缺
    /**
     * vMob92Data 数据接口
     * Access  2017-6-26 11:20:48
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vMob92Data", method = RequestMethod.GET)
    public Mob92Dto vMob92Data() {
        Mob92Dto dig13List = mobileService.vMob92Data();
        return dig13List;
    }

}
