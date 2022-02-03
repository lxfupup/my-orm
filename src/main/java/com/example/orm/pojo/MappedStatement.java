package com.example.orm.pojo;

/**
 * SQL语句、statement类型、输入参数Java类型、输出参数Java类型
 *
 * @author leotoa
 */
public class MappedStatement {

    /**
     * id
     */
    private String id;

    /**
     * SQL语句
     */
    private String sql;

    /**
     * 参数类型
     */
    private String parameterType;

    /**
     * 结果类型
     */
    private String resultType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
