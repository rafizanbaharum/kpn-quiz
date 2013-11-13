<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" href="/assets/plugins/summernote/build/summernote.css">
    <link rel="stylesheet" href="/assets/plugins/ckeditor/contents.css">
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
    <link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- end: HEAD -->
<!-- start: BODY -->
<body>
<!-- start: HEADER -->
<div class="navbar navbar-inverse navbar-fixed-top">
    <!-- start: TOP NAVIGATION CONTAINER -->
    <div class="container">
        <div class="navbar-header">
            <!-- start: RESPONSIVE MENU TOGGLER -->
            <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                <span class="clip-list-2"></span>
            </button>
            <!-- end: RESPONSIVE MENU TOGGLER -->
            <!-- start: LOGO -->
            <a class="navbar-brand" href="index.html">
                ASEAN QUIZ
            </a>
            <!-- end: LOGO -->
        </div>
        <div class="navbar-tools">
            <ul class="nav navbar-right">
                <!-- start: USER DROPDOWN -->
                <li class="dropdown current-user">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <img src="" class="circle-img" alt="">
                        <span class="username">User</span>
                        <i class="clip-chevron-down"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="pages_user_profile.html">
                                <i class="clip-user-2"></i>
                                &nbsp;My Profile
                            </a>
                        </li>
                        <li>
                            <a href="pages_calendar.html">
                                <i class="clip-calendar"></i>
                                &nbsp;My Calendar
                            </a>
                        <li>
                            <a href="pages_messages.html">
                                <i class="clip-bubble-4"></i>
                                &nbsp;My Messages (3)
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="utility_lock_screen.html"><i class="clip-locked"></i>
                                &nbsp;Lock Screen </a>
                        </li>
                        <li>
                            <a href="login_example1.html">
                                <i class="clip-exit"></i>
                                &nbsp;Log Out
                            </a>
                        </li>
                    </ul>
                </li>
                <!-- end: USER DROPDOWN -->
            </ul>
            <!-- end: TOP NAVIGATION MENU -->
        </div>
    </div>
    <!-- end: TOP NAVIGATION CONTAINER -->
</div>
<!-- end: HEADER -->
<!-- start: MAIN CONTAINER -->
<div class="main-container">
<div class="navbar-content">
    <!-- start: SIDEBAR -->
    <div class="main-navigation navbar-collapse collapse">
        <!-- start: MAIN MENU TOGGLER BUTTON -->
        <div class="navigation-toggler">
            <i class="clip-chevron-left"></i>
            <i class="clip-chevron-right"></i>
        </div>
        <!-- end: MAIN MENU TOGGLER BUTTON -->
        <!-- start: MAIN NAVIGATION MENU -->
        <ul class="main-navigation-menu">
            <li>
                <a href="index.html"><i class="clip-home-3"></i>
                    <span class="title"> Dashboard </span><span class="selected"></span>
                </a>
            </li>
            <li class="active open">
                <a href="javascript:void(0)"><i class="clip-pencil"></i>
                    <span class="title"> Student Management </span><i class="icon-arrow"></i>
                    <span class="selected"></span>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a href="/secure/index">
                            <span class="title">Register</span>
                        </a>
                    </li>
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a href="/secure/studentList">
                            <span class="title">Student List</span>
                        </a>
                    </li>
                </ul>
            </li>

        </ul>
        <!-- end: MAIN NAVIGATION MENU -->
    </div>
    <!-- end: SIDEBAR -->
</div>
<!-- start: PAGE -->
<div class="main-content">
<!-- start: PANEL CONFIGURATION MODAL FORM -->
<div class="modal fade" id="panel-config" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">Panel Configuration</h4>
            </div>
            <div class="modal-body">
                Here will be a configuration form
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    Close
                </button>
                <button type="button" class="btn btn-primary">
                    Save changes
                </button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<!-- end: SPANEL CONFIGURATION MODAL FORM -->
