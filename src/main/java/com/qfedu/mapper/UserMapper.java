package com.qfedu.mapper;

import com.qfedu.entity.User;

public interface UserMapper {
    void insertEmail(String userEmail);

    int selectByEmail(String userEmail);

    User selectUserByEmail(String userEmail);
}
