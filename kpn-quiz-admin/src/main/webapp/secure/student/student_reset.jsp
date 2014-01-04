<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<!-- Template Name: Clip-One - Responsive Admin Template build with Twitter Bootstrap 3 Version: 1.0 Author: ClipTheme -->
<!--[if IE 8]><html class="ie8 no-js" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9 no-js" lang="en"><![endif]-->
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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon/favicon.ico"/>
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
</head>
<body class="footer-fixed layout-boxed">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="clip-list-2"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/secure/index">
                    ASEAN QUIZ
                </a>
            </div>
            <div class="navbar-tools">
                <ul class="nav navbar-right">
                    <li class="dropdown current-user">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <img src="" class="circle-img" alt="">
                            <span class="username">User</span>
                            <i class="clip-chevron-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/secure/user/profile">
                                    <i class="clip-user-2"></i>
                                    &nbsp;My Profile
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/gate/out">
                                    <i class="clip-exit"></i>
                                    &nbsp;Log Out
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="main-container">
        <div class="navbar-content">
            <div class="main-navigation navbar-collapse collapse">
                <div class="navigation-toggler">
                    <i class="clip-chevron-left"></i>
                    <i class="clip-chevron-right"></i>
                </div>
                <ul class="main-navigation-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/secure/index"><i class="clip-home-3"></i>
                            <span class="title"> Dashboard </span><span class="selected"></span>
                        </a>
                    </li>
                    <li class="active open">
                        <a href="javascript:void(0)"><i class="clip-pencil"></i>
                            <span class="title"> Manage Student </span><i class="icon-arrow"></i>
                            <span class="selected"></span>
                        </a>
                        <ul class="sub-menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/secure/student/register">
                                    <span class="title">Register</span>
                                </a>
                            </li>
                        </ul>
                        <ul class="sub-menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/secure/student/list">
                                    <span class="title">Student List</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main-content">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <ol class="breadcrumb">
                            <li>
                                <i class="clip-pencil"></i>
                                <a href="#">
                                    Manage Student
                                </a>
                            </li>
                            <li class="active">
                                Register Student
                            </li>
                        </ol>
                        <div class="page-header">
                            <h1>Student Registration </h1>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="icon-external-link-sign"></i>
                                Register a student
                            </div>
                            <div class="panel-body">
                                <h2><i class="icon-edit-sign teal"></i> REGISTER</h2>

                                <hr>
                                <form:form id="form" commandName="studentModel"
                                           action="${pageContext.request.contextPath}/secure/student/update"
                                           method="POST">
                                    <form:hidden path="id"/>
                                    <form:hidden path="name"/>
                                    <form:hidden path="nricNo"/>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="errorHandler alert alert-danger no-display">
                                                <i class="icon-remove-sign"></i> You have some form errors. Please check
                                                below.
                                            </div>
                                            <div class="successHandler alert alert-success no-display">
                                                <i class="icon-ok"></i> Your form validation is successful!
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="control-label">
                                                    Student Name <span class="symbol required"></span>
                                                </label>
                                                <form:input path="name" placeholder="Insert your student Name"
                                                            cssClass="form-control" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="control-label">
                                                    Password <span class="symbol required"></span>
                                                </label>
                                                <form:password path="password" cssClass="form-control"/>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label">
                                                    Confirm Password <span class="symbol required"></span>
                                                </label>
                                                <form:password path="passwordAgain" cssClass="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <br/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div>
                                                <span class="symbol required"></span>Required Fields
                                                <hr>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <button class="btn btn-primary btn-block" type="submit">
                                                Reset <i class="icon-circle-arrow-right"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../include/footer.jsp"/>
    <jsp:include page="../include/footer_script.jsp"/>
</body>
</html>