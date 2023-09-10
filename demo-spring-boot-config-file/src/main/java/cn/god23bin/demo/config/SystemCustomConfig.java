package cn.god23bin.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author god23bin
 * @created 2023/3/22 23:18
 */
@Data
@Component
@ConfigurationProperties("system.demo")
public class SystemCustomConfig {

    private String name;

    private String version;

}
