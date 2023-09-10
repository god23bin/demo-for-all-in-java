package cn.god23bin.demo;

import cn.god23bin.demo.model.word.AcWordModel;
import cn.god23bin.demo.model.word.Article;
import cn.god23bin.demo.model.word.SpecialColumn;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import org.ddr.poi.html.HtmlRenderPolicy;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author god23bin
 * @created 2023/6/25 16:51
 */
@SpringBootTest
public class PoiTlApplicationTest {

    @Test
    public void test() {
        // 获取 Word 模板所在路径
        String filepath = this.getClass().getClassLoader().getResource("hello-world.docx").getPath();
        // 给标签绑定插件
        Configure configure = Configure.builder().bind("author", new HtmlRenderPolicy()).build();
        // 通过 XWPFTemplate 编译文件并渲染数据到模板中
        XWPFTemplate template = XWPFTemplate.compile(filepath, configure).render(
                new HashMap<String, Object>(){{
                    put("title", "Hello, poi-tl Word模板引擎");
                    put("text", "Hello World");
                    put("author", "<h2>god23bin</h2>");
                    put("description", "这还不关注 god23bin ？再不关注我可要求你关注了！");
                }});
        try {
            // 将完成数据渲染的文档写出
            template.writeAndClose(new FileOutputStream("output.docx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rowLoopTest() {
        // 获取数据，这里假装是从数据库中查询得到的
        AcWordModel data = getFromDB();
        // 获取 Word 模板所在路径
        String filepath = this.getClass().getClassLoader().getResource("table-row-loop.docx").getPath();
        // 给标签绑定插件，这里就绑定表格行循环的插件
        Configure configure = Configure.builder()
                .bind("articles", new HackLoopTableRenderPolicy())
                .bind("columns", new HackLoopTableRenderPolicy())
                .build();
        // 通过 XWPFTemplate 编译文件并渲染数据到模板中
        XWPFTemplate template = XWPFTemplate.compile(filepath, configure).render(data);
        try {
            // 将完成数据渲染的文档写出
            template.writeAndClose(new FileOutputStream("ac-word.docx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private AcWordModel getFromDB() {
        AcWordModel acWordModel = new AcWordModel();
        Article article1 = new Article();
        Article article2 = new Article();
        Article article3 = new Article();
        Article article4 = new Article();
        Article article5 = new Article();
        article1.setTitle("Spring 中的 Bean");
        article2.setTitle("一分钟学一个 Linux 命令 - ps");
        article3.setTitle("一分钟学一个 Linux 命令 - find 和 grep");
        article4.setTitle("一分钟学一个 Linux 命令 - cat 和 tail");
        article5.setTitle("策 略 模 式「指 鼠 为 鸭」");
        article1.setTags("后端|Java|Spring");
        article2.setTags("后端|Java|Linux");
        article3.setTags("后端|Java|Linux");
        article4.setTags("后端|Java|Linux");
        article5.setTags("后端|Java|设计模式");
        article1.setReading(835);
        article2.setReading(3477);
        article3.setReading(978);
        article4.setReading(900);
        article5.setReading(5217);
        article1.setLikes(2);
        article2.setLikes(27);
        article3.setLikes(13);
        article4.setLikes(13);
        article5.setLikes(43);

        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);

        acWordModel.setArticles(articles);

        SpecialColumn specialColumn1 = new SpecialColumn();
        SpecialColumn specialColumn2 = new SpecialColumn();
        specialColumn1.setName("一分钟学一个 Linux 命令");
        specialColumn2.setName("深入浅出 Spring 框架");
        specialColumn1.setSubscription(40);
        specialColumn2.setSubscription(1);
        specialColumn1.setNums(9);
        specialColumn2.setNums(3);

        List<SpecialColumn> specialColumns = new ArrayList<>();
        specialColumns.add(specialColumn1);
        specialColumns.add(specialColumn2);

        acWordModel.setColumns(specialColumns);
        return acWordModel;
    }

}
