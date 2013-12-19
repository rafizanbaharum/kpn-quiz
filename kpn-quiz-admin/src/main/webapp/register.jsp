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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon/favicon.ico">
    <link href="${pageContext.request.contextPath}/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet"
          media="screen">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fonts/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main-responsive.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/iCheck/skins/all.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/plugins/perfect-scrollbar/src/perfect-scrollbar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme_light.css" id="skin_color">
    <!--[if IE 7]>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/plugins/font-awesome/css/font-awesome-ie7.min.css">
    <![endif]-->
    <!-- end: MAIN CSS -->
    <!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/select2/select2.css">
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
</head>
<body class="login example2">
<div class="main-login col-sm-6 col-sm-offset-3">
    <div class="col-sm-offset-2">
        <div class="logo"><h2>ASEAN QUIZ</h2></div>
    </div>
    <div class="box-register">
        <c:if test="${started && !ended}">
            <h3>Sign Up</h3>
            <form:form method="post" class="form-register" commandName="registration"
                       action="${pageContext.request.contextPath}/register">
                <jsp:include page="secure/include/msg.jsp"/>
                <div class="errorHandler alert alert-danger no-display">
                    <i class="icon-remove-sign"></i> You have some form errors. Please check below.
                </div>
                <fieldset>
                    <div class="col-md-6">
                        <p>
                            Enter your personal details below:
                        </p>

                        <div class="form-group">
                            <form:input type="text" class="form-control" path="fullName" placeholder="Full Name"/>
                        </div>
                        <div class="form-group">
                            <form:input type="text" class="form-control" path="email" placeholder="Email"/>
                        </div>
                        <div class="form-group">
                            <form:input type="text" class="form-control" path="phone"
                                        placeholder="Your cell phone number"/>
                        </div>
                        <div class="form-group">
                            <form:select id="form-field-select-1" path="stateId" class="form-control">
                                <form:option value="">Select state</form:option>
                                <c:forEach items="${states}" var="state">
                                    <form:option value='${state.key}'>${state.value}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="col-md-6"><p>
                        Enter your school details below:
                    </p>

                        <div class="form-group">
                                 							<span class="input-icon">
                                                                 <form:select id="schoolType" path="schoolType"
                                                                              class="form-control">
                                                                     <form:option value="">Type of school</form:option>
                                                                     <c:forEach items="${schoolTypeMap}"
                                                                                var="schoolType">
                                                                         <form:option
                                                                                 value='${schoolType.key}'>${schoolType.value}</form:option>
                                                                     </c:forEach>
                                                                 </form:select>
                                                            </span>
                        </div>
                        <div class="form-group">
                                 							<span class="input-icon">
                                 								<form:input type="text" class="form-control"
                                                                             path="schoolName"
                                                                             placeholder="School Name"/>
                                 								<i class="icon-sitemap"></i> </span>
                        </div>

                        <div class="form-group">
                            <form:input type="text" class="form-control" path="address1" placeholder="Address"/>
                        </div>

                        <div class="form-group">
                                 							<span class="input-icon">
                                 								<form:input type="text" class="form-control"
                                                                             path="schoolPhone"
                                                                             placeholder="School Phone"/>
                                 								<i class="icon-phone"></i> </span>
                        </div>

                        <p>
                            Enter your account details below:
                        </p>

                        <div class="form-group">
                                 							<span class="input-icon">
                                 								<form:input type="text" class="form-control"
                                                                             path="nricNo" placeholder="NRIC No"
                                                                             maxlength="12"
                                                                             autocomplete="off"/>
                                 								<i class="icon-user"></i> </span>

                            <div id="username_status"></div>
                        </div>
                        <div class="form-group">
                                 							<span class="input-icon">
                                 								<form:password class="form-control" id="password"
                                                                                path="password"
                                                                                placeholder="Password"
                                                                                autocomplete="off"/>
                                 								<i class="icon-lock"></i> </span>
                        </div>
                        <div class="form-group">
                                 							<span class="input-icon">
                                 								<form:password class="form-control"
                                                                                path="passwordAgain"
                                                                                placeholder="Password Again"
                                                                                autocomplete="off"/>
                                 								<i class="icon-lock"></i> </span>
                        </div>
                    </div>

                    <div class="form-actions">
                        <button type="button" class="btn btn-light-grey go-back"
                                onclick="parent.location = 'gate/in'">
                            <i class="icon-circle-arrow-left"></i> Back
                        </button>
                        <button type="submit" class="btn btn-bricky pull-right">
                            Submit <i class="icon-circle-arrow-right"></i>
                        </button>
                    </div>


                </fieldset>
            </form:form>
        </c:if>
        <c:if test="${!started}">
            <div class="errorHandler alert alert-danger">
                <i class="icon-remove-sign"></i> Sorry the registration has not started yet. Please come back
                again.
            </div>
        </c:if>
        <c:if test="${started && ended}">
            <div class="errorHandler alert alert-danger">
                <i class="icon-remove-sign"></i> Sorry the registration has ended.
            </div>
        </c:if>
    </div>
    <div class="copyright">
        2013 &copy; ASEAN QUIZ
    </div>
</div>
<!-- start: MAIN JAVASCRIPTS -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/assets/plugins/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/blockUI/jquery.blockUI.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/iCheck/jquery.icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/perfect-scrollbar/src/jquery.mousewheel.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/perfect-scrollbar/src/perfect-scrollbar.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<!-- end: MAIN JAVASCRIPTS -->
<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/login-form-validation.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/select2/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/form-elements.js"></script>

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