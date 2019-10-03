package com.qfedu.service;

import com.qfedu.entity.User;

public interface UserService {
    int selectByPhoneNum(String phoneNumber);

    User selectUserByPhone();
}
