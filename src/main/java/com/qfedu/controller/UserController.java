package com.qfedu.controller;

import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("user")
public class UserController {
    UserService userService = new UserServiceImpl();

}
