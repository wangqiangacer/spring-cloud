package cn.itsource.springcloud.Client;

import cn.itsource.springcloud.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient(value = "USER-PROVIDER",fallbackFactory = UserClientHystrixFallbackFactory.class)
@RequestMapping("/provider")
public interface UserClient {

    @RequestMapping("/user/{id}")
    User getUser(@PathVariable("id") Long id);
}
