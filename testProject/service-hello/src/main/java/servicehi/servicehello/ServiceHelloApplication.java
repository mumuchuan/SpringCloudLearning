package servicehi.servicehello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class ServiceHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHelloApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "helloError")
    public String home(@RequestParam(value = "name", defaultValue = "zoppon") String name) {
        return "hello " + name + " ,i am from port:" + port;
    }

    @RequestMapping(value = "hello/{time}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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

    public String helloError(String name) {
        return "hello,"+name+",sorry,error!";
    }

}
