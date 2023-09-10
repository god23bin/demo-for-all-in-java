package cn.god23bin.demo.controller;

import cn.god23bin.demo.model.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author god23bin
 * @created 2023/2/18 19:08
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok("User 验证通过");
    }

    /**
     * 该方法将每个无效字段的名称和验证后错误消息存储在 Map 中
     * 并将 Map 作为 JSON 表示形式发送回前端，交给前端进一步处理
     * @param ex MethodArgumentNotValidException 异常
     * @return 返回 JSON 格式的 MAP
     **/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
