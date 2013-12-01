<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            List of quizzes
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover" id="sample-table-1">
                                <thead>
                                <tr>
                                    <th class="center">#</th>
                                    <th>Title</th>
                                    <th>Round</th>
                                    <th class="center">Current</th>
                                    <th class="center">Processed</th>
                                    <th class="center">Locked</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="quiz" items="${quizModels}" varStatus="idx">
                                    <tr>
                                        <td class="center">${idx.count}</td>
                                        <td class="hidden-xs">${quiz.titleAbbreviated}</td>
                                        <td class="hidden-xs center">${quiz.round}</td>
                                        <td class="hidden-xs center"><i class=${quiz.current ? "icon-check": "icon-check-empty"}></i></td>
                                        <td class="hidden-xs center"><i class=${quiz.processed ? "icon-check": "icon-check-empty"}></i></td>
                                        <td class="hidden-xs center"><i class=${quiz.locked ? "icon-check": "icon-check-empty"}></i></td>
                                        <td class="center">
                                            <div class="visible-md visible-lg hidden-sm hidden-xs">
                                                <a href="${pageContext.request.contextPath}/secure/quiz/view/${quiz.id}"
                                                   class="btn btn-primary tooltips" data-placement="top"
                                                   data-original-title="View"><i class="icon-archive"></i></a>
                                                <a href="${pageContext.request.contextPath}/secure/quiz/edit/${quiz.id}"
                                                   class="btn btn-primary tooltips" data-placement="top"
                                                   data-original-title="Edit"><i class="icon-edit"></i></a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="btn-group btn-group-justified">
                                <a href="${pageContext.request.contextPath}/secure/competition/view/${competitionModel.id}"
                                   class="btn btn-primary">Back to Competition</a>
                                <a href="${pageContext.request.contextPath}/secure/quiz/add"
                                   class="btn btn-primary">Add Quiz</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <br/>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/secure/include/footer.jsp"/>
<jsp:include page="/secure/include/footer_script.jsp"/>
</body>
</html>