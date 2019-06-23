package cn.itsource.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/7 17:25
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix  //开启断路器
public class User_Provider_Application_8001 {
    public static void main(String[] args) {
        SpringApplication.run(User_Provider_Application_8001.class);
    }
}
