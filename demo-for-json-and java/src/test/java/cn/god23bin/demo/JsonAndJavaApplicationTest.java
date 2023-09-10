package cn.god23bin.demo;

import cn.god23bin.demo.model.entity.Game;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author god23bin
 * @created 2023/5/27 19:28
 */
@SpringBootTest
public class JsonAndJavaApplicationTest {

    @Test
    public void jacksonTest() throws JsonProcessingException {
        String jsonStr = "{\"name\" : \"GTA5\", \"price\" : 54.5}";
        Game game1 = Game.builder().name("NBA2K23").price(new BigDecimal("198.0")).build();
        Game game2 = Game.builder().name("Sim City4").price(new BigDecimal("22.5")).build();
        List<Game> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);

        ObjectMapper objectMapper = new ObjectMapper();

        // 将 JSON 字符串 转成 Java 对象
        Game game = objectMapper.readValue(jsonStr, Game.class);
        // 将 Java 对象转成 JSON 字符串
        String gameJson = objectMapper.writeValueAsString(game);

        // 将 List<Game> 转成 JSON 字符串
        String gameListJson = objectMapper.writeValueAsString(gameList);
        // 将 JSON 字符串 转成 List<Game>
        List<Game> gameListFromJson = objectMapper.readValue(gameListJson, new TypeReference<List<Game>>() {});
    }

    @Test
    public void fastjsonTest() {
        String jsonStr = "{\"name\" : \"GTA5\", \"price\" : 54.5}";
        Game game1 = Game.builder().name("NBA2K23").price(new BigDecimal("198.0")).build();
        Game game2 = Game.builder().name("Sim City4").price(new BigDecimal("22.5")).build();
        List<Game> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);

        // 将 JSON 字符串 转成 Java 对象
        Game game = JSONObject.parseObject(jsonStr, Game.class);
        // 将 Java 对象转成 JSON 字符串
        String gameJson = JSONObject.toJSONString(game);

        // 将 List<Game> 转成 JSON 字符串
        String gameListJson = JSONObject.toJSONString(gameList);
        // 将 JSON 字符串 转成 List<Game>
        // fastjson 1.2.x 版本：List<Game> gameListFromJson = JSONObject.parseArray(gameListJson, Game.class);
        List<Game> gameListFromJson = JSONArray.parseArray(gameListJson).toJavaList(Game.class);
    }

    @Test
    public void gsonTest() {
        String jsonStr = "{\"name\" : \"GTA5\", \"price\" : 54.5}";
        Game game1 = Game.builder().name("NBA2K23").price(new BigDecimal("198.0")).build();
        Game game2 = Game.builder().name("Sim City4").price(new BigDecimal("22.5")).build();
        List<Game> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);

        Gson gson = new Gson();

        // 将 JSON 字符串 转成 Java 对象
        Game game = gson.fromJson(jsonStr, Game.class);
        // 将 Java 对象转成 JSON 字符串
        String gameJson = gson.toJson(game);

        // 将 List<Game> 转成 JSON 字符串
        String gameListJson = gson.toJson(gameList);
        // 将 JSON 字符串 转成 List<Game>
        List<Game> gameListFromJson = gson.fromJson(gameListJson, new TypeToken<List<Game>>() {}.getType());
    }

    @Test
    public void hutoolTest() {
        String jsonStr = "{\"name\" : \"GTA5\", \"price\" : 54.5}";
        Game game1 = Game.builder().name("NBA2K23").price(new BigDecimal("198.0")).build();
        Game game2 = Game.builder().name("Sim City4").price(new BigDecimal("22.5")).build();
        List<Game> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);

        // 将 JSON 字符串 转成 Java 对象
        Game game = JSONUtil.toBean(jsonStr, Game.class);
        // 将 Java 对象转成 JSON 字符串
        String gameJson = JSONUtil.toJsonStr(game);

        // 将 List<Game> 转成 JSON 字符串
        String gameListJson = JSONUtil.toJsonStr(gameList);
        // 将 JSON 字符串 转成 List<Game>
        List<Game> gameListFromJson = JSONUtil.toList(gameListJson, Game.class);
    }
}
