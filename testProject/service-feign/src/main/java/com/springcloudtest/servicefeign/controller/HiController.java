package com.springcloudtest.servicefeign.controller;

import com.springcloudtest.servicefeign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：huabin
 * @date ：Created in 2020/6/2 19:21
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class HiController {

    @Autowired
    private SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi")
    public String getRsp(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }

}
