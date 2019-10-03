package com.jacken.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式配置中心首先从git远端代码仓库中读取配置文件到configserver中，configClient再从configServer中读取配置文件  接下来就是
 * 如何刷新的问题：自动刷新的问题如何处理 client不能及时从server中读取配置文件 因为有缓存
 *
 * 有两种方式解决：手动刷新（监控中心：actuator）自动刷新（消息总线进行实时通知springcloudbus）
 *@RefreshScope 可以使用这个注解实时从configserver中刷新配置文件  使用postman发送请求 调用接口actutor/refresh
 *  从configServer中拉去最新修改的配置文件信息
 *
 *
 *
 *
 */
@RestController
@RefreshScope //开启刷新
public class UserController {
    @Value("${server.port}")
    public  String port;
    @RequestMapping("/getUser")
    public  String getUser(){
        return "configClient fetching configServer getPort:"+port;
    }
}
