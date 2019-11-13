package cn.itsource.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
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
        return  new RestTemplate(factory());
    }

    @Bean
    @ConfigurationProperties(prefix = "custom.rest")
    public  HttpComponentsClientHttpRequestFactory factory(){
        //        HttpComponentsClientHttpRequestFactory factory=new HttpComponentsClientHttpRequestFactory();
//        factory.setConnectionRequestTimeout(250);//连接超时
//        factory.setConnectTimeout(1000);
//        factory.setReadTimeout(3000);
        return  new HttpComponentsClientHttpRequestFactory();
    }


//修改负载均衡策略   默认是轮询的
    // 使用restTemplate实现  服务之间的调用的负载均衡
    @Bean
    public IRule myIrule(){
        return  new RoundRobinRule();
    }
}
