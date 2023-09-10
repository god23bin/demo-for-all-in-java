package cn.god23bin.demo.model.word;

import lombok.Data;

/**
 * @author god23bin
 * @created 2023/6/25 22:45
 */
@Data
public class Article {
    private String title;
    private String tags;
    private Integer reading;
    private Integer likes;
}
