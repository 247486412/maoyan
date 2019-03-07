<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>

<head>
    <link rel="icon" href="${pageContext.request.contextPath}/img/picture/icon.png"/>
</head>

<body>
<!--主页-->
<section class="home">
    <!--因有下拉列表，外部文件的层会遮挡本文件的层，以后能解决了再用-->
    <!--<iframe class="header_frame" id="header_frame" width=100% height=415px SRC="/Cat_Eye/header.jsp" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" ></iframe>-->


    <!--头部公共部分-->
    <jsp:include page="header.jsp"></jsp:include>
    <!--头部公共部分结束-->


    <!--头部广告大图-->
    <div class=" banner">
        <div class="picture_box">
            <a class="picture_one" href="#"><img
                    src="${pageContext.request.contextPath}/img/picture/0ce1405139953be69a9f4104a06b21a0149274.jpg"/></a>
            <a class="picture_two" href="#"><img
                    src="${pageContext.request.contextPath}/img/picture/748bb7ac504e879989344af097249312171404.jpg"/></a>
            <a class="picture_three" href="#"><img
                    src="${pageContext.request.contextPath}/img/picture/b02ff81fda1b184ec54ee91e24bc270795149.jpg"/></a>
        </div>
        <button class="arrow_left arrow"></button>
        <button class="arrow_right arrow"></button>
        <div class="button">
            <button></button>
            <button></button>
            <button></button>
        </div>
    </div>


    <!--影片内容区域-->
    <div class="content">
        <!--左边区域-->
        <div class="conten_left float_left">

            <!--左边区域第一部分-->
            <div class="movie firsr_part float_left">
                <!--正在热映标题-->
                <h1 class="title">正在热映 (61部)<span class="float_right"><a href="#">全部</a><i
                        class="arrows red_arrows"></i></span></h1>
                <!--第一部分所有影片盒子-->
                <div class="movie_picture_box">

                    <!--每部影片所有内容以div包围，方便定位-->
                    <div>
                        <!--每部影片以figure包裹，图文信息都写在里面-->
                        <figure>
                            <!--图片及图片上的内容以a标签包裹-->
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/img/picture/3247f481288edb9d8cc64f9b1a9251b21517446.jpg"/>
                                <figcaption>黄金兄弟<i>8.<span>6</span></i></figcaption>
                                <!--图片底下的阴影为背景图片以em标签承载-->
                                <em></em>
                            </a>
                            <a class="buy" id="buy" href="#" onclick="demo(this)" onmouseover="demo1(this)"
                               onmouseout="demo2(this)">购票</a>
                        </figure>
                        <!--图片左上角的2D、3D图片为背景图以span承载，因鼠标点击时没有超链接，所以放在a标签下面以定位放上去-->
                        <span class="2D_imax"
                              style="display: inline-block;width: 69px;height: 25px;background: red;position: absolute;top: 35px;left: 28px;background:url(img/picture/2D.png)"></span>

                        <!--因在外部样式里效果怎么都出不来所以放在了行内样式里-->
                        <div class="2D_imax"></div>
                    </div>

                    <div>
                        <figure>
                            <a href="Home_Hotshow.jsp" target="_blank">
                                <img src="${pageContext.request.contextPath}/img/picture/e27ff51791134dc9cfd72417af9049af197718.jpg"/>
                                <figcaption>悲伤逆流成河<i>9.<span>1</span></i></figcaption>
                                <em></em>
                            </a>
                            <a class="buy" id="buy" href="#" onclick="demo(this)" onmouseover="demo1(this)"
                               onmouseout="demo2(this)">购票</a>
                        </figure>
                    </div>

                    <div>
                        <figure>
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/img/picture/e561524b7b414d1c62db33552707b0cd712339.jpg"/>
                                <figcaption>李茶的姑妈
                                    <!--<i>8.<span>9</span></i>--></figcaption>
                                <em></em>
                            </a>
                            <a class="buy" id="buy" href="#" onclick="demo(this)" onmouseover="demo1(this)"
                               onmouseout="demo2(this)">购票</a>
                        </figure>
                        <span class="2D_imax"
                              style="display: inline-block;width: 69px;height: 25px;background: red;position: absolute;top: 35px;left: 28px;background:url(img/picture/2D.png)"></span>
                    </div>

                    <div>
                        <figure>
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/img/picture/8d6af74467f85d48a06a1a3c21fc833c1032664.jpg"/>
                                <figcaption>反贪风暴3<i>8.<span>8</span></i></figcaption>
                                <em></em>
                            </a>
                            <a class="buy" id="buy" href="#" onclick="demo(this)" onmouseover="demo1(this)"
                               onmouseout="demo2(this)">购票</a>
                        </figure>
                    </div>

                    <div>
                        <figure>
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/img/picture/53e39ceee7bfbada4dc89bd93bbd334b198786.jpg"/>
                                <figcaption title="碟中谍6：全面瓦解">碟中谍6：全...<i>9.<span>1</span></i></figcaption>
                                <em></em>
                            </a>
                            <a class="buy" id="buy" href="#" onclick="demo(this)" onmouseover="demo1(this)"
                               onmouseout="demo2(this)">购票</a>
                        </figure>
                        <span class="2D_imax"
                              style="display: inline-block;width: 69px;height: 25px;background: red;position: absolute;top: 35px;left: 28px;background:url(img/picture/3Dimax.png)"></span>
                    </div>

                    <div>
                        <figure>
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/img/picture/23186acc67b7e28c64391806f45e0e111024700.jpg"/>
                                <figcaption title="江湖儿女">江湖儿女<i>7.<span>7</span></i></figcaption>
                                <em></em>
                            </a>
                            <a class="buy" id="buy" href="#" onclick="demo(this)" onmouseover="demo1(this)"
                               onmouseout="demo2(this)">购票</a>
                        </figure>
                    </div>

                    <div>
                        <figure>
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/img/picture/cac9e6514044986747204c41c0a89f4e725343.jpg"/>
                                <figcaption title="影">影
                                    <!--<i>8.<span>9</span></i>--></figcaption>
                                <em></em>
                            </a>
                            <a class="buy" id="buy" href="#" onclick="demo(this)" onmouseover="demo1(this)"
                               onmouseout="demo2(this)">购票</a>
                        </figure>
                        <span class="2D_imax"
                              style="display: inline-block;width: 69px;height: 25px;background: red;position: absolute;top: 35px;left: 28px;background:url(img/picture/2D.png)"></span>
                    </div>

                    <div>
                        <figure>
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/img/picture/c282bb6d8e39f8e9a2053e4fd88fd05c2901691.jpg"/>
                                <figcaption title="大闹西游">大闹西游<i>8.<span>2</span></i></figcaption>
                                <em></em>
                            </a>
                            <a class="buy" id="buy" href="#" onclick="demo(this)" onmouseover="demo1(this)"
                               onmouseout="demo2(this)">购票</a>
                        </figure>
                    </div>
                    <!--清除影片区域的浮动-->
                    <div class="cear_both"></div>
                </div>
            </div>

            <!--左边区域第二部分-->
            <div class="movie secend_part float_left">
                <h1 class="title">即将上映 (221部)<span class="float_right"><a href="#">全部</a><i class="arrows"></i></span>
                </h1>
                <div class="movie_picture_box">

                    <div>
                        <figure>
                            <div class="each_movie_box">
                                <a href="#">
                                    <img src="${pageContext.request.contextPath}/img/picture/cac9e6514044986747204c41c0a89f4e725343.jpg"/>
                                    <figcaption title="影">影<i>8.<span>6</span></i></figcaption>
                                    <em></em>
                                </a>
                                <p class="people_number">201574人想看</p>
                                <a>预告片</a>
                                <a class="presell" href="#">预售</a>
                            </div>
                            <p>9月30日上映</p>
                        </figure>
                        <span class="2D_imax"
                              style="display: inline-block;width: 69px;height: 25px;background: red;position: absolute;top: 35px;left: 28px;background:url(img/picture/2D.png)"></span>
                    </div>

                    <div>
                        <figure>
                            <div class="each_movie_box">
                                <a href="#">
                                    <img src="${pageContext.request.contextPath}/img/picture/e561524b7b414d1c62db33552707b0cd712339.jpg"/>
                                    <figcaption title="李茶的姑妈">李茶的姑妈<i>8.<span>6</span></i></figcaption>
                                    <em></em>
                                </a>
                                <p class="people_number">144614人想看</p>
                                <a>预告片</a>
                                <a class="presell" href="#">预售</a>
                            </div>
                            <p>9月30日上映</p>
                        </figure>
                        <span class="2D_imax"
                              style="display: inline-block;width: 69px;height: 25px;background: red;position: absolute;top: 35px;left: 28px;background:url(img/picture/2D.png)"></span>
                    </div>

                    <div>
                        <figure>
                            <div class="each_movie_box">
                                <a href="#">
                                    <img src="${pageContext.request.contextPath}/img/picture/3ce1d7e0315b5f204aed55b12c8c80ab303431.jpg"/>
                                    <figcaption title="无双">无双<i>8.<span>6</span></i></figcaption>
                                    <em></em>
                                </a>
                                <p class="people_number">122717人想看</p>
                                <a>预告片</a>
                                <a class="presell" href="#">预售</a>
                            </div>
                            <p>9月30日上映</p>
                        </figure>
                        <span class="2D_imax"
                              style="display: inline-block;width: 69px;height: 25px;background: red;position: absolute;top: 35px;left: 28px;background:url(img/picture/2D.png)"></span>
                    </div>

                    <span>
								<figure>
									<div class="each_movie_box">
								<a href="#">
									<img src="${pageContext.request.contextPath}/img/picture/09691a3eaf893179ac69f95bb93ab6445959469.jpg"/>
									<figcaption title="胖子行动队">胖子行动队<i>8.<span>6</span></i>
							</figcaption>
							<em></em>
							</a>
							<p class="people_number">107230人想看</p>
							<a>预告片</a>
							<a class="presell" href="#">预售</a>
						</div>
						<p>9月30日上映</p>
						</figure>
						</span>

                    <div>
                        <figure>
                            <div class="each_movie_box">
                                <a href="#">
                                    <img src="${pageContext.request.contextPath}/img/picture/88448b0d3b2016a9ec338d0b6b0dcfba1133782.jpg"/>
                                    <figcaption title="营救汪星人">营救汪星人<i>8.<span>6</span></i></figcaption>
                                    <em></em>
                                </a>
                                <p class="people_number">64929人想看</p>
                                <a>预告片</a>
                                <a class="presell" href="#">预售</a>
                            </div>
                            <p>9月30日上映</p>
                        </figure>
                    </div>

                    <div>
                        <figure>
                            <div class="each_movie_box">
                                <a href="#">
                                    <img src="${pageContext.request.contextPath}/img/picture/53588281790b86dc12c78cb05a8662d71025558.jpg"/>
                                    <figcaption title="三国杀·幻">三国杀·幻<i>8.<span>6</span></i></figcaption>
                                    <em></em>
                                </a>
                                <p class="people_number">15306人想看</p>
                                <a>预告片</a>
                                <a title="票还没到">预售</a>
                            </div>
                            <p>9月30日上映</p>
                        </figure>
                        <span class="2D_imax"
                              style="display: inline-block;width: 31px;height: 25px;background: red;position: absolute;top: 35px;left: 28px;background:url(img/picture/3D.png)"></span>
                    </div>

                    <div>
                        <figure>
                            <div class="each_movie_box">
                                <a href="#">
                                    <img src="${pageContext.request.contextPath}/img/picture/4ee310dfa73b40f3c093211300718598541126.jpg"/>
                                    <figcaption title="两只小猪之勇闯神秘岛">两只小猪之勇...<i>8.<span>6</span></i></figcaption>
                                    <em></em>
                                </a>
                                <p class="people_number">3613人想看</p>
                                <a>预告片</a>
                                <a title="票还没到">预售</a>
                            </div>
                            <p>9月30日上映</p>
                        </figure>
                    </div>

                    <div>
                        <figure>
                            <div class="each_movie_box">
                                <a href="#">
                                    <img src="${pageContext.request.contextPath}/img/picture/575798ca29c72afdad9e21a4365d7fe22156211.jpg"/>
                                    <figcaption title="古剑奇谭之流月昭明">古剑奇谭之流...<i>8.<span>6</span></i></figcaption>
                                    <em></em>
                                </a>
                                <p class="people_number">44107人想看</p>
                                <a>预告片</a>
                                <a class="presell" href="#">预售</a>
                            </div>
                            <p>10月1日上映</p>
                        </figure>
                        <span class="2D_imax"
                              style="display: inline-block;width: 31px;height: 25px;background: red;position: absolute;top: 35px;left: 28px;background:url(img/picture/3D.png)"></span>
                    </div>

                    <!--清楚浮动-->
                    <div class="cear_both"></div>
                </div>
            </div>
        </div>

        <!--右边区域-->
        <div class="conten_right float_right">

            <!--右边第一部分,今日票房列表-->
            <div class="right_first_part">
                <h1 class="title">今日票房</h1>
                <ul class="ranking">
                    <li>
                        <a href="#"><i class="champion_icon"></i><img class="float_left scale"
                                                                      src="${pageContext.request.contextPath}/img/picture/83a2315e2bc8305e927f708e13db6893936823.jpg"/>
                            <div><big>黄金兄弟</big>
                                <p>678.10万</p>
                            </div>
                        </a>
                    </li>

                    <img id="display1" class="picture_show show1 "
                         src="${pageContext.request.contextPath}/img/picture/e27ff51791134dc9cfd72417af9049af197718.jpg"/>
                    <li>
                        <a href="Home_Hotshow.jsp" target="_blank"><i>2</i><span
                                id="hover1">悲伤逆流成河</span><span>594.13万</span></a>
                    </li>

                    <img id="display2" class="picture_show show2 "
                         src="${pageContext.request.contextPath}/img/picture/8d6af74467f85d48a06a1a3c21fc833c1032664.jpg"/>
                    <li>
                        <a href="#"><i>3</i><span id="hover2">反贪风暴3</span><span>286.66万</span></a>
                    </li>

                    <img id="display3" class="picture_show show3 "
                         src="${pageContext.request.contextPath}/img/picture/53e39ceee7bfbada4dc89bd93bbd334b198786.jpg"/>
                    <li>
                        <a href="#"><i>4</i><span id="hover3">碟中谍6：全面瓦解</span><span>233.44万</span></a>
                    </li>

                    <img id="display4" class="picture_show show4 "
                         src="${pageContext.request.contextPath}/img/picture/23186acc67b7e28c64391806f45e0e111024700.jpg"/>
                    <li>
                        <a href="#"><i>5</i><span id="hover4">江湖儿女</span><span>151.75万</span></a>
                    </li>

                    <img id="display5" class="picture_show show5 "
                         src="${pageContext.request.contextPath}/img/picture/432420ae6dd23749b275ec543079ec4b1325875.jpg"/>
                    <li>
                        <a href="#"><i>6</i><span id="hover5">虎胆追凶</span><span>57.24万</span></a>
                    </li>

                    <img id="display6" class="picture_show show6 "
                         src="${pageContext.request.contextPath}/img/picture/c282bb6d8e39f8e9a2053e4fd88fd05c2901691.jpg"/>
                    <li>
                        <a href="#"><i>7</i><span id="hover6">大闹西游</span><span>35.75万</span></a>
                    </li>

                    <img id="display7" class="picture_show show7 "
                         src="${pageContext.request.contextPath}/img/picture/78310a55b319ebc4cf83349a8f26cffc1e17163d.jpg"/>
                    <li>
                        <a href="#"><i>8</i><span id="hover7">镰仓物语</span><span>28.59万</span></a>
                    </li>

                    <img id="display8" class="picture_show show8 "
                         src="${pageContext.request.contextPath}/img/picture/u=1055749400,2688593594&fm=20.jpg"/>
                    <li>
                        <a href="#"><i>9</i><span id="hover8">文朝荣</span><span>16.58万</span></a>
                    </li>

                    <img id="display9" class="picture_show show9 "
                         src="${pageContext.request.contextPath}/img/picture/$RQ81SNB.jpg"/>
                    <li>
                        <a href="#"><i>10</i><span id="hover9">阿尔法：狼伴归途</span><span>11.14万</span></a>
                    </li>
                </ul>
                <!--今日大盘-->
                <div class="how_much_cell">
                    <h3>今日大盘</h3>
                    <div>
                        <h1 class="title"><b>2176.4</b>
                            <small>万</small>
                            <span class="float_right"><a href="#">查看更多</a><i class="arrows red_arrows"></i></span></h1>
                        <p>北京时间 15:09:40<span class="float_right">猫眼专业版实时票房数据</span></p>
                    </div>
                </div>
            </div>

            <!--右边第二部分-->
            <div class="right_second_part secont_and_third">
                <h1 class="title">最受期待<span class="float_right"><a href="#">查看完整榜单</a><i
                        class="arrows yellow_arrows"></i></span></h1>
                <ul class="ranking">
                    <li>
                        <a href="#"><i class="fire_icon"></i><img class="picture_one float_left"
                                                                  src="${pageContext.request.contextPath}/img/picture/cac9e6514044986747204c41c0a89f4e725343.jpg"/>
                            <div><big>影</big>
                                <p class="date">上映时间：2018-09-30</p>
                                <p>204141人想看</p>
                            </div>
                        </a>
                    </li>
                    <li class="float_left">
                        <a href="#"><i class="rank">2</i><img class="scale"
                                                              src="${pageContext.request.contextPath}/img/picture/0766853946efc2de3ffe50952c264b2f665831.jpg"/>
                            <p>李茶的姑妈</p><span>146569人想看</span></a>
                    </li>
                    <li class="flag float_right">
                        <a href="#"><i class="rank">3</i><img class="scale"
                                                              src="${pageContext.request.contextPath}/img/picture/a22f5e1882847dfbfccdc8114cd1f845860769.jpg"/>
                            <p>胖子行动队</p><span>110135人想看</span></a>
                    </li>
                    <div class="cear_both"></div>
                    <li>
                        <a href="#"><i>4</i><span>无双</span><span>119812人想看</span></a>
                    </li>
                    <li>
                        <a href="#"><i>5</i><span>飞驰人生</span><span>78890人想看</span></a>
                    </li>
                    <li>
                        <a href="#"><i>6</i><span>营救汪星人</span><span>66449人想看</span></a>
                    </li>
                    <li>
                        <a href="#"><i>7</i><span>找到你</span><span>46037人想看</span></a>
                    </li>
                    <li>
                        <a href="#"><i>8</i><span>昨日青空</span><span>228692人想看</span></a>
                    </li>
                    <li>
                        <a href="#"><i>9</i><span>名侦探柯南：零的执行人</span><span>19945人想看</span></a>
                    </li>
                    <li>
                        <a href="#"><i>10</i><span>铁血战士</span><span>46560人想看</span></a>
                    </li>
                </ul>
            </div>

            <!--右边第三部分-->
            <div class="third_part secont_and_third ">
                <h1 class="title">TOP 100<span class="float_right"><a href="#">查看完整榜单</a><i class="arrows"></i></span>
                </h1>
                <ul class="ranking">
                    <li>
                        <a href="#"><i class="champion_icon"></i><img class="float_left"
                                                                      src="${pageContext.request.contextPath}/img/picture/2d52f6932ca2f47871ca27801c71e4cf98763.jpg"/>
                            <div><big>霸王别姬</big>
                                <p class="top_score">9.6分</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#"><i>2</i><span>罗马假日</span><span>9.1分</span></a>
                    </li>
                    <li>
                        <a href="#"><i>3</i><span>肖申克的救赎</span><span>9.5分</span></a>
                    </li>
                    <li>
                        <a href="#"><i>4</i><span>这个杀手不太冷</span><span>9.5分</span></a>
                    </li>
                    <li>
                        <a href="#"><i>5</i><span>教父</span><span>9.3分</span></a>
                    </li>
                    <li>
                        <a href="#"><i>6</i><span>泰坦尼克号</span><span>9.5分</span></a>
                    </li>
                    <li>
                        <a href="#"><i>7</i><span>唐伯虎点秋香</span><span>9.2分</span></a>
                    </li>
                    <li>
                        <a href="#"><i>8</i><span>千与千寻</span><span>9.3分</span></a>
                    </li>
                    <li>
                        <a href="#"><i>9</i><span>魂断蓝桥</span><span>9.2分</span></a>
                    </li>
                    <li>
                        <a href="#"><i>10</i><span>乱世佳人</span><span>9.1分</span></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="cear_both"></div>
    <!--中间内容区域结束了-->


    <!--底部区域,利用内联框架可以直接调用外部html文件-->
    <jsp:include page="footer.jsp"></jsp:include>
</section>

<!--自己写的外部js要放在body最后，要让浏览器先加载html，先加载js的话HTML元素都没有出来js获取不了元素，会报错为：无法设置属性-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my-script.js"></script>
</body>

</html>