package com.github.books.javacore2.chapterDemo;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author lujiewei
 * Create on 2023/12/4
 */
public class TestJDBC {
    public static void main(String[] args) throws Exception {

        // 1.注册驱动 加载驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.获得连接

        var properties = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("src\\main\\resources\\database.properties"))) {
            properties.load(in);
        }
        String drivers = properties.getProperty("jdbc.drivers");
        if (drivers != null) System.setProperty("jdbc.drivers", drivers);
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");

        Connection connection = DriverManager.getConnection(url, username, password);

        // 3.获得执行SQL语句的对象
        Statement start = connection.createStatement();

        // 4.编写SQL语句，执行SQL语句
        String sql = "insert into stu_1(stu_num,stu_name,stu_gender,stu_age,stu_phone) values('20231204','lujiewei','男','22',12345678901)";
        int result = start.executeUpdate(sql);

        try (ResultSet rs = start.executeQuery("select * from stu_1")) {
            while (rs.next()) {
                System.out.println(rs.getString("stu_age"));
            }
        }
        start.executeUpdate("delete from stu_1");
        // 5.处理结果
//        System.out.println(result);
        if (result == 1) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }

        // 6.释放资源
        start.close();
        connection.close();
    }
}
