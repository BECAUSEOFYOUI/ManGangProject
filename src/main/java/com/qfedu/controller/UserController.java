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

    @RequestMapping(value = "/showLogin")

    @ApiOperation(value = "页面跳转登陆窗口",notes = "接口描述")
    public String showLogin(){
        return "before/login";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "该方法是用户登陆入口,不需要传值只负责登陆给首页传数据",notes = "接口描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userEmail",value = "获取输入邮箱在个人中心展示",required = true,dataType = "string"),
    })

    public String login(String userEmail, Model model){
        System.out.println("这是一个测试+++++++++");
        System.out.println(userEmail);
        User user = userService.selectUserByEmail(userEmail);
        System.out.println(user.getUserEmail()+"+++++++++++++++++++++++++++++_________________________");
        model.addAttribute("nickName",user.getNickName());
        model.addAttribute("userEmail",userEmail);
        return "before/shouye";
    }

    /*@RequestMapping(value = "/validateEmail",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证Email",notes = "接口描述",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone",value = "手机号",required = true,dataType = "string"),

    })
    public String validatePhone(String userPhone){
        int result = userService.selectByPhoneNum(userPhone);
        return "success";
    }*/
    @RequestMapping(value = "/sendEmailValidate",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "该接口是发送验证码",notes = "建议先输入正确的邮箱")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userEmail",value = "邮箱",required = true,dataType = "string"),

    })
    public String sendEmailValidate(String userEmail, HttpSession session){

       /*int result =  userService.selectByEmail(userEmail);*/

        String sessionCode = MailUtils.getRandomNumCode(5);
        System.out.println(sessionCode);
        session.setAttribute("sessionCode",sessionCode);
        session.setMaxInactiveInterval(120);
        MailUtils.sendMail(userEmail,"您的登陆验证码是："+sessionCode+"请在2分钟内完成操作","男人帮安全中心");
        return "success";
    }
    @RequestMapping(value = "/validateCode",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证验证码窗口",notes = "输入你接收到的验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "验证码",required = true,dataType = "string"),
            @ApiImplicitParam(name = "userEmail",value = "输入你登陆的邮箱",required = true,dataType = "string"),

    })
    public String validateCode(String code,String userEmail,HttpSession session){
        System.out.println("2["+code+"]code");
        String sessionCode = (String) session.getAttribute("sessionCode");
        System.out.println("1"+sessionCode+":validateCode");

        boolean flag = sessionCode.equals(code);

        System.out.println(flag);
        if(flag){
            System.out.println(userEmail);
            int result = userService.selectByEmail(userEmail);
            System.out.println("result"+result);
            if(result<1){
                userService.insertEmail(userEmail);
            }
            return "success";
        }else{
            return "fail";
        }
    }

}
