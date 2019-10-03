package com.qfedu.service;

import com.qfedu.entity.User;

public interface UserService {
    //通过邮箱查询指定用户
    User selectUserByEmail(String userEmail);

    void insertEmail(String userEmail);

    int selectByEmail(String userEmail);

}
