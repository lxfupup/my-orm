package com.example.orm.utils;

public class ClazzUtils {

    private ClazzUtils(){

    }
    public static Class<?> getClassType(String parameterType) throws ClassNotFoundException {
        if (parameterType != null) {
            return Class.forName(parameterType);
        }
        return null;
    }
}
