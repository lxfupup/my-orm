package com.example.orm;

import com.example.User;
import com.example.UserMapper;
import com.example.orm.io.Resources;
import com.example.orm.sqlsession.SQlSessionFactoryBuilder;
import com.example.orm.sqlsession.SqlSession;
import com.example.orm.sqlsession.SqlSessionFactory;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class ORMTest {

    @Test
    public void test() throws PropertyVetoException, DocumentException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SQlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(2);
        user.setUsername("tom");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = userMapper.selectOne(user);

        System.out.println(u);
    }
}
