package com.springcloudtest.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：huabin
 * @date ：Created in 2020/7/9 14:50
 * @description：
 * @modified By：
 * @version: $
 */
@FeignClient(value = "service-hello")
public interface SchedualServiceHello {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHelloFromClientOne(@RequestParam String name);

}
