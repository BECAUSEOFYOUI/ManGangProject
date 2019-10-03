package com.qfedu.util;

/*import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/
import java.net.PasswordAuthentication;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * 发邮件工具类
 */
public final class MailUtils {
    private static final String USER = "1215737750@qq.com"; // 发件人称号，同邮箱地址
    private static final String PASSWORD = "wiirekfgeuwfjjai"; // 如果是qq邮箱可以使户端授权码，或者登录密码


    // 随机验证码

    public static String achieveCode() {  //由于数字1 和0 和字母 O,l 有时分不清，所有，没有字母1 、0

        String[] beforeShuffle= new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",

                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",

                "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",

                "w", "x", "y", "z" };

        List list = Arrays.asList(beforeShuffle);//将数组转换为集合

        Collections.shuffle(list);  //打乱集合顺序

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {

            sb.append(list.get(i)); //将集合转化为字符串

        }

        return sb.toString().substring(3, 8);  //截取字符串第4到8

    }
    /**
     *
     * @param to 收件人邮箱
     * @param text 邮件正文
     * @param title 标题
     *//*
    *//* 发送验证信息的邮件 *//*
    public static boolean sendMail(String to, String text, String title){
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.qq.com");

            // 发件人的账号
            props.put("mail.user", USER);
            //发件人的密码
            props.put("mail.password", PASSWORD);

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // 设置邮件标题
            message.setSubject(title);

            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception { // 做测试用
        String code = MailUtils.achieveCode();
        String email = "1215737750@qq.com";
        MailUtils.sendMail("1215737750@qq.com","你好，这是一封测试邮件，无需回复。","测试邮件");
        *//*MailUtils.sendMail(email,"尊敬的用户"+email+"您好!您的验证码为：["+code+"]将在60秒之后失效","测试邮件");*//*
        System.out.println(code);
        System.out.println("发送成功");
    }*/



}
