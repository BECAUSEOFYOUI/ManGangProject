<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>购物车</title>
    <link rel="stylesheet" href="../css/base.css">
	<link rel="stylesheet" href="../css/master.css">
	<link rel="stylesheet" href="../fonts/iconfont.css">
	<script src="../js/rem.js"></script>
</head>
<body>
    <div class="container">
		<header class="gwc_header">
			<h1>购物车</h1>
			<span class="gwc_bianji">编辑</sapn>
		</header>


		<div class="content gwc_content">
			<div class="Clamisgold">
                <div class="gwc_duihao"><img src="../img/duihao1.png" alt=""></div>
                <p>Clamisgold</p>
                <a href="javasrcipt:;" class="iconfont">&#xe625;</a>
            </div>
            <div class="gwc_solid"></div>
            <div class="gwc_list">
                <div class="gwc_duihao">
                    <input type="checkbox" name="" class="checkboxs">
                </div>
                <div class="gwc_img"><img src="../img/gwc_img01.png" alt=""></div>
                <div class="gwc_txt">
                    <p class="gwc_txt_p1">美式复古潮牌接头休闲翻领长袖外套</p>
                    <p class="gwc_col">
                        <span class="gwc_color">绿色</span>
                        <span class="gwc_max">2XL</span>
                    </p>
                    <p class="gwc_jiajian">
                        <span class="gwc_jian">-</span>
                        <span class="gwc_num">1</span>
                        <span class="gwc_jia">+</span>
                    </p>
                    <p class="gwc_mon">￥<span class="gwc_money">136.00</span></p>
                </div>
            </div>
            <div class="gwc_solid"></div>

		</div>

        <div class="gwc_jiesuan">
            <div class="gwc_jiesuan_duihao">
                <input type="checkbox" name="" class="checkboxAll">
            </div>
            <p>全选</p>
            <div class="gwc_jiesuan_heji">
                <p>合计:￥<span>136.00</span></p>
                <p>不含运费</p>
            </div>
            <input type="button" value="结算" id="gwc_btn">
        </div>

		<footer class="gwc_footer">
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
					<a href="./fenlie.html">
						<i class="iconfont">&#xe671;</i>
						<p>分类</p>
					</a>
				</li>
				<li>
					<a href="javasrcipt:;">
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

    <script type="text/javascript">
        let checkboxs = document.querySelectorAll('.checkboxs');
        let checkboxAll = document.querySelector('.checkboxAll');
        for(let i=0; i<checkboxs.length; i++){

            checkboxs[i].onchange = function(){


            }
            checkboxAll.onchange = function(){
                checkboxs[i].checked = this.checked;
            }

        }



    </script>
</body>
</html>