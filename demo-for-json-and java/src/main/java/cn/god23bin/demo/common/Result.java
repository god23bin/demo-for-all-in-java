package cn.god23bin.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author god23bin
 * @created 2023/5/27 19:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> ok() {
        return ok(null);
    }

    public static <T> Result<T> fail() {
        return fail(null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(1, "操作成功！", data);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(-1, "操作失败！", data);
    }

}
