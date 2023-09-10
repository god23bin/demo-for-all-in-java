package cn.god23bin.demo.json.fastjson;

import cn.god23bin.demo.common.Result;
import cn.god23bin.demo.model.entity.Game;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author god23bin
 * @created 2023/5/27 20:01
 */
public class Main {

    public static void main(String[] args) {
        multiGenericTest();
    }

    static void mainTest() {
        Game game = Game.builder().name("GTA5").price(new BigDecimal("54.5")).build();

        Result<Game> gameResult = new Result<>();
        gameResult.setCode(1);
        gameResult.setMsg("操作成功");
        gameResult.setData(game);

        // 假设这里的 result 是后端返回的响应体中的 JSON 格式的字符串
        String result = JSONObject.toJSONString(gameResult);
        // 这个 Result 对象是嵌套泛型的，显然，下方这个是行不通的
        // JSONObject.parseObject(result, Result<Game>.class);
        Result<Game> answer = JSONObject.parseObject(result, new TypeReference<Result<Game>>(Game.class) {});
        System.out.println(answer);
    }

    static void multiGenericTest() {
        Game game = Game.builder().name("GTA5").price(new BigDecimal("54.5")).build();

        Result<Game> gameResult1 = new Result<>();
        gameResult1.setCode(1);
        gameResult1.setMsg("操作成功");
        gameResult1.setData(game);

        Result<Game> gameResult2 = new Result<>();
        gameResult2.setCode(-1);
        gameResult2.setMsg("操作失败");
        gameResult2.setData(game);


        List<Result<Game>> list = new ArrayList<>();
        list.add(gameResult1);
        list.add(gameResult2);
        String json = JSONObject.toJSONString(list);

        List<Result<Game>> answer = JSONObject.parseObject(json, new TypeReference<List<Result<Game>>>() {});

        System.out.println(answer);
    }

    private <T> Result<T> handle(String result, Class<T> clazz) {
        return JSONObject.parseObject(result, new TypeReference<Result<T>>(clazz) {});
    }
}
