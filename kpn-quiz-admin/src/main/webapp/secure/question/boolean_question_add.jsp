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
        <jsp:include page="../include/question_navbar.jsp"/>

        <div class="main-content">
            <div class="container">
                <jsp:include page="../include/question_breadcrumb.jsp">
                    <jsp:param name="BREADCRUMB" value="TODO"/>
                    <jsp:param name="TITLE" value="TODO"/>
                </jsp:include>

                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="icon-external-link-sign"></i>
                                Create a question
                            </div>
                            <div class="panel-body">
                                <h2><i class="icon-edit-sign teal"></i> QUESTION</h2>

                                <hr>
                                <form:form id="form" commandName="questionModel"
                                           action="${pageContext.request.contextPath}/secure/question/saveboolean"
                                           method="POST">
                                    <form:hidden path="quiz.id"/>
                                    <div class="row">
                                        <jsp:include page="../include/msg.jsp"/>

                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="control-label">
                                                    Statement <span class="symbol required"></span>
                                                </label>
                                                <form:textarea path="statement" placeholder="Insert question statement"
                                                               cols="100" rows="4"
                                                               cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <label class="control-label">
                                                Difficulty <span class="symbol required"></span>
                                            </label>
                                            <form:select path="difficulty" cssClass="form-control">
                                                <option value="">Select Level of Difficulty</option>
                                                <option value="0">Easy</option>
                                                <option value="1">Intermedia</option>
                                                <option value="2">Difficult</option>
                                            </form:select>
                                        </div>
                                        <div class="col-md-12">
                                            <label class="control-label">
                                                Answer Index <span class="symbol required"></span>
                                            </label>
                                            <form:select path="answerIndex" cssClass="form-control">
                                                <option value="">Select Answer Key Index</option>
                                                <option value="0">TRUE</option>
                                                <option value="1">FALSE</option>
                                            </form:select>
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
                                                Add <i class="icon-circle-arrow-right"></i>
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