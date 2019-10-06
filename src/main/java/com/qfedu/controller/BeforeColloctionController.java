package com.qfedu.controller;

import com.qfedu.entity.Collocation;
import com.qfedu.service.CollocationService;
import com.qfedu.util.InfoUtils;
import com.qfedu.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/collocation")
@CrossOrigin(value = "*",maxAge = 3600)
public class BeforeColloctionController {
    @Autowired
    CollocationService collocationService;
    @RequestMapping("/list")
    public String list(Integer id, Model model){
        Collocation collocation = collocationService.selectCollocationById(id);
        collocation.setCollocationImg(InfoUtils.getProperties("IMG_URL")+collocation.getCollocationImg());
        model.addAttribute("collocation",collocation);
        return "before/wenzhang";
    }
    @RequestMapping("/chuanda")
    public String chuanDa(){
        return "before/chuanda";
    }
    @RequestMapping("/listAll")
    public void listAll(HttpServletResponse response){
        List<Collocation> collocationList = collocationService.selectCollocationAll();


        try {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(JsonUtils.objectToJson(collocationList));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
