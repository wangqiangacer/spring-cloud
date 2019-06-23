package cn.itsource.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/7 20:40
 */
@Configuration
public class CfgBean {

    @Bean
     //负载均衡调用
    public RestTemplate getRestTemplate()  {
        return  new RestTemplate();
    }
}
