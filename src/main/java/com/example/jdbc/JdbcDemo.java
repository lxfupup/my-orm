package com.example.jdbc;

import com.example.User;

import java.sql.*;

/**
 * JDBC Demo
 * <p>
 * 原始JDBC开发存在的问题:
 * <p>
 * 1. 数据库的连接创建、释放、频繁造成系统资源浪费 影响系统系统
 * 2. SQL语句在代码中硬编码，造成代码不易维护，实际应用SQL变化的可能性大，SQL变动需要改变Java代码
 * 3. 使用preparedStatement向占有位符号穿参存在硬编码，因为SQL语句的where条件不一定，可能多也可能少，修改SQL还要修改代码，系统不易维护
 * 4. 对结果解析存在硬编码(查询列表)，SQL变化导致解析代码变化，系统不易维护，如果能将数据库记录封装成pojo对象解析比较方便
 * <p>
 * 问题解决思路:
 * 1. 使用数据库连接池初始化连接资源
 * 2. 将sql语句抽取到xml配置文件中
 * 3. 使用反射、内省等底层技术，自动将实体与表进行属性与字段的自动映射
 *
 * @author leotoa
 */
public class JdbcDemo {

    private final static String URL = "jdbc:mysql://localhost:3306/orm?characterEncoding=utf-8";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //加载数据库驱动
            // Class.forName("com.mysql.jdbc.Driver");

            //通过驱动管理类获取数据库链接
            connection = DriverManager.getConnection(URL, "root", "123456");
            String sql = "select * from user where username = ?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql语句中参数的序号（从1开始）,第二个参数为设置的参数值
            preparedStatement.setString(1, "tom");
            //向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历查询结果集
            User user;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                //封装User
                user = new User();
                user.setId(id);
                user.setUsername(username);

                System.out.println(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
