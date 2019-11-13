package cn.itsource.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/7 20:40
 *
 *
 * 使用spring-retry  实现服务调用超时切换实例
 */
@SpringBootApplication
@EnableEurekaClient
@EnableRetry  //spring 重试请求  远程调用失败后在次进行调用
public class UserConsumerApplication_9002 {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication_9002.class);
    }
}
