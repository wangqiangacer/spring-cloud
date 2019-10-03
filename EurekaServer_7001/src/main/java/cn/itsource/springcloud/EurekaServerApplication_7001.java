package cn.itsource.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 为了保证eureka高可用，必须搭建eureka集群，多台注册中心相互注册，
 * 当一台（主）注册中心宕机之后，会自动转移（备）注册中心
 *
 * 可以使用Consul 或者zookeeper 作为注册中心
 *
 *
 * 使用zookeeper替代注册中心  分布式协调工具 可以实现注册中心，采用临时节点类型
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication_7001.class);
    }
}
