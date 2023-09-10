package cn.god23bin.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author god23bin
 * @created 2023/2/21 23:47
 */
@WebServlet(name = "JdbcServlet", urlPatterns = "/jdbc")
public class JdbcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = getConnection();
        String sql = req.getParameter("sql");
        String name = req.getParameter("book_name");
        String price = req.getParameter("book_price");
        String author = req.getParameter("book_author");
        try {
            // 获取 PreparedStatement 对象
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(0, name);
            ps.setDouble(1, Double.parseDouble(price));
            ps.setString(2, author);
            // 执行更新操作（增删改都用这个），返回所影响的行数
            int count = ps.executeUpdate();
            if (count > 0) {
                PrintWriter out = resp.getWriter();
                out.println("成功添加了 " + count + " 条数据！");
            }
            // 关闭就可以释放资源了
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /**
     * 加载数据库驱动，并获取数据库连接对象
     * @return 数据库连接对象
     */
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql//localhost:3306/demo-jdbc";
            String username = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
