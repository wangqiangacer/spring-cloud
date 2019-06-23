package cn.itsource.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced  //负载均衡调用
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
//修改负载均衡策略   默认是轮询的
    @Bean
    public IRule myIrule(){
        return  new RandomRule();
    }
}
