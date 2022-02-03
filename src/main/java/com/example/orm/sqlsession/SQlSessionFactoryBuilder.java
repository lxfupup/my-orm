package com.example.orm.sqlsession;

import com.example.orm.config.XMLConfigurationBuilder;
import com.example.orm.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * 解析配置文件
 * <p>
 * 1. 使⽤dom4j解析配置⽂件，将解析出来的内容封装到Configuration和MappedStatement中
 * 2. 创建SqlSessionFactory的实现类DefaultSqlSession
 *
 * @author leotoa
 */
public class SQlSessionFactoryBuilder {

    private final Configuration configuration;

    public SQlSessionFactoryBuilder() {
        this.configuration = new Configuration();
    }

    public SqlSessionFactory build(InputStream inputStream) throws PropertyVetoException, DocumentException {
        //解析配置文件，封装Configuration
        XMLConfigurationBuilder xmlConfigurationBuilder =
                new XMLConfigurationBuilder(configuration);
        Configuration configuration = xmlConfigurationBuilder.parseConfiguration(inputStream);

        //创建SqlSessionFactory
        return new DefaultSqlSessionFactory(configuration);
    }

}
