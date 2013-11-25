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
    <link rel="shortcut icon" href="/assets/images/favicon/favicon.ico"/>
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
<body class="footer-fixed layout-boxed">
<jsp:include page="/secure/include/topbar.jsp"/>
<div class="main-container">
    <jsp:include page="/secure/include/question_navbar.jsp"/>

    <div class="main-content">
        <div class="container">
            <jsp:include page="/secure/include/question_breadcrumb.jsp">
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
                            <form:form id="form"
                                       commandName="questionModel"
                                       action="${pageContext.request.contextPath}/secure/question/savemultiplechoice"
                                       method="POST">
                                <form:hidden path="quiz.id"/>
                                <div class="row">
                                    <jsp:include page="/secure/include/msg.jsp"/>

                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label">
                                                Statement <span class="symbol required"></span>
                                            </label>
                                            <form:input path="statement" placeholder="Insert question statement"
                                                        cssClass="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <label class="control-label">
                                            Difficulty <span class="symbol required"></span>
                                        </label>
                                        <form:select path="difficulty" cssClass="form-control">
                                            <option value="">Select level of Difficulty</option>
                                            <form:options items="${difficultiesMap}" />
                                        </form:select>
                                    </div>
                                    <div class="col-md-12">
                                        <label class="control-label">
                                            Answer Index <span class="symbol required"></span>
                                        </label>
                                        <form:select path="answerIndex" cssClass="form-control">
                                            <option value="">Select Answer Key Index</option>
                                            <form:options items="${answerMap}" />
                                        </form:select>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label">
                                                Choice A <span class="symbol required"></span>
                                            </label>
                                            <form:input path="choice1" placeholder="Insert question choice1"
                                                        cssClass="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label">
                                                Choice B <span class="symbol required"></span>
                                            </label>
                                            <form:input path="choice2" placeholder="Insert question choice2"
                                                        cssClass="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label">
                                                Choice C <span class="symbol required"></span>
                                            </label>
                                            <form:input path="choice3" placeholder="Insert question choice3"
                                                        cssClass="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label">
                                                Choice D <span class="symbol required"></span>
                                            </label>
                                            <form:input path="choice4" placeholder="Insert question choice4"
                                                        cssClass="form-control"/>
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
<jsp:include page="/secure/include/footer.jsp"/>
<jsp:include page="/secure/include/footer_script.jsp"/>
</body>
</html>