<div class="container">
<!-- start: PAGE HEADER -->
<div class="row">
    <div class="col-sm-12">
        <!-- start: STYLE SELECTOR BOX -->
        <div id="style_selector">
            <div id="style_selector_container">
                <div class="style-main-title">
                    Style Selector
                </div>
                <div class="box-title">
                    Choose Your Layout Style
                </div>
                <div class="input-box">
                    <div class="input">
                        <select name="layout">
                            <option value="default">Wide</option>
                            <option value="boxed">Boxed</option>
                        </select>
                    </div>
                </div>
                <div class="box-title">
                    Choose Your Header Style
                </div>
                <div class="input-box">
                    <div class="input">
                        <select name="header">
                            <option value="fixed">Fixed</option>
                            <option value="default">Default</option>
                        </select>
                    </div>
                </div>
                <div class="box-title">
                    Choose Your Footer Style
                </div>
                <div class="input-box">
                    <div class="input">
                        <select name="footer">
                            <option value="default">Default</option>
                            <option value="fixed">Fixed</option>
                        </select>
                    </div>
                </div>
                <div class="box-title">
                    Backgrounds for Boxed Version
                </div>
                <div class="images boxed-patterns">
                    <a id="bg_style_1" href="#"><img alt="" src="/assets/images/bg.png"></a>
                    <a id="bg_style_2" href="#"><img alt="" src="/assets/images/bg_2.png"></a>
                    <a id="bg_style_3" href="#"><img alt="" src="/assets/images/bg_3.png"></a>
                    <a id="bg_style_4" href="#"><img alt="" src="/assets/images/bg_4.png"></a>
                    <a id="bg_style_5" href="#"><img alt="" src="/assets/images/bg_5.png"></a>
                </div>
                <div class="box-title">
                    5 Predefined Color Schemes
                </div>
                <div class="images icons-color">
                    <a id="light" href="#"><img class="active" alt="" src="/assets/images/lightgrey.png"></a>
                    <a id="dark" href="#"><img alt="" src="/assets/images/darkgrey.png"></a>
                    <a id="black_and_white" href="#"><img alt="" src="/assets/images/blackandwhite.png"></a>
                    <a id="navy" href="#"><img alt="" src="/assets/images/navy.png"></a>
                    <a id="green" href="#"><img alt="" src="/assets/images/green.png"></a>
                </div>
                <div style="height:25px;line-height:25px;" class="box-title">
                    <a class="clear_style" href="#">
                        Clear Styles
                    </a>
                </div>
            </div>
            <div class="style-toggle close"></div>
        </div>
        <!-- end: STYLE SELECTOR BOX -->
        <!-- start: PAGE TITLE & BREADCRUMB -->
        <ol class="breadcrumb">
            <li>
                <i class="clip-pencil"></i>
                <a href="#">
                    Student Management
                </a>
            </li>
            <li class="active">
                List
            </li>
            <li class="search-box">
                <form class="sidebar-search">
                    <div class="form-group">
                        <input type="text" placeholder="Start Searching...">
                        <button class="submit">
                            <i class="clip-search-3"></i>
                        </button>
                    </div>
                </form>
            </li>
        </ol>
        <div class="page-header">
            <h1>Student Registration </h1>
        </div>
        <!-- end: PAGE TITLE & BREADCRUMB -->
    </div>
</div>
<!-- end: PAGE HEADER -->
<!-- start: PAGE CONTENT -->
<div class="row">
<div class="col-md-12">
<!-- start: FORM VALIDATION 1 PANEL -->
<div class="panel panel-default">
<div class="panel-heading">
    <i class="icon-external-link-sign"></i>
    Register a student
    <div class="panel-tools">
        <a class="btn btn-xs btn-link panel-collapse collapses" href="#">
        </a>
        <a class="btn btn-xs btn-link panel-config" href="#panel-config" data-toggle="modal">
            <i class="icon-wrench"></i>
        </a>
        <a class="btn btn-xs btn-link panel-refresh" href="#">
            <i class="icon-refresh"></i>
        </a>
        <a class="btn btn-xs btn-link panel-expand" href="#">
            <i class="icon-resize-full"></i>
        </a>
        <a class="btn btn-xs btn-link panel-close" href="#">
            <i class="icon-remove"></i>
        </a>
    </div>
