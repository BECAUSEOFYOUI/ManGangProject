<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>文章点击</title>
    <link rel="stylesheet" href="../css/base.css">
	<link rel="stylesheet" href="../css/master.css">
	<link rel="stylesheet" href="../fonts/iconfont.css">
	<script src="../js/rem.js"></script>
</head>
<body>
    <div class="container">
        <div class="content">
            <div id="wz_bg">
                <img src="${collocation.collocationImg}" alt="">
                <em></em>
                <div class="wz_box">
                    <a href="${pageContext.request.contextPath}/beforeGoods/listHomePage">
                        <i class="iconfont yuan">&#xe628;</i>
                    </a>
                    <i class="iconfont yuan">&#xe607;</i>
                    <p class="wz_txt">${collocation.collocationName}</p>
                    <span class="wz_date">${collocation.showTime}</span>
                </div>
            </div>
            <div id="wz_main">
                <p class="wz_p1">${collocation.collocationGoods}</p>
                <%--<p class="wz_p2">鞋履 : 黑色韦斯特椰子跑步鞋</p>--%>
                <p class="wz_p3">${collocation.collocationDetail}</p>
                <%--<p class="wz_p3">机能运动是什么？是指具有专业功能设计的户外服，而当下更是与潮流紧密相连；机能风格最早流行于北欧及德国，在一开始，针对登山户外训练所设计的一系列专业功能服，被认为是登顶的时候所穿着的外套。在传统户外运动的衣服中，一般设计会包括：防护层，保暖层
                排汗层。当下的机能运动风格，保留了冲锋衣防风防水的技能性，即使雨天也可以直接一件外套闯街头，而且外观也加入了更加丰富时尚元素和色彩，颇受潮人的热捧。</p>--%>
            </div>
            <div class="wz_img">
                <img src="../img/wz_bg2.png" alt="">
            </div>
        </div>

        <footer id="wz_footer">
            <form action="" method="post">
                <input type="text" name="" id="" value="" />
                <input type="submit" name="" id="" value="提交" style="width: 1.0rem"/>
            </form>


            <div class="talk" >
                <a href="${pageContext.request.contextPath}/comments/addComments"><span class="iconfont icon-xiaoxi"></span></a>
                <p>32</p>
            </div>
            <div class="loves">
                <span class="iconfont icon-aixin"></span>
                <p>88</p>
            </div>
            <span class="withs">相关商品</span>
        </footer>
    </div>
</body>
</html>