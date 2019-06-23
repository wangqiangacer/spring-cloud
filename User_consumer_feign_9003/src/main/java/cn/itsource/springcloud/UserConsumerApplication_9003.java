package cn.itsource.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/7 20:40
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "cn.itsource.springcloud")
@EnableHystrixDashboard
public class UserConsumerApplication_9003 {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication_9003.class);
    }


    //开启熔断器监控功能
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean bean = new ServletRegistrationBean(servlet);
        bean.setLoadOnStartup(1);
        bean.addUrlMappings("/hystrix.stream");
        bean.setName("HystrixMetricsStreamServlet");
        return  bean;
    }
}