</div>
<div class="panel-body">
    <h2><i class="icon-edit-sign teal"></i> REGISTER</h2>

    <hr>
        <form:form commandName="studentModel" action="${pageContext.request.contextPath}/register/addStudent" method="POST" >
        <form:hidden path="instructorId" />
        <div class="row">
            <div class="col-md-12">
                <div class="errorHandler alert alert-danger no-display">
                    <i class="icon-remove-sign"></i> You have some form errors. Please check below.
                </div>
                <div class="successHandler alert alert-success no-display">
                    <i class="icon-ok"></i> Your form validation is successful!
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label class="control-label">
                        Name <span class="symbol required"></span>
                    </label>
                    <form:input path="name" placeholder="Insert your student Name" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <label class="control-label">
                        NRIC <span class="symbol required"></span>
                    </label>
                    <form:input path="nric" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <label class="control-label">
                        Username <span class="symbol required"></span>
                    </label>
                    <form:input path="username" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <label class="control-label">
                        Password <span class="symbol required"></span>
                    </label>
                    <form:password path="password" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <label class="control-label">
                        Confirm Password <span class="symbol required"></span>
                    </label>
                    <form:password path="passwordAgain" cssClass="form-control" />
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group connected-group">
                    <label class="control-label">
                        Date of Birth <span class="symbol required"></span>
                    </label>

                    <div class="row">
                        <div class="col-md-3">
                            <form:select path="dob_dd" cssClass="form-control">
                                <form:option value="-">DD</form:option>
                                 <%
                                     for(int i = 1; i <= 31; i++)
                                         out.println("<option value="+ i +">"+ i +"</option>");
                                 %>
                            </form:select>
                        </div>
                        <div class="col-md-3">
                            <form:select path="dob_mm" cssClass="form-control">
                                <form:option value="-">MM</form:option>
                                 <%
                                     for(int i = 1; i <= 12; i++)
                                         out.println("<option value="+ i +">"+ i +"</option>");
                                 %>
                            </form:select>
                        </div>
                        <div class="col-md-3">
                            <form:input path="dob_yyyy" placeholder="yyyy" cssClass="form-control" />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label">
                        Gender <span class="symbol required"></span>
                    </label>

                    <div>
                        <label class="radio-inline">
                            <input type="radio" class="grey" value="" name="gender" id="gender_female">
                            Female
                        </label>
                        <label class="radio-inline">
                            <input type="radio" class="grey" value="" name="gender" id="gender_male">
                            Male
                        </label>
                    </div>
                </div>
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
            <div class="col-md-8">
                <p>
                    By clicking REGISTER, you are agreeing to the Policy and Terms &amp; Conditions.
                </p>
            </div>
            <div class="col-md-4">
                <button class="btn btn-yellow btn-block" type="submit">
                    Register <i class="icon-circle-arrow-right"></i>
                </button>
            </div>
        </div>
    </form:form>
</div>
</div>
<!-- end: FORM VALIDATION 1 PANEL -->
</div>
</div>

</div>
</div>
<!-- end: PAGE -->
</div>
<!-- end: MAIN CONTAINER -->
<!-- start: FOOTER -->
<div class="footer clearfix">
    <div class="footer-inner">
        2013 &copy; ASEAN QUIZ
    </div>
    <div class="footer-items">
        <span class="go-top"><i class="clip-chevron-up"></i></span>
    </div>
</div>
<!-- end: FOOTER -->
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
<script src="/assets/plugins/summernote/build/summernote.min.js"></script>
<script src="/assets/plugins/ckeditor/ckeditor.js"></script>
<script src="/assets/plugins/ckeditor/adapters/jquery.js"></script>
<script src="/assets/js/form-validation.js"></script>
<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script>
    jQuery(document).ready(function () {
        Main.init();
        FormValidator.init();
    });
</script>
</body>
<!-- end: BODY -->
</html>