/*
package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.util.MailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserService userService;

    @RequestMapping(value = "owLogin")
    @ApiOperation(value = "该接口是登陆方法",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone",value = "邮箱",required = true,dataType = "string"),

    })
    public String showLogin(){
        return "before/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    */
/**
     * 用户登录
     *//*

    @ApiOperation(value = "该方法是用户登陆入口",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone",value = "手机号",required = true,dataType = "string"),
            @ApiImplicitParam(name = "code",value = "验证码",required = true,dataType = "string")
    })
    public String login(String userPhone, Model model,String userEmail){
        User user = userService.selectUserByuserEmial(userEmail);

        model.addAttribute("nickName",user.getNickName());
//        model.addAttribute("userPhone",userPhone);
        return "beforeouye";
    }

    @RequestMapping(value = "alidatePhone",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证手机号",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone",value = "手机号",required = true,dataType = "string"),

    })
    //此处尚未验证
    public String validatePhone(String userEmail){
        int result = userService.selectByuserEmail(userEmail);
        return  result>0 ?"success":"fail";
    }
    @RequestMapping(value = "ndEmailValidate",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "该接口是发送验证码",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone",value = "手机号",required = true,dataType = "string"),

    })
    public String sendEmailValidate(String userEmail,HttpSession session){
        System.out.println("老子进来了哈哈哈++++++++++++++++++++++++++++++");
//       int result =  userService.selectByPhoneNum(email);
        String sessionCode = MailUtils.getRandomNumCode(5);
        System.out.println(sessionCode);
        session.setAttribute("sessionCode",sessionCode);
        session.setMaxInactiveInterval(120);
        MailUtils.sendMail(userEmail,"您的登陆验证码是："+sessionCode+"请在2分钟内完成操作","男人帮安全中心");
        return "success";

    }
    @RequestMapping(value = "alidateCode",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证验证码",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "验证码",required = true,dataType = "string"),

    })
    public String validateCode(String code,HttpSession session,String userEmail){
        System.out.println("2["+code+"]code");
        String sessionCode = (String) session.getAttribute("sessionCode");
        System.out.println("1"+sessionCode+":validateCode");

        boolean flag = sessionCode.equals(code);
        System.out.println(flag);
        if(flag){
            int result = userService.selectByuserEmail(userEmail);
            if (result < 0) {userService.insertEmail(userEmail);
            }

            return "success";
        }else{
            return "fail";
        }
    }


}
*/
