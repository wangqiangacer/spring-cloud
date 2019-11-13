package cn.itsource.springcloud.Controller;

import cn.itsource.springcloud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
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





    @RequestMapping("/call")
    //重试value:什么样的异常进行异常处理  maxAttemptes:重试的次数
    @Retryable(value = RemoteAccessException.class,
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000,multiplier = 2))// delay :没歌5s中重试时间间隔  multiplier 多少个执行者 并发
    public  void  call() throws Exception{
        System.out.println("调用了call方法  执行。。。。。");
        throw  new RemoteAccessException("RPC 调用异常");
    }

    /**
     * 做最终的补偿机制
     * @param e
     */
    @Recover
    public  void  recover(RemoteAccessException e){
        System.out.println("---做最终的补偿机制--"+e.getMessage());
    }
}
