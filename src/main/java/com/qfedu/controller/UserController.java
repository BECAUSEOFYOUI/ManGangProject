package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;
import com.qfedu.util.MailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")

@Api(value = "用户操作",tags = "用户操作接口，比如说登录，注册等")
public class UserController {
    UserService userService = new UserServiceImpl();

    @RequestMapping(value = "/showLogin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "该接口是发送验证码",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone",value = "手机号",required = true,dataType = "string"),

    })
    public String showLogin(){
        return "before/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    /**
     * 用户登录
     */
    @ApiOperation(value = "该方法是用户登陆入口",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone",value = "手机号",required = true,dataType = "string"),
            @ApiImplicitParam(name = "code",value = "验证码",required = true,dataType = "string")
    })
    public String login(String userPhone, Model model){
        User user = userService.selectUserByPhone();

        model.addAttribute("nickName",user.getNickName());
        model.addAttribute("userPhone",userPhone);
        return "before/shouye";
    }

    @RequestMapping(value = "/validatePhone",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证手机号",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone",value = "手机号",required = true,dataType = "string"),

    })
    public String validatePhone(String userPhone){
        int result = userService.selectByPhoneNum(userPhone);
        return "success";
    }
    @RequestMapping(value = "/sendPhoneValidate",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "该接口是发送验证码",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone",value = "手机号",required = true,dataType = "string"),

    })
    public String sendPhoneValidate(String userPhone, HttpSession session){

       int result =  userService.selectByPhoneNum(userPhone);
       if(result>0){
           String sessionCode = MailUtils.achieveCode();
           System.out.println(sessionCode);
           session.setAttribute("sessionCode",sessionCode);
           session.setMaxInactiveInterval(120);
           return "success";
       }
        return "fail";
    }
    @RequestMapping(value = "/validateCode",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证验证码",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "验证码",required = true,dataType = "string"),

    })
    public String validateCode(String code,HttpSession session){
        System.out.println("2["+code+"]code");
        String sessionCode = (String) session.getAttribute("sessionCode");
        System.out.println("1"+sessionCode+":validateCode");

        boolean flag = sessionCode.equals(code);
        System.out.println(flag);
        if(flag){
            return "success";
        }else{
            return "fail";
        }
    }


}
