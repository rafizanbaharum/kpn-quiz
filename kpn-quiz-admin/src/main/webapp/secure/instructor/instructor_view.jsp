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
    <link rel="stylesheet" href="/assets/plugins/summernote/build/summernote.css">
    <link rel="stylesheet" href="/assets/plugins/ckeditor/contents.css">
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
</head>
<!-- end: HEAD -->
<!-- start: BODY -->
<body class="footer-fixed layout-boxed">
<!-- start: HEADER -->
<div class="navbar navbar-inverse navbar-fixed-top">
    <!-- start: TOP NAVIGATION CONTAINER -->
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
                        <span class="username">Superman</span>
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
<!-- end: HEADER -->
<!-- start: MAIN CONTAINER -->
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
                    <span class="title"> Student Management </span><i class="icon-arrow"></i>
                    <span class="selected"></span>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/secure/instructor">
                            <span class="title">Register Student</span>
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
                    Student Management
                </a>
            </li>
            <li class="active">
                Register
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
                <form action="#" role="form" id="form">
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
                                    First Name <span class="symbol required"></span>
                                </label>
                                <input type="text" placeholder="Insert your First Name" class="form-control"
                                       id="firstname"
                                       name="firstname">
                            </div>
                            <div class="form-group">
                                <label class="control-label">
                                    Last Name <span class="symbol required"></span>
                                </label>
                                <input type="text" placeholder="Insert your Last Name" class="form-control"
                                       id="lastname"
                                       name="lastname">
                            </div>
                            <div class="form-group">
                                <label class="control-label">
                                    Email Address <span class="symbol required"></span>
                                </label>
                                <input type="email" placeholder="Text Field" class="form-control" id="email"
                                       name="email">
                            </div>
                            <div class="form-group">
                                <label class="control-label">
                                    Password <span class="symbol required"></span>
                                </label>
                                <input type="password" class="form-control" name="password" id="password">
                            </div>
                            <div class="form-group">
                                <label class="control-label">
                                    Confirm Password <span class="symbol required"></span>
                                </label>
                                <input type="password" class="form-control" id="password_again" name="password_again">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group connected-group">
                                <label class="control-label">
                                    Date of Birth <span class="symbol required"></span>
                                </label>

                                <div class="row">
                                    <div class="col-md-3">
                                        <select name="dd" id="dd" class="form-control">
                                            <option value="">DD</option>
                                            <option value="01">1</option>
                                            <option value="02">2</option>
                                            <option value="03">3</option>
                                            <option value="04">4</option>
                                            <option value="05">5</option>
                                            <option value="06">6</option>
                                            <option value="07">7</option>
                                            <option value="08">8</option>
                                            <option value="09">9</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                            <option value="13">13</option>
                                            <option value="14">14</option>
                                            <option value="15">15</option>
                                            <option value="16">16</option>
                                            <option value="17">17</option>
                                            <option value="18">18</option>
                                            <option value="19">19</option>
                                            <option value="20">20</option>
                                            <option value="21">21</option>
                                            <option value="22">22</option>
                                            <option value="23">23</option>
                                            <option value="24">24</option>
                                            <option value="25">25</option>
                                            <option value="26">26</option>
                                            <option value="27">27</option>
                                            <option value="28">28</option>
                                            <option value="29">29</option>
                                            <option value="30">30</option>
                                            <option value="31">31</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <select name="mm" id="mm" class="form-control">
                                            <option value="">MM</option>
                                            <option value="01">1</option>
                                            <option value="02">2</option>
                                            <option value="03">3</option>
                                            <option value="04">4</option>
                                            <option value="05">5</option>
                                            <option value="06">6</option>
                                            <option value="07">7</option>
                                            <option value="08">8</option>
                                            <option value="09">9</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <input type="text" placeholder="YYYY" id="yyyy" name="yyyy"
                                               class="form-control">
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
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label class="control-label">
                                            Zip Code <span class="symbol required"></span>
                                        </label>
                                        <input class="form-control" type="text" name="zipcode" id="zipcode">
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label class="control-label">
                                            City <span class="symbol required"></span>
                                        </label>
                                        <input class="form-control tooltips" type="text"
                                               data-original-title="We'll display it when you write reviews"
                                               data-rel="tooltip"
                                               title="" data-placement="top" name="city" id="city">
                                    </div>
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
                            </p>
                        </div>
                        <div class="col-md-4">
                            <button class="btn btn-yellow btn-block" type="submit">
                                Register <i class="icon-circle-arrow-right"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
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