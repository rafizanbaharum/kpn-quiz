<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>KPN:Quiz</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="icon" type="image/png" href="/resources/img/favicon/favicon.ico">

    <link rel="stylesheet" href="/resources/css/960gs/fluid.css">
    <link rel="stylesheet" href="/resources/css/h5bp/normalize.css">
    <link rel="stylesheet" href="/resources/css/h5bp/non-semantic.helper.classes.css">
    <link rel="stylesheet" href="/resources/css/h5bp/print.styles.css">
    <link rel="stylesheet" href="/resources/css/special-page.css">
    <link rel="stylesheet" href="/resources/css/sprites.css">
    <link rel="stylesheet" href="/resources/css/typographics.css">
    <link rel="stylesheet" href="/resources/css/content.css">
    <link rel="stylesheet" href="/resources/css/sprite.forms.css">
    <link rel="stylesheet" href="/resources/css/ie.fixes.css">

</head>
<body class="special_page">
<div class="top">
    <div class="gradient"></div>
    <div class="white"></div>
    <div class="shadow"></div>
</div>
<div class="content">
    <%--<h1>SSM | MyLLP</h1>--%>


    <div class="background"></div>
    <div class="wrapper">
        <div class="box">
            <c:if test="${not empty param.login_error}">
                <div class="alert error">
                    Your login attempt was not successful, try again.<br/>
                    Reason: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
                </div>
            </c:if>
            <div class="header grey">
                <img src="/resources/img/icons/packs/fugue/16x16/lock.png" width="16" height="16">

                <h3>Login</h3>
            </div>
            <form method="post" action="/login" class="validate">
                <div class="content no-padding">
                    <div class="section _100">
                        <label>
                            Username
                        </label>

                        <div>
                            <input name="username" class="required">
                        </div>
                    </div>
                    <div class="section _100">
                        <label>
                            Password
                        </label>

                        <div>
                            <input name="password" type="password" class="required">
                        </div>
                    </div>
                </div>
                <div class="actions">
                    <div class="actions-left">
                        <input type="button" value="Register New Account" onclick="parent.location='<%=request.getContextPath() %>/register'"/>
                    </div>
                    <div class="actions-right">
                        <input type="submit" value="Login"/>
                    </div>
                </div>
            </form>
        </div>
        <div class="shadow"></div>
    </div>
</div>

<!-- JavaScript at the bottom for fast page loading -->
<!-- Grab Google CDN's jQuery + jQueryUI, with a protocol relative URL; fall back to local -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/libs/jquery-1.7.1.js"><\/script>')</script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<script>window.jQuery.ui || document.write('<script src="resources/js/libs/jquery-ui-1.8.16.min.js"><\/script>')</script>
<script defer src="/resources/js/plugins.js"></script>
<script defer src="/resources/js/mylibs/jquery.validate.js"></script>
<script defer src="/resources/js/mylibs/jquery.jgrowl.js"></script>
<script defer src="/resources/js/mylibs/jquery.checkbox.js"></script>
<script defer src="/resources/js/mylibs/jquery.validate.js"></script>
<script defer src="/resources/js/script.js"></script>

</body>
</html>
