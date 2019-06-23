package cn.itsource.springcloud.Client;

import cn.itsource.springcloud.domain.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/8 16:10
 */
@Component
public class UserClientHystrixFallbackFactory implements FallbackFactory<UserClient> {//对哪一个接口托底处理
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User getUser(Long id) {
                return new User(id,"出异常了！！！！");
            }
        };
    }
}
