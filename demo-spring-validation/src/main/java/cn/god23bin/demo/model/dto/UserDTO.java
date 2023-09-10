package cn.god23bin.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author god23bin
 * @created 2023/2/18 19:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotBlank(message = "电子邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    @Negative(message = "钱不能为正数")
    private Integer money;

    @Positive(message = "技能数量不能为负数")
    private Integer skill;

    @NotNull(message = "内容不能为空")
    @Length(min = 1, max = 10, message = "长度的最小为1，最大为10")
    private String content;

    @Max(value = 255, message = "基本线最大值必须小于或等于255")
    @Min(value = 10, message = "基本线最小值必须大于或等于10")
    private Integer baseLine;

}
