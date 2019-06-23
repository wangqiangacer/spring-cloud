package cn.itsource.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/7 17:25
 */
@SpringBootApplication
@EnableEurekaClient
public class User_Provider_Application_8004 {
    public static void main(String[] args) {
        SpringApplication.run(User_Provider_Application_8004.class);
    }
}
