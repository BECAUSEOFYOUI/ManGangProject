<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/master.css"/>
		<script src="${pageContext.request.contextPath}/js/rem.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
		<script>
			var flag = false;
			$(function(){
				$("#code").blur(function(){
					var code=$("#code").val();
					var userEmail =$("#userEmail").val();
					var params2={"code":code,"userEmail":userEmail};

					/*alert("12"+code);*/
					$.post("${pageContext.request.contextPath}/user/validateCode",params2,function(data){
						if(data == "success"){
							/*$("#errorCode").text("验证码输入正确!").css("color","green");*/
							flag=true;
						} else{
							$("#errorCode").text("验证码输入错误!").css("color","red");
							flag=false;
						}
					});
				});

				$("#yzmBtn").click(function(){
					/*alert(0);*/
					//ajax
					/*var email=$("input[name='email']");*/
					var email=$("#userEmail").val();
					/*alert("+++++++++++"+email);*/
					if(null!=email && email!=""){

						var params={"userEmail":email};
						$.post("${pageContext.request.contextPath}/user/sendEmailValidate",params,function(data){
							/*alert(1);
                            alert(data);*/
							if(data =="success"){
								/*alert(2)*/
								alert("邮件发送成功");
							}else {
								alert("邮件发送失败");
							}
						});
					}else{
						alert("邮箱不能为空");
					}
				});

			});

			function validate() {
				/*alert("denglu");*/
				if(flag==true){
					return true;
				}else{
					$("#errorCode").text("验证码不能为空!").css("color","red");
					return false;
				}
			}
		</script>
	</head>
	<body>
		<div class="login-bigbox bigbox">
			
			<!-- header -->
			<header class="login-header">
				<span class="iconfont icon-T"></span>
			</header>
			
			
			<!-- main -->
			<div class="login-main">
				<form action="${pageContext.request.contextPath}/user/login" method="post">
					<div class="lm-input">
						<lable for="na">邮箱：</lable>
						<input type="tel" name="userEmail" id="userEmail"/>
					</div>
					<div class="lm-input">
						<lable for="yan">验证码：</lable>
						<input type="number" name="code" id="code"  />
						<span id="yzmBtn">发送验证码</span>
					</div>
					<span id="errorCode"></span>
					<input type="submit"  value="登录" class="loginipt" onclick="return validate()"/>
				</form>
				<p>免注册，直接用手机号就能登陆</p>
				<script type="text/javascript">
					/*window.onload=function(){
						/let loginipt=document.querySelector('.loginipt')////////////////
						loginipt.onclick=function(){
							location.href='shouye.jsp'
						}
						
						
					}*/
				</script>
				
			<!-- footer -->
				<footer class="login-footer">
				<h4>—— 快捷登录 ——</h4>
				<p class="modth">
					<em class="iconfont icon-qq-copy"></em>
					<em class="iconfont">&#xe63e;</em>
					<em class="iconfont icon-weibo">
						
					</em>
				</p>
			</footer>
				
				
				
			</div>
			
			
			
			
			
		</div>
	<script>

	</script>
		
	</body>
</html>
