package cn.god23bin.demo.model.word;

import lombok.Data;

import java.util.List;

/**
 * @author god23bin
 * @created 2023/6/25 22:43
 */
@Data
public class AcWordModel {
    /**
     * 文章明细数据模型-表格行循环
     */
    private List<Article> articles;
    /**
     * 专栏明细数据模型
     */
    private List<SpecialColumn> columns;
}
