<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/12
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录 | 猫眼电影</title>
    <link rel="icon" href="//p1.meituan.net/tuanpic/1e4d71577b7922f1ab756d202e1ac4af1342.ico" sizes="16x16 32x32">
    <script src="${path}/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script src="${path}/js/bootstrap.js" type="text/javascript"></script>
    <link href="${path}/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${path}/css/style-maoyan.css" type="text/css" rel="stylesheet">
</head>
<body>
<header class="header cf">
    <a class="site-logo" href="http://www.maoyan.com"></a>
</header>


<div class="site-body-wrapper">
    <div class="site-body cf">
        <div class="promotion-banner">
            <img src="//s0.meituan.net/bs/file/?f=fe-sso-fs:build/page/static/banner/maoyan.png" width="480"
                 height="370" alt="猫眼电影">
        </div>

        <div class="login-section" data-params="{&quot;service&quot;:&quot;www&quot;,&quot;isDialog&quot;:false }">
            <form id="J-normal-form"
                  action="/account/unitivelogin?risk_partner=0&amp;uuid=ba696f0c9d3148d79798.1552384220.1.0.0&amp;service=maoyan&amp;continue=https%3A%2F%2Fmaoyan.com%2Fpassport%2Flogin%3Fredirect%3D%252F"
                  method="POST" class="form form--stack">
                <div class="validate-info" style="visibility:hidden"></div>

                <span class="login-type" data-mtevent="login.mobile.switch">
            <a id="J-mobile-link"
               href="/account/unitivelogin?service=maoyan&amp;continue=https%3A%2F%2Fmaoyan.com%2Fpassport%2Flogin%3Fredirect%3D%252F&amp;_nsmobilelogin=true">
                手机动态码登录
                <i></i>
            </a>
            账号登录
        </span>

                <div class="form-field form-field--icon">
                    <i class="icon icon-user"></i>
                    <input type="text" id="login-email" class="f-text" name="email" placeholder="手机号/用户名/邮箱" value="">
                </div>
                <div class="form-field form-field--icon">
                    <i class="icon icon-password"></i>
                    <input type="password" id="login-password" class="f-text" name="password" placeholder="密码">
                </div>
                <div class="form-field J-form-field-captcha form-field--captcha" style="display:none">
                    <input type="text" id="captcha" class="f-text J-captcha-input" name="captcha" placeholder="验证码"
                           autocomplete="off">
                    <img height="36" width="72" class="signup-captcha-img" id="signup-captcha-img"
                         src="https://passport.meituan.com/account/captcha?uuid=ba696f0c9d3148d79798.1552384220.1.0.0">
                    <a tabindex="-1" class="captcha-refresh inline-link" href="javascript:void(0)">看不清楚？换一张</a>
                </div>
                <div class="form-field form-field--auto-login cf">
                    <a tabindex="-1"
                       href="https://passport.meituan.com/useraccount/retrievepassword?risk_partner=0&amp;service=maoyan&amp;continue=https%3A%2F%2Fmaoyan.com%2Fpassport%2Flogin%3Fredirect%3D%252F"
                       target="_top" class="forget-password">忘记密码？</a>
                </div>
                <div class="form-field form-field--ops">
                    <input type="hidden" name="origin" value="account-login">
                    <input type="hidden" name="fingerprint" class="J-fingerprint" value="0-2-1-">
                    <input type="hidden" name="csrf" value="zaAH7mep-v3-2FG2d2-HlJJPrNyVt_4Ultw0">
                    <input data-mtevent="login.normal.submit" type="submit" class="btn" name="commit" value="登录" >
                </div>
                <p class="signup-guide">还没有账号？<a
                        href="/account/unitivesignup?service=maoyan&amp;continue=https%3A%2F%2Fmaoyan.com%2Fpassport%2Flogin%3Fredirect%3D%252F"
                        target="_top">免费注册</a></p>
            </form>

            <form id="J-mobile-form"
                  action="/account/unitivemobilelogin?risk_partner=0&amp;uuid=ba696f0c9d3148d79798.1552384220.1.0.0&amp;service=maoyan&amp;continue=https%3A%2F%2Fmaoyan.com%2Fpassport%2Flogin%3Fredirect%3D%252F"
                  method="POST" class="form form--stack J-wwwtracker-form" style="display:none">
                <div class="validate-info" style="visibility:hidden"></div>

                <span class="login-type login-type--normal" data-mtevent="login.normal.switch">
            <a id="J-normal-link"
               href="/account/unitivelogin?service=maoyan&amp;continue=https%3A%2F%2Fmaoyan.com%2Fpassport%2Flogin%3Fredirect%3D%252F">
                普通方式登录
                <i></i>
            </a>
            账号登录
        </span>

                <div class="J-info form-field form-field--icon">
                    <i class="icon icon-phone"></i>
                    <input type="text" id="login-mobile" class="f-text" name="mobile" value="" placeholder="手机号">
                </div>
                <div class="form-field J-form-field-captcha-mobile form-field--captcha-mobile" style="display:none;">
                    <i class="icon icon-captcha"></i>
                    <input type="text" id="login-captcha" class="f-text" name="login-captcha" placeholder="验证码"
                           autocomplete="off">
                    <img height="34" width="61" class="login-captcha-img" id="login-captcha-img"
                         src="https://passport.meituan.com/account/captcha?uuid=ba696f0c9d3148d79798.1552384220.1.0.0">
                    <a tabindex="-1" class="captcha-refresh inline-link" href="javascript:void(0)">看不清楚？换一张</a>
                </div>

                <div class="form-field form-field--icon">
                    <i class="icon icon-password"></i>
                    <input type="text" name="code" id="login-verify-code" class="f-text" autocomplete="off" value=""
                           placeholder="动态码">
                    <div class="form-field form-field--verify-mobile" style="top:19px;">
                        <input type="button" class="btn-normal btn-mini" id="J-verify-btn" value="获取手机动态码">
                    </div>
                    <i class="form-uuid" style="display:none">ba696f0c9d3148d79798.1552384220.1.0.0</i>
                </div>

                <div class="form-field form-field--info">
                    <span class="verify-tip" id="J-verify-tip"></span>
                </div>

                <div class="form-field form-field--auto-login cf">
                    <a tabindex="-1"
                       href="https://passport.meituan.com/useraccount/retrievepassword?risk_partner=0&amp;service=maoyan&amp;continue=https%3A%2F%2Fmaoyan.com%2Fpassport%2Flogin%3Fredirect%3D%252F"
                       target="_top" class="forget-password">忘记密码？</a>
                </div>

                <div class="form-field form-field--ops">
                    <input type="hidden" name="origin" value="account-login">
                    <input type="hidden" name="fingerprint" class="J-fingerprint" value="0-2-1-">
                    <input type="hidden" name="csrf" value="zaAH7mep-v3-2FG2d2-HlJJPrNyVt_4Ultw0">
                    <input data-mtevent="login.mobile.submit" type="submit" class="btn" name="commit" value="登录">
                </div>

            </form>

        </div>

    </div>
</div>

<footer class="footer">
    <div class="copyright">
        <p>
            ©<span>2019</span>
            <a href="https://www.meituan.com">美团网团购</a>
            meituan.com
            <a href="http://www.miibeian.gov.cn/" target="_blank">京ICP证070791号</a>
            京公网安备11010502025545号
        </p>
    </div>
</footer>
</body>
</html>
