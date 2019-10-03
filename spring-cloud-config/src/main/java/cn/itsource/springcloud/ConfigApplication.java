package cn.itsource.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/23 20:47
 *
 *
 *
 * 2.分布式配置中心设计思想：在微服务当中使用同一个服务器管理所有服务的配置文件信息，能后实现后台可以管理，当服务器正在运行的时候，如果配置文件需要发生改变，可以实现不需要重启服务器实时更改配置文件信息
 * 组件：configServer从git环境上读取配置文件缓存到jvm本地中，configClient从configServer中读取配置文件
 * 2.1搭建分布式配置中心的步骤：
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class);
    }
}
