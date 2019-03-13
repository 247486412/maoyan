<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>猫眼电影 - 一网打尽好电影</title>
    <link rel="icon" href="${path}/img/picture/icon.png"/>
    <link href="${path}/css/normalize.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${path}/css/bootstrap.css">
    <link href="${path}/css/style.css" type="text/css" rel="stylesheet"/>
    <link href="${path}/css/content.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${path}/js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${path}/js/jquery.SuperSlide.2.1.1.js"></script>
</head>
<style>
    a:hover {
        text-decoration: none;
    }
</style>
<body>

<!--头部公共部分-->
<header class="head">
    <div class="top">
        <a class="logo" href="http://maoyan.com/" target="_blank"></a>
        <!--悬浮显示的城市-->
        <div id="place" class="place float_left">
            <div class="chongqing">
                重庆<span class="triangle"></span>
            </div>

            <!--隐藏显示的内容-->
            <ul class="display">
                <li><span>定位城市：</span>
                    <a href="#">重庆</a>
                </li>
                <li>
                    <span>A</span>
                    <div>
                        <a href="#">阿拉善盟</a>
                        <a href="#">鞍山</a>
                        <a href="#">安庆</a>
                        <a href="#">安阳</a>
                        <a href="#">阿坝</a>
                        <a href="#">安顺</a>
                        <a href="#">安康</a>
                        <a href="#">阿勒泰</a>
                        <a href="#">阿克苏</a>
                        <a href="#">安吉</a>
                        <a href="#">安岳</a>
                        <a href="#">安平</a>
                        <a href="#">安宁</a>
                        <a href="#">安溪</a>
                        <a href="#">安化</a>
                        <a href="#">阿勒泰市</a>
                        <a href="#">安福</a>
                        <a href="#"></a>
                    </div>
                </li>
                <li>
                    <span>B</span>
                    <div>
                        <a href="#">北京</a>
                        <a href="#">保定</a>
                        <a href="#">蚌埠</a>
                        <a href="#">包头</a>
                        <a href="#">本溪</a>
                        <a href="#">白城</a>
                        <a href="#">巴彦淖尔</a>
                        <a href="#">白城</a>
                        <a href="#">亳州</a>
                        <a href="#">滨州</a>
                        <a href="#">巴中</a>
                        <a href="#">北海</a>
                        <a href="#">毕节</a>
                        <a href="#">宝鸡</a>
                        <a href="#">白银</a>
                        <a href="#">滨海</a>
                        <a href="#">宝应</a>
                        <a href="#">北流</a>
                        <a href="#">博爱</a>
                        <a href="#">北碚</a>
                        <a href="#">宝丰</a>
                        <a href="#">泌阳</a>
                        <a href="#">博兴</a>
                        <a href="#">博山</a>
                        <a href="#">璧山</a>
                        <a href="#">彬县</a>
                        <a href="#">宾阳</a>
                        <a href="#">博白县</a>
                        <a href="#">博罗县</a>
                        <a href="#">北镇市</a>
                        <a href="#">泊头市</a>
                        <a href="#">北安市</a>
                        <a href="#">巴彦县</a>
                        <a href="#">滨海</a>
                        <a href="#">安福</a>
                        <a href="#"></a>
                    </div>
                </li>
                <li>
                    <span>C</span>
                    <div>
                        <a href="#">阿拉善盟</a>
                        <a href="#">鞍山</a>
                        <a href="#">安庆</a>
                        <a href="#">安阳</a>
                        <a href="#">阿坝</a>
                        <a href="#">安顺</a>
                        <a href="#">安康</a>
                        <a href="#">阿勒泰</a>
                        <a href="#">阿克苏</a>
                        <a href="#">安吉</a>
                        <a href="#">安岳</a>
                        <a href="#">安平</a>
                        <a href="#">安宁</a>
                        <a href="#">安溪</a>
                        <a href="#">安化</a>
                        <a href="#">阿勒泰市</a>
                        <a href="#">安福</a>
                        <a href="#"></a>
                    </div>
                </li>
                <li>
                    <span>D</span>
                    <div>
                        <a href="#">阿拉善盟</a>
                        <a href="#">鞍山</a>
                        <a href="#">安庆</a>
                        <a href="#">安阳</a>
                        <a href="#">阿坝</a>
                        <a href="#">安顺</a>
                        <a href="#">安康</a>
                        <a href="#">阿勒泰</a>
                        <a href="#">阿克苏</a>
                        <a href="#">安吉</a>
                        <a href="#">安岳</a>
                        <a href="#">安平</a>
                        <a href="#">安宁</a>
                        <a href="#">安溪</a>
                        <a href="#">安化</a>
                        <a href="#">阿勒泰市</a>
                        <a href="#">安福</a>
                        <a href="#"></a>
                    </div>
                </li>
                <li>
                    <span>E</span>
                    <div>
                        <a href="#">北京</a>
                        <a href="#">保定</a>
                        <a href="#">蚌埠</a>
                        <a href="#">包头</a>
                        <a href="#">本溪</a>
                        <a href="#">白城</a>
                        <a href="#">巴彦淖尔</a>
                        <a href="#">白城</a>
                        <a href="#">亳州</a>
                        <a href="#">滨州</a>
                        <a href="#">巴中</a>
                        <a href="#">北海</a>
                        <a href="#">毕节</a>
                        <a href="#">宝鸡</a>
                        <a href="#">白银</a>
                        <a href="#">滨海</a>
                        <a href="#">宝应</a>
                        <a href="#">北流</a>
                        <a href="#">博爱</a>
                        <a href="#">北碚</a>
                        <a href="#">宝丰</a>
                        <a href="#">泌阳</a>
                        <a href="#">博兴</a>
                        <a href="#">博山</a>
                        <a href="#">璧山</a>
                        <a href="#">彬县</a>
                        <a href="#">宾阳</a>
                        <a href="#">博白县</a>
                        <a href="#">博罗县</a>
                        <a href="#">北镇市</a>
                        <a href="#">泊头市</a>
                        <a href="#">北安市</a>
                        <a href="#">巴彦县</a>
                        <a href="#">滨海</a>
                        <a href="#">安福</a>
                        <a href="#"></a>
                    </div>
                </li>
                <li>
                    <p class="omit">敬请...期待...</p>
                </li>
            </ul>
        </div>

        <!--顶部中间区域-->
        <ul class="top_middle float_left">
            <li>
                <a href="Home.jsp">首页</a>
            </li>
            <li>
                <a href="#">电影</a>
            </li>
            <li>
                <a href="#">影院</a>
            </li>
            <li>
                <a href="#">榜单</a>
            </li>
            <li>
                <a href="#">热点</a>
            </li>
        </ul>
        <!--APP下载-->
        <a href="Home_APP_download.jsp" class="download float_left" target="_blank">
            <div>
                <span></span>
                <span>APP下载</span>
                <span class="triangle" style="position: relative;left: 70px;top: -13px;"></span>
            </div>
            <section>
                <p>扫码下载APP</p>
                <small>选座更优惠</small>
            </section>
        </a>
        <!--顶部右边搜索区域-->
        <form class="search float_left" action="#" name="none">
            <input type="text" placeholder="找影视剧、影人、影院"/>
            <input type="submit" value=" "/>
        </form>
        <!--顶部右边登陆按钮-->
        <div class="log_in float_right">
            <div>
                <img src="${pageContext.request.contextPath}/img/picture/7dd82a16316ab32c8359debdb04396ef2897.png"/>
                <span class="triangle"></span>
            </div>
            <section>
                <a href="login.jsp">登陆</a>
            </section>
        </div>
    </div>
</header>
</body>
<script>
  $(function () {

  })
</script>
</html>
