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
<body class="footer-fixed layout-boxed">
<jsp:include page="/secure/include/topbar.jsp"/>
<div class="main-container">
    <jsp:include page="/secure/include/quiz_navbar.jsp"/>
    <div class="main-content">
        <div class="container">
            <jsp:include page="/secure/include/quiz_breadcrumb.jsp">
                <jsp:param name="BREADCRUMB" value="TODO"/>
                <jsp:param name="TITLE" value="TODO"/>
            </jsp:include>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="icon-external-link-sign"></i>
                            View a quiz
                        </div>
                        <div class="panel-body">
                            <h2><i class="icon-edit-sign teal"></i> View</h2>
                            <hr>
                            <form:form id="form" commandName="quizModel"
                                       action="${pageContext.request.contextPath}/secure/quiz/update"
                                       method="POST">
                                <div class="row">
                                    <jsp:include page="/secure/include/msg.jsp"/>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label">
                                                Title <span class="symbol required"></span>
                                            </label>
                                            <form:input path="title" placeholder="Insert title"
                                                        cssClass="form-control" readonly="true"/>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">
                                                Round <span class="symbol required"></span>
                                            </label>
                                            <form:input path="round" placeholder="Insert round"
                                                        cssClass="form-control" readonly="true"/>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">
                                                Start Date <span class="symbol required"></span>
                                            </label>
                                            <input type="text" class="form-control" readonly="true"
                                                   value="${quizModel.startDateFormatted}"/>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">
                                                End Date <span class="symbol required"></span>
                                            </label>
                                            <input type="text" class="form-control" readonly="true"
                                                   value="${quizModel.endDateFormatted}"/>
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
                                            <a href="${pageContext.request.contextPath}/secure/participant/browse?page=1&quizId=${quizModel.id}"
                                               class="btn btn-primary" title="View quiz participants">Participants</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="btn-group btn-group-justified">
                                            <a href="${pageContext.request.contextPath}/secure/quiz/current/${quizModel.id}"
                                               class="btn btn-primary"
                                               title="Make this quiz current">Current</a>
                                            <a href="${pageContext.request.contextPath}/secure/quiz/init/${quizModel.id}"
                                               class="btn btn-primary"
                                               title="Initialize quiz with participants">Init</a>
                                            <a href="${pageContext.request.contextPath}/secure/quiz/process/${quizModel.id}"
                                               class="btn btn-primary" title="Process quiz gradebooks">Process</a>
                                            <a href="${pageContext.request.contextPath}/secure/quiz/tabulate/${quizModel.id}"
                                               class="btn btn-primary" title="Tabulate quiz results">Tabulate</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="btn-group btn-group-justified">
                                            <a href="${pageContext.request.contextPath}/secure/quiz/view/${quizModel.id}/question/add/multiplechoice"
                                               class="btn btn-primary" title="Add multiple choice question">Add Multiple
                                                Choice</a>
                                            <a href="${pageContext.request.contextPath}/secure/quiz/view/${quizModel.id}/question/add/boolean"
                                               class="btn btn-primary" title="Add boolean question">Add Boolean</a>
                                            <a href="${pageContext.request.contextPath}/secure/quiz/view/${quizModel.id}/question/add/subjective"
                                               class="btn btn-primary" title="Add subjective question">Add
                                                Subjective</a>
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
                            List of questions
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover" id="sample-table-1">
                                <thead>
                                <tr>
                                    <th class="center">#</th>
                                    <th>Statement</th>
                                    <th>Type</th>
                                    <th>Difficulty</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="competition" items="${questionModels}" varStatus="idx">
                                    <tr>
                                        <td class="center">${idx.count}</td>
                                        <td class="hidden-xs">${competition.statementAbbreviated}</td>
                                        <td class="hidden-xs">${competition.questionTypeString}</td>
                                        <td class="hidden-xs">${competition.difficulty}</td>
                                        <td class="center">
                                            <div class="visible-md visible-lg hidden-sm hidden-xs">
                                                <a href="${pageContext.request.contextPath}/secure/question/view/${competition.id}"
                                                   class="btn btn-primary tooltips" data-placement="top"
                                                   data-original-title="View"><i class="icon-archive"></i></a>
                                                <a href="${pageContext.request.contextPath}/secure/question/edit/${competition.id}"
                                                   class="btn btn-primary tooltips" data-placement="top"
                                                   data-original-title="Edit"><i class="icon-edit"></i></a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <button class="btn btn-primary btn-block" type="submit">
                        Add Question <i class="icon-circle-arrow-right"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/secure/include/footer.jsp"/>
<jsp:include page="/secure/include/footer_script.jsp"/>
</body>
</html>