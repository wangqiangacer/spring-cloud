package cn.itsource.springcloud.Controller;

import cn.itsource.springcloud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/7 17:39
 */
@RestController
@RequestMapping("/consumer")
public class UserController {

    //多个方法调用只需改一处就ok  通过注册中心获取服务名 ，负载均衡调用服务列表
    public static  final String URL_PREFIX = "http://USER-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id")Long id){
        //调用远程服务 http请求
        String url = URL_PREFIX+"/provider/user/"+id;
        User user = restTemplate.getForObject(url, User.class);
        System.out.println("============");
        return user;
    }
}
