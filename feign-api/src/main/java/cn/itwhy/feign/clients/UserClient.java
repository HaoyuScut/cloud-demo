package cn.itwhy.feign.clients;


import cn.itwhy.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/06/09 11:20
 */
@FeignClient(value = "userservice"/*, configuration = DefaultFeignConfiguration.class*/)
public interface UserClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
