package com.example.orm.sqlsession;

import com.example.orm.pojo.Configuration;
import com.example.orm.pojo.MappedStatement;


import java.util.List;

public interface Executor {
    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;
}
