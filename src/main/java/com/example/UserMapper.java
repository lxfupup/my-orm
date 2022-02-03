package com.example;

import java.util.List;

public interface UserMapper {

    User selectOne(User user);

    List<User> selectList();

}
