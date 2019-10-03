<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/base.css"/>
		<link rel="stylesheet" type="text/css" href="../fonts/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="../css/master.css"/>
		<script src="../js/rem.js" type="text/javascript" charset="utf-8"></script>
		<script>

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
				<form action="" method="post">
					<div class="lm-input">
						<lable for="na">手机号：</lable>
						<input type="tel" name="" id="na" value="" />
					</div>
					<div class="lm-input">
						<lable for="yan">验证码：</lable>
						<input type="number" name="" id="yan" value="" />
						<span>发送验证码</span>
					</div>
					<input type="button" name="" id="" value="登录" class="loginipt" />
				</form>
				<p>免注册，直接用手机号就能登陆</p>
				<script type="text/javascript">
					window.onload=function(){
						let loginipt=document.querySelector('.loginipt')
						loginipt.onclick=function(){
							location.href='shouye.html'
						}
						
						
					}
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
		
	</body>
</html>
