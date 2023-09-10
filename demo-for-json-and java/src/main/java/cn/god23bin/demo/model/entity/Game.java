package cn.god23bin.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author god23bin
 * @created 2023/5/27 19:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {
    private String name;
    private BigDecimal price;
}
