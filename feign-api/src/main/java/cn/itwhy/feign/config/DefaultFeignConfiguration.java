package cn.itwhy.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/06/09 11:35
 * 使用类管理Feign的日志方式
 */
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.BASIC;
    }
}
