<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>分类</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/master.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/iconfont.css">
	<script src="${pageContext.request.contextPath}/js/rem.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
</head>
<body>
<%--<script>--%>
<%--	function details(obj,id){--%>

<%--	}--%>
<%--</script>--%>

<script>

		function showGoods(obj,id,num) {
			alert(111);
			$(".fl_cur").removeClass("fl_cur")
			$(obj).addClass("fl_cur")

			$.ajax({
				url:"${pageContext.request.contextPath}/beforeGoods/classiFicationId",
				dataType:"json",
				data:{"id":id},
				success:function (data) {
					//json对象


					alert(data);

					$(data).each(function(){
						//拼接Js
						// $(".fl_rm fl_active").empty()
						// $(".fl_rm fl_active").removeClass("fl_rm fl_active")

						var q='#goodsDiv'+num+''+num+'';
						var html = '<ul class="fl_item"><li><div class="fl_box"><img src="'+this.goodsImg+'"><a href="xiangqing?"+id=this.id+"" ></a></div>';
						html+='<p class="fl__p">'+this.goodsName+'</p></li></ul>'

						$(q).addClass("fl_rm fl_active")
						$(q).append($(html));

					})
				}
			})
		}

</script>
<
    <div class="container">
		<header id="jx_header">
			<input type="text" name="" id="jx_ipt" placeholder="寻找你的商品/文章/品牌">
		</header>


		<div class="content fl_content">
            <div class="fl_title">
                <a href="javasrcipt:;">分类</a>
                <a href="./pingpai.html">品牌</a>
            </div>

            <ul class="fl_ul">
                <li class="fl_li">
                    <span class="fl_cur" onclick="showGoods(this,10,10)">热门</span>
					<div  class="delete">
						<div id="goodsDiv10" class="delete">

						</div>
					</div>
                </li>
                <li class="fl_li" ><span onclick="showGoods(this,1,1)"  class=""  >上衣</span>
                 <div  id="goodsDiv1"  class="delete">
					 <div id="goodsDiv11">

				 </div>
                 </div>
                </li>

                <li class="fl_li"><span onclick="showGoods(this,2,2)">裤子</span></li>
				<div  id="goodsDiv2"  class="delete">
					<div id="goodsDiv22">

					</div>
				</div>
				<li class="fl_li"><span onclick="showGoods(this,3,3)">鞋子</span></li>
				<div id="goodsDiv3" class="delete">

				</div>
                <li class="fl_li"><span onclick="showGoods(this,4,4)">护理</span></li>
				<div id="goodsDiv4" class="delete">

				</div>
                <li class="fl_li"><span onclick="showGoods(this,5,5)">箱包</span></li>
				<div id="goodsDiv5" class="delete">

				</div>
                <li class="fl_li"><span onclick="showGoods(this,6,6)">配饰</span></li>
				<div id="goodsDiv6" class="delete">

				</div>
                <li class="fl_li" ><span onclick="showGoods(this,7,7)">生活</span></li>
				<div id="goodsDiv7" class="delete">

				</div>
            </ul>


		</div>

		<footer class="fl_footer">
			<ul class="footer_list">
				<li>
					<a href="./shouye.html">
						<i class="iconfont">&#xe605;</i>
						<p>首页</p>
					</a>
				</li>
				<li>
					<a href="./jingxuan.html">
						<i class="iconfont">&#xe60a;</i>
						<p>精选</p>
					</a>
				</li>
				<li>
					<a href="javasrcipt:;">
						<i class="iconfont">&#xe671;</i>
						<p>分类</p>
					</a>
				</li>
				<li>
					<a href="./gouwuche.html">
						<i class="iconfont">&#xe603;</i>
						<p>购物车</p>
					</a>
				</li>
				<li>
					<a href="./wode.html">
						<i class="iconfont">&#xe619;</i>
						<p>我的</p>
					</a>
				</li>
			</ul>
		</footer>
	</div>

</body>
</html>