package cn.itwhy.feign.clients.fallback;

import cn.itwhy.feign.clients.UserClient;
import cn.itwhy.feign.pojo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: {NAME}
 * @Auther: why
 * @Date: 2023/07/04 11 22
 * @Version: v1.0
 */
@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User findById(Long id) {
                log.info("查询用户异常",throwable);
                return new User();
            }
        };
    }
}
