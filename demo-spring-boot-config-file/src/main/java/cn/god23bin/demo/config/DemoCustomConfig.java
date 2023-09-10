package cn.god23bin.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author god23bin
 * @created 2023/3/22 23:16
 */
@Data
@Component
public class DemoCustomConfig {

    /**
     * 通过 @Value 注解读取配置文件中的自定义配置项的值，使用 ${} 进行读取
     **/
    @Value("${demo.author}")
    private String author;

    @Value("${demo.description}")
    private String description;

    @Value("${great.game}")
    private String greatGame;

}
