<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
</head>
<body class="footer-fixed layout-boxed">
<jsp:include page="../include/topbar.jsp"/>
<div class="main-container">
    <jsp:include page="../include/instructor_navbar.jsp"/>
    <div class="main-content">
        <div class="container">
            <jsp:include page="../include/instructor_breadcrumb.jsp">
                <jsp:param name="BREADCRUMB" value="TODO"/>
                <jsp:param name="TITLE" value="TODO"/>
            </jsp:include>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="icon-external-link-sign"></i>
                            View an instructor
                        </div>
                        <div class="panel-body">
                            <h2><i class="icon-edit-sign teal"></i> View</h2>
                            <hr>
                            <form:form id="form" commandName="instructorModel"
                                       action="${pageContext.request.contextPath}/secure/instructor/update"
                                       method="POST">
                                <div class="row">
                                    <jsp:include page="../include/msg.jsp"/>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label">
                                                Name <span class="symbol required"></span>
                                            </label>
                                            <form:input path="name"
                                                        cssClass="form-control" readonly="true"/>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">
                                                Username <span class="symbol required"></span>
                                            </label>
                                            <form:input path="username"
                                                        cssClass="form-control" readonly="true"/>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">
                                                School Name <span class="symbol required"></span>
                                            </label>
                                            <form:input path="schoolName"
                                                        cssClass="form-control" readonly="true"/>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">
                                                State Name <span class="symbol required"></span>
                                            </label>
                                            <form:input path="stateName"
                                                        cssClass="form-control" readonly="true"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="btn-group btn-group-justified">
                                            <a href="${pageContext.request.contextPath}/secure/quiz/edit/${quizModel.id}"
                                               class="btn btn-primary" title="Edit quiz">Edit</a>
                                            <a href="${pageContext.request.contextPath}/secure/quiz/remove/${quizModel.id}"
                                               class="btn btn-primary" title="Remove quiz">Remove</a>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="icon-external-link-sign"></i>
                            List of students
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover" id="sample-table-1">
                                <thead>
                                <tr>
                                    <th class="center">#</th>
                                    <th>Name</th>
                                    <th>NRIC NO</th>
                                    <th>Dob</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="studentModel" items="${studentModels}" varStatus="idx">
                                    <tr>
                                        <td class="center">${idx.count}</td>
                                        <td class="hidden-xs">${studentModel.name}</td>
                                        <td class="hidden-xs">${studentModel.nricNo}</td>
                                        <td class="hidden-xs">${studentModel.dobFormatted}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
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