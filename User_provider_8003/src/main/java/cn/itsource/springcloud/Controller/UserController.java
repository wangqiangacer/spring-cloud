package cn.itsource.springcloud.Controller;

import cn.itsource.springcloud.domain.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/7 17:29
 */
@RequestMapping("/provider")
@RestController
public class UserController {
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){
        return  new User(id,"wangqiang_provider2");

    }
}
