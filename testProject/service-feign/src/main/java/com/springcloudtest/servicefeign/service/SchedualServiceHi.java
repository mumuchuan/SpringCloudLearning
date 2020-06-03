package com.springcloudtest.servicefeign.service;

import com.springcloudtest.servicefeign.service.hystrixImpl.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：huabin
 * @date ：Created in 2020/6/2 19:18
 * @description：
 * @modified By：
 * @version: $
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam String name);

}
