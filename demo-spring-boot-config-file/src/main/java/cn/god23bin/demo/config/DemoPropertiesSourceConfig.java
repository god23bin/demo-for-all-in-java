package cn.god23bin.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 读取自定义的配置文件中的值
 * @author god23bin
 * @created 2023/3/23 0:36
 */
@Data
@Configuration
@PropertySource("classpath:custom.yml")
public class DemoPropertiesSourceConfig {

    @Value("${version}")
    private String version;

    @Value("${description}")
    private String description;

}
