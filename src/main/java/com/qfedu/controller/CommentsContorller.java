package com.qfedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentsContorller {


    @RequestMapping("list")
    public String list(){
        return "";
    }
    @RequestMapping("/addComments")
    public String addComments(){
        return "";
    }
}
