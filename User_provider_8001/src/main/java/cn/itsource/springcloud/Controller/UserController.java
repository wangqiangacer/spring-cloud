package cn.itsource.springcloud.Controller;

import cn.itsource.springcloud.Client.UserClient;
import cn.itsource.springcloud.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**使用熔断降级处理  服务调用失败之后，会调用fallbackMethod
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/7 17:29
 */
@RequestMapping("/provider")
@RestController

public class UserController  implements UserClient{
    //@HystrixCommand(fallbackMethod = "getUserFailBack")
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){
        System.out.println("get user  retry.... ");
        if(id==2){
            throw  new RuntimeException("用户不存在！！！");
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  new User(id,"wangqiang1111");

    }

    public  User getUserFailBack(Long id){
        return  new User(id,"出异常了，请联系管理员！！！！");
    }
}
