package cn.god23bin.demo.util;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author god23bin
 * @created 2023/6/25 23:28
 */
public class WordUtil {

    /**
     * 生成 word 文档
     * @param wordTemplatePath    word 模板路径
     * @param targetWordFilePath  生成目标文档路径
     * @param data                待渲染的数据模型-哈希表形式
     */
    public static void generateWordFile(String wordTemplatePath, String targetWordFilePath, Map<String, Object> data) {
        XWPFTemplate template = XWPFTemplate.compile(wordTemplatePath).render(data);
        try {
            template.writeAndClose(new FileOutputStream(targetWordFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成 word 文档
     * @param wordTemplatePath    word 模板路径
     * @param targetWordFilePath  生成目标文档路径
     * @param data                待渲染的数据模型-Java对象形式
     */
    public static void generateWordFile(String wordTemplatePath, String targetWordFilePath, Object data) {
        XWPFTemplate template = XWPFTemplate.compile(wordTemplatePath).render(data);
        try {
            template.writeAndClose(new FileOutputStream(targetWordFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成 word 文档
     * @param wordTemplatePath    word 模板路径
     * @param targetWordFilePath  生成目标文档路径
     * @param data                待渲染的数据模型-哈希表形式
     * @param configure           渲染配置
     */
    public static void generateWordFile(String wordTemplatePath, String targetWordFilePath, Map<String, Object> data, Configure configure) {
        XWPFTemplate template = XWPFTemplate.compile(wordTemplatePath, configure).render(data);
        try {
            template.writeAndClose(new FileOutputStream(targetWordFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成 word 文档
     * @param wordTemplatePath    word 模板路径
     * @param targetWordFilePath  生成目标文档路径
     * @param data                待渲染的数据模型-Java对象形式
     * @param configure           渲染配置
     */
    public static void generateWordFile(String wordTemplatePath, String targetWordFilePath, Object data, Configure configure) {
        XWPFTemplate template = XWPFTemplate.compile(wordTemplatePath, configure).render(data);
        try {
            template.writeAndClose(new FileOutputStream(targetWordFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
