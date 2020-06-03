package com.springcloudtest.servicefeign.service.hystrixImpl;

import com.springcloudtest.servicefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author ：huabin
 * @date ：Created in 2020/6/3 11:59
 * @description：熔断器回调
 * @modified By：
 * @version: $
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
