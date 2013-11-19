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
    <link rel="shortcut icon" href="/assets/images/favicon/favicon.ico">
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
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
</head>
<body class="footer-fixed layout-boxed">
<jsp:include page="/secure/include/topbar.jsp" />
<div class="main-container">
   <jsp:include page="/secure/include/instructor_navbar.jsp" />
    <div class="main-content">
        <div class="container">
           <jsp:include page="/secure/include/instructor_breadcrumb.jsp" />
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
                            Manage your Quiz and Questions.
                            View, edit or create new record.
                        </div>
                        <a class="view-more" href="${pageContext.request.contextPath}/secure/quiz/list">
                            View More <i class="clip-arrow-right-2"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/secure/include/footer.jsp"/>


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
<script src="/assets/js/index.js"></script>
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