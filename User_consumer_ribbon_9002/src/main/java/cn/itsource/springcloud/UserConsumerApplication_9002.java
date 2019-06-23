package cn.itsource.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/7 20:40
 */
@SpringBootApplication
@EnableEurekaClient
public class UserConsumerApplication_9002 {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication_9002.class);
    }
}
