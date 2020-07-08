package com.springcloudtest.scfgatewayfirstsight.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ：huabin
 * @date ：Created in 2020/7/7 20:23
 * @description： 测试熔断策略
 * @modified By：
 * @version: $ 1.0.0
 */
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "gateWayhi/{time}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHi(@PathVariable("time") long time){
        try {
            Long startTime = new Date().getTime();
            System.out.println("----睡眠开始---" + startTime);
            Thread.sleep(time);
            System.out.println("----睡眠结束---duration:" + (new Date().getTime() - startTime) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port + " get ok.";
    }

    /**
     * 发生熔断调用的请求
     * @return
     */
    @RequestMapping(value = "/fallback", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String fallback() {
        System.out.println("----触发熔断----");
        return ("error.gateway");
    }

}
