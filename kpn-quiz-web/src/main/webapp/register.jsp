<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<!-- Template Name: Clip-One - Responsive Admin Template build with Twitter Bootstrap 3 Version: 1.0 Author: ClipTheme -->
<!--[if IE 8]>
<html class="ie8 no-js" lang="en"><![endif]-->
<!--[if IE 9]>
<html class="ie9 no-js" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- start: HEAD -->
<head>
    <title>ASEAN QUIZ - KPN</title>
    <!-- start: META -->
    <meta charset="utf-8"/>
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1"/><![endif]-->
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- end: META -->
    <!-- start: MAIN CSS -->
    <link rel="shortcut icon" href="/resources/img/favicon/favicon.ico">
    <link href="/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="/assets/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/fonts/style.css">
    <link rel="stylesheet" href="/assets/css/main.css">
    <link rel="stylesheet" href="/assets/css/main-responsive.css">
    <link rel="stylesheet" href="/assets/plugins/iCheck/skins/all.css">
    <link rel="stylesheet" href="/assets/plugins/perfect-scrollbar/src/perfect-scrollbar.css">
    <link rel="stylesheet" href="/assets/css/theme_light.css" id="skin_color">
    <!--[if IE 7]>
    <link rel="stylesheet" href="/assets/plugins/font-awesome/css/font-awesome-ie7.min.css">
    <![endif]-->
    <!-- end: MAIN CSS -->
    <!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
    <link rel="stylesheet" href="/assets/plugins/select2/select2.css">
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
</head>
<!-- end: HEAD -->
<!-- start: BODY -->
<body class="login example2">
<div class="main-login col-sm-4 col-sm-offset-4">
    <div class="logo"><h2>ASEAN QUIZ</h2></div>
    <!-- start: LOGIN BOX -->
    <div class="box-register">
        <h3>Sign Up</h3>

        <p>
            Enter your personal details below:
        </p>

        <form method="post" class="form-login" action="${pageContext.request.contextPath}/register">
            <div class="errorHandler alert alert-danger no-display">
                <i class="icon-remove-sign"></i> You have some form errors. Please check below.
            </div>
            <fieldset>
                <div class="form-group">
                    <input type="text" class="form-control" name="fullName" placeholder="Full Name">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="email" placeholder="Email">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="phone" placeholder="Phone">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="address1" placeholder="Address">
                </div>
                <div class="form-group">
                    <select id="form-field-select-1" name="stateId" class="form-control">
                        <option value="">&nbsp;</option>
                        <c:forEach items="${states}" var="state">
                            <option value='${state.key}'>${state.value}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <div>
                        <label class="radio-inline">
                            <input type="radio" class="grey" value="F" name="gender">
                            Female
                        </label>
                        <label class="radio-inline">
                            <input type="radio" class="grey" value="M" name="gender">
                            Male
                        </label>
                    </div>
                </div>
                <p>
                    Enter your school details below:
                </p>

                <div class="form-group">
 							<span class="input-icon">
 								<input type="text" class="form-control" name="schoolName" placeholder="School Name">
 								<i class="icon-sitemap"></i> </span>
                </div>

                <p>
                    Enter your account details below:
                </p>

                <div class="form-group">
 							<span class="input-icon">
 								<input type="text" class="form-control" name="username" placeholder="Username">
 								<i class="icon-user"></i> </span>
                </div>
                <div class="form-group">
 							<span class="input-icon">
 								<input type="password" class="form-control" id="password" name="password"
                                       placeholder="Password">
 								<i class="icon-lock"></i> </span>
                </div>
                <div class="form-group">
 							<span class="input-icon">
 								<input type="password" class="form-control" name="passwordAgain"
                                       placeholder="Password Again">
 								<i class="icon-lock"></i> </span>
                </div>
                <%--
                                <div class="form-group">
                                    <div>
                                        <label for="agree" class="checkbox-inline">
                                            <input type="checkbox" class="grey agree" id="agree" name="agree">
                                            I agree to the Terms of Service and Privacy Policy
                                        </label>
                                    </div>
                                </div>
                --%>
                <div class="form-actions">
                    <button type="button" class="btn btn-light-grey go-back" onclick="parent.location = '/gate/in'">
                        <i class="icon-circle-arrow-left"></i> Back
                    </button>
                    <button type="submit" class="btn btn-bricky pull-right">
                        Submit <i class="icon-circle-arrow-right"></i>
                    </button>
                </div>
            </fieldset>
        </form>
    </div>
    <!-- end: LOGIN BOX -->
    <!-- start: COPYRIGHT -->
    <div class="copyright">
        2013 &copy; ASEAN QUIZ
    </div>
    <!-- end: COPYRIGHT -->
</div>
<!-- start: MAIN JAVASCRIPTS -->
<!--[if lt IE 9]>
<script src="/assets/plugins/respond.min.js"></script>
<script src="/assets/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="/assets/js/jquery-1.10.2.min.js"></script>
<script src="/assets/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>
<script src="/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/plugins/blockUI/jquery.blockUI.js"></script>
<script src="/assets/plugins/iCheck/jquery.icheck.min.js"></script>
<script src="/assets/plugins/perfect-scrollbar/src/jquery.mousewheel.js"></script>
<script src="/assets/plugins/perfect-scrollbar/src/perfect-scrollbar.js"></script>
<script src="/assets/js/main.js"></script>
<!-- end: MAIN JAVASCRIPTS -->
<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script src="/assets/plugins/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="/assets/js/login.js"></script>
<script src="/assets/plugins/select2/select2.min.js"></script>
<script src="/assets/js/form-elements.js"></script>

<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script>
    jQuery(document).ready(function () {
        Main.init();
        Login.init();
    });
</script>
</body>
<!-- end: BODY -->
</html>