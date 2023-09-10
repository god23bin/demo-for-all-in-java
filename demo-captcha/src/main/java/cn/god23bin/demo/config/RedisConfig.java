package cn.god23bin.demo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author god23bin
 * @created 2023/6/6 21:04
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 大多数情况，都是选用<String, Object>
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // 使用JSON的序列化对象，对数据 key 和 value 进行序列化转换
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        // ObjectMapper 是 Jackson 的一个工作类，作用是将 JSON 转成 Java 对象，即反序列化。或将 Java 对象转成 JSON，即序列化
        ObjectMapper mapper = new ObjectMapper();
        // 设置序列化时的可见性，第一个参数是选择序列化哪些属性，比如时序列化 setter? 还是 filed? 第二个参数是选择哪些修饰符权限的属性来序列化，比如 private 或者 public，这里的 any 是指对所有权限修饰的属性都可见(可序列化)
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        jackson2JsonRedisSerializer.setObjectMapper(mapper);
        // 设置 RedisTemplate 模板的序列化方式为 jacksonSeial
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        return template;
    }

}
