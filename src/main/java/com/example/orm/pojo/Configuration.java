package com.example.orm.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 存放数据库基本信息    Map<唯一标识,Mapper> 唯一标识：namespace + "." + id
 *
 * @author leotoa
 */
public class Configuration {

    /**
     * 数据源
     */
    private DataSource dataSource;
    /**
     * map集合: key:statementId value:MappedStatement
     */
    private Map<String, MappedStatement> mappedStatementMap =
            new HashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }
}
