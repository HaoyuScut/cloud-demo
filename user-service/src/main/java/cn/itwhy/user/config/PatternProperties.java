package cn.itwhy.user.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/06/08 22:25
 * 本地 < 远端userservice < 远端dev
 * 服务名-profile.yaml > 服务名称.yaml > 本地配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String dateformat;
    private String envSharedValue;
    private String name;
}
