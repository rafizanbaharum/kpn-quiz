<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel=dns-prefetch href="//fonts.googleapis.com">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>ASEAN Quiz - KPN</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="icon" type="image/png" href="/resources/img/favicon/favicon.ico">

    <!-- CSS -->
    <link rel="stylesheet" href="resources/css/960gs/fluid.css">
    <link rel="stylesheet" href="resources/css/h5bp/normalize.css">
    <link rel="stylesheet" href="resources/css/h5bp/non-semantic.helper.classes.css">
    <link rel="stylesheet" href="resources/css/h5bp/print.styles.css">
    <link rel="stylesheet" href="resources/css/sprites.css">
    <link rel="stylesheet" href="resources/css/header.css">
    <link rel="stylesheet" href="resources/css/navigation.css">
    <link rel="stylesheet" href="resources/css/sidebar.css">
    <link rel="stylesheet" href="resources/css/content.css">
    <link rel="stylesheet" href="resources/css/footer.css">
    <link rel="stylesheet" href="resources/css/typographics.css">
    <link rel="stylesheet" href="resources/css/ie.fixes.css">
    <link rel="stylesheet" href="resources/css/sprite.forms.css">
    <link rel="stylesheet" href="resources/css/sprite.lists.css">
    <link rel="stylesheet" href="resources/css/icons.css">
    <link rel="stylesheet" href="resources/css/external/jquery-ui-1.8.16.custom.css">
    <link rel="stylesheet" href="resources/css/sidebar.css">

    <script>


    </script>
</head>

<body>

<!-- Begin of #height-wrapper -->
<div id="height-wrapper">
<!-- Begin of header -->
<header>
    <!-- Begin of the header toolbar -->
    <jsp:include page="toolbar.jsp"/>
    <!-- End of the header toolbar -->

    <!-- Start of the main header bar -->
    <jsp:include page="header.jsp"/>
    <div id="nav_sub"></div>
</header>

<!-- Start of the content -->
<div role="main" class="container_12" id="content-wrapper">


    <!-- Start of the main content -->
    <div id="main_content">

        <h2 class="grid_12">Instructor Registration</h2>

        <div class="clean"></div>

        <div class="grid_12">
            <div class="box">
                <div class="header">
                    <img src="resources/img/icons/packs/fugue/16x16/task-select-first.png" alt="" width="16"
                         height="16">

                    <h3>Registration Form</h3>
                    <span></span>
                </div>
                <%--<form method="post" name="loginForm" id="loginForm" action="register" class="validate">--%>
                <form:form commandName="registration" action="${pageContext.request.contextPath}/register"
                           method="POST">

                    <div class="content">
                        <fieldset>
                            <legend>
                                Login Information
                            </legend>
                            <div class="_50">
                                <p>
                                    <label for="nameTxt">
                                        Name
                                    </label>
                                    <form:input id="nameTxt" path="fullName" size="50" cssClass="required text"/>
                                </p>
                            </div>
                            <div class="_50">
                                <p>
                                    <label for="nricNo">
                                        NRIC
                                    </label>
                                    <form:input id="nricNo" path="nricNo" size="50" cssClass="required fullname text"/>
                                </p>
                            </div>
                            <div class="_50">
                                <p>
                                    <label for="username">
                                        Username
                                    </label>
                                    <form:input id="username" path="username" size="50" cssClass="required text"/>

                                </p>

                                <div id="username_status"></div>
                            </div>
                            <div class="_50">
                                <p>
                                    <label for="emailTxt">
                                        Email
                                    </label>
                                    <form:input id="emailTxt" path="email" size="50" cssClass="required text"/>
                                </p>
                            </div>
                            <div class="_50">
                                <p>
                                    <label for="password">
                                        Password
                                    </label>
                                    <form:password id="password" path="password" size="50" cssClass="required text"/>
                                </p>
                            </div>
                            <div class="_50">
                                <p>
                                    <label for="passwordAgain">
                                        Password Again
                                    </label>
                                    <form:password id="passwordAgain" path="passwordAgain" size="50"
                                                   cssClass="required text"/>
                                </p>
                            </div>
                        </fieldset>
                        <fieldset>
                            <legend>
                                Contact Information
                            </legend>
                            <div class="_50">
                                <p>
                                    <label for="phone">
                                        Phone
                                    </label>
                                    <form:input id="phone" path="phone" size="50" cssClass="required text"/>
                                </p>
                            </div>
                            <div class="_50">
                                <p>
                                    <label for="fax">
                                        Fax
                                    </label>
                                    <form:input id="fax" path="fax" size="50" cssClass="required text"/>
                                </p>
                            </div>
                        </fieldset>
                        <fieldset>
                            <legend>
                                School Name
                            </legend>
                            <p class="inline-small-label">
                                <label for="schoolName">
                                    School Name
                                </label>
                                <form:input id="schoolName" path="schoolName" size="50" cssClass="required text"/>
                            </p>
                        </fieldset>
                        <fieldset>
                            <legend>
                                Address Information
                            </legend>
                            <p class="inline-small-label">
                                <label for="address1">
                                    Address
                                </label>
                                <form:input id="address1" path="address1" size="50" cssClass="required text"/>
                            </p>

                            <p class="inline-small-label">
                                <form:input path="address2" size="50" cssClass="required text"/>
                            </p>

                            <p class="inline-small-label">
                                <form:input path="address3" size="50" cssClass="required text"/>
                            </p>

                            <p class="inline-small-label">
                                <label for="stateId">
                                    State
                                </label>
                                <c:forEach var="i" items="${states}">
                                    Country: ${i.key}  - Capital: ${i.value}
                                </c:forEach>
                                <form:select id="stateId" path="stateId">
                                    <form:option selected="selected" value=""/>
                                    <form:options items="${states}"/>
                                </form:select>
                            </p>
                        </fieldset>
                            <%--<fieldset>--%>
                            <%--<legend>--%>
                            <%--State Information--%>
                            <%--</legend>--%>
                            <%--<p class="inline-small-label">--%>
                            <%--<label for="stateId">--%>
                            <%--State--%>
                            <%--</label>--%>
                            <%--<input type="text" id="stateId" name="stateId" class="required text"--%>
                            <%--value="0">--%>
                            <%--</p>--%>
                            <%--</fieldset>--%>
                            <%--<fieldset>--%>
                            <%--<legend>--%>
                            <%--District Information--%>
                            <%--</legend>--%>
                            <%--<p class="inline-small-label">--%>
                            <%--<label for="districtId">--%>
                            <%--District--%>
                            <%--</label>--%>
                            <%--<input type="text" id="districtId" name="districtId" class="required text"--%>
                            <%--value="0">--%>
                            <%--</p>--%>
                            <%--</fieldset>--%>
                    </div>

                    <div class="actions">
                        <div class="actions-left">
                            <input type="reset">
                        </div>
                        <div class="actions-right">
                            <input type="submit" value="Register">
                        </div>
                    </div>
                </form:form>
            </div>
            <!-- End of .box -->
        </div>
        <!-- End of .grid_6 -->

        <div class="clear"></div>

    </div>
    <!-- End of #main_content -->
    <div class="push clear"></div>

