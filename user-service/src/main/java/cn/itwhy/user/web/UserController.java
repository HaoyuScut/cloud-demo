package cn.itwhy.user.web;

import cn.itwhy.user.config.PatternProperties;
import cn.itwhy.user.pojo.User;
import cn.itwhy.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @Autowired
    private PatternProperties properties;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println("truth:" + truth);
        return userService.queryById(id);
    }

    /**
     * 测试nacos配置管理
     * @return
     */
    @GetMapping("/now")
    public String now() {
        return LocalDateTime.now()
                .format(DateTimeFormatter
                        .ofPattern(properties.getDateformat()));
    }

    @GetMapping("/prop")
    public PatternProperties properties(){
        return properties;
    }
}
