package com.springcloudtest.serviceribbon.controller;

import com.springcloudtest.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：huabin
 * @date ：Created in 2020/6/2 17:51
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class HiController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String getRsp(@RequestParam String name){
        return helloService.hiService(name);
    }

}
