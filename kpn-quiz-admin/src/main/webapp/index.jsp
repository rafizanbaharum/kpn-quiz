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
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
</head>
<body class="footer-fixed layout-boxed">
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button data-target=".navbar-collapse" data-toggle="collapse"
                    class="navbar-toggle" type="button">
                <span class="clip-list-2"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index">
                ASEAN QUIZ
            </a>
        </div>
        <div class="navbar-tools">
            <ul class="nav navbar-right">
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/gate/in"><i class="clip-locked"></i>
                        <span class="title"> Login </span>
                    </a>
                </li>
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/register"><i class="clip-user-plus"></i>
                        <span class="title"> Create an account </span>
                    </a>
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
                <li class="active open">
                    <a href="${pageContext.request.contextPath}/secure/index"><i class="clip-home-3"></i>
                        <span class="title"> Dashboard </span><span class="selected"></span>
                    </a>
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
                            <i class="clip-home-3"></i>
                            <a href="#">
                                Home
                            </a>
                        </li>
                        <li class="active">
                            Dashboard
                        </li>
                    </ol>
                    <div class="page-header">
                        <h1>Dashboard
                            <small>overview &amp; stats</small>
                        </h1>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <div class="core-box">
                        <div class="heading">
                            <i class="clip-user-4 circle-icon circle-green"></i>

                            <h2>Manage Users</h2>
                        </div>
                        <div class="content">
                            Manage user Instructor, Student and Support person.
                            View, edit or register new record.
                        </div>
                        <a class="view-more" href="${pageContext.request.contextPath}/secure/user/list">
                            View More <i class="clip-arrow-right-2"></i>
                        </a>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="core-box">
                        <div class="heading">
                            <i class="clip-clip circle-icon circle-teal"></i>

                            <h2>Manage Competition</h2>
                        </div>
                        <div class="content">
                            Manage your Round, Quiz and Questions.
                            View, edit or create new record.
                        </div>
                        <a class="view-more" href="${pageContext.request.contextPath}/secure/competition/list">
                            View More <i class="clip-arrow-right-2"></i>
                        </a>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="core-box">
                        <div class="heading">
                            <i class="clip-archive circle-icon circle-blue"></i>

                            <h2>Rules and Regulations</h2>
                        </div>
                        <div class="content">
                            Download Asean Quiz Rules and Regulations
                        </div>
                        <a class="view-more"
                           href="${pageContext.request.contextPath}/docs/KPN_QUIZ_Rules_Guidelines.doc">
                            Download Here <i class="clip-arrow-right-2"></i>
                        </a>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="core-box">
                        <div class="heading">
                            <i class="clip-settings circle-icon circle-bricky"></i>

                            <h2>Manual and Guidelines</h2>
                        </div>
                        <div class="content">
                            Download Asean Quiz's manual for students.
                        </div>
                        <a class="view-more" href="${pageContext.request.contextPath}/docs/KPN_QUIZ_Manual.doc">
                            Download Manual <i class="clip-arrow-right-2"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer clearfix">
    <div class="footer-inner">
        2013 &copy; ASEAN QUIZ
    </div>
    <div class="footer-items">
        <span class="go-top"><i class="clip-chevron-up"></i></span>
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
<script src="${pageContext.request.contextPath}/assets/js/index.js"></script>
<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script>
    jQuery(document).ready(function () {
        Main.init();
        Index.init();
    });
</script>
</body>
<!-- end: BODY -->
</html>