</div>
<!-- End of #content-wrapper -->
<div class="clear"></div>
<div class="push"></div>
<!-- BUGFIX if problems with sidebar in Chrome -->

</div>
<!-- End of #height-wrapper -->

<!-- Start of footer-->
<%--<footer>
    <div class="container_12">
        Copyright &copy; 2013 SSM, all rights reserved.
        <div id="button_bar">
            <ul>
                <li>
                    <span><a href="secure/dashboard.jsp">Dashboard</a></span>
                </li>
                <li>
                    <span><a href="/gate/in">Login</a></span>
                </li>
            </ul>
        </div>
    </div>
</footer>--%>
<!-- End of footer-->

<!-- JavaScript at the bottom for fast page loading -->
<!-- Grab Google CDN's jQuery + jQueryUI, with a protocol relative URL; fall back to local -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/libs/jquery-1.7.1.js"><\/script>')</script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<script>window.jQuery.ui || document.write('<script src="resources/js/libs/jquery-ui-1.8.16.min.js"><\/script>')</script>

<script src="resources/js/libs/jquery-1.7.1.js"></script>

<!-- scripts concatenated and minified via build script -->
<script defer src="resources/js/plugins.js"></script>
<!-- REQUIRED: Different own jQuery plugnis -->
<script defer src="resources/js/mylibs/jquery.ba-resize.js"></script>
<!-- RECOMMENDED when using sidebar: page resizing -->
<script defer src="resources/js/mylibs/jquery.easing.1.3.js"></script>
<!-- RECOMMENDED: box animations -->
<script defer src="resources/js/mylibs/jquery.ui.touch-punch.js"></script>
<!-- RECOMMENDED: touch compatibility -->
<script defer src="resources/js/mylibs/jquery.chosen.js"></script>
<script defer src="resources/js/mylibs/jquery.validate.js"></script>
<script defer src="resources/js/script.js"></script>
<!-- REQUIRED: Generic scripts -->
<!-- end scripts -->

<script type="text/javascript">
    $(document).ready(function () {

        jQuery.validator.setDefaults({
            debug: true,
            success: "valid"
        });
        $("#loginForm").validate({

            messages: {
                passwordAgain: {
                    equalTo: "password fields have to match"
                }
            }
        });

        $('#username').blur(function () {

            var username = document.getElementById("username").value;
            var url = '<%=request.getContextPath() %>/register/validate/' + username;

            $('#username_status').html('<p>Validating username...</p>');
            $.ajax({
                url: url,
                success: function (data) {
                    $('#username_status').html(data);
                },
                error: function (data) {
                    $('#username_status').html('<p>An error occurred.</p>');
                }
            });
        });

    });

</script>

</body>
</html>
