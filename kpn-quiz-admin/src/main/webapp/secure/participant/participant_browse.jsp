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
    <jsp:include page="../include/participant_navbar.jsp"/>
    <div class="main-content">
        <div class="container">
            <jsp:include page="../include/participant_breadcrumb.jsp">
                <jsp:param name="BREADCRUMB" value="TODO"/>
                <jsp:param name="TITLE" value="TODO"/>
            </jsp:include>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="icon-external-link-sign"></i>
                            List of quiz participants
                        </div>
                        <div class="panel-body">
                            <form id="form"
                                  action="${pageContext.request.contextPath}/secure/participant/browse/sort"
                                  method="GET">
                                <input type="hidden" name="page" value="${page}"/>
                                <input type="hidden" name="quizId" value="${quizModel.id}"/>

                                <div class="form-group">
                                    <select id="form-field-select-1" class="form-control" name="sortOption">
                                        <option value="">Please select</option>
                                        <option value="0">School</option>
                                        <option value="1">District</option>
                                        <option value="2">State</option>
                                    </select>
                                </div>
                                <input type="submit" value="Sort" class="btn btn-primary">
                            </form>
                            <br/>
                            <table class="table table-hover" id="sample-table-1">
                                <thead>
                                <tr>
                                    <th class="center">#</th>
                                    <th>Name</th>
                                    <th>NRIC</th>
                                    <th>School</th>
                                    <th>State</th>
                                    <th class="center">Next Round?</th>
                                    <th class="center">Result</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="participant" items="${participantModels}" varStatus="idx">
                                    <tr>
                                        <td class="center">${idx.count}</td>
                                        <td class="hidden-xs">${participant.name}</td>
                                        <td class="hidden-xs">${participant.nricNo}</td>
                                        <td class="hidden-xs">${participant.school}</td>
                                        <td class="hidden-xs">${participant.state}</td>
                                        <td class="hidden-xs center">
                                            <i class=${participant.selected ? "icon-check": "icon-check-empty"}></i>
                                        </td>
                                        <td class="hidden-xs center">${participant.result}</td>
                                        <td class="center">
                                            <div class="visible-md visible-lg hidden-sm hidden-xs">
                                                <a href="${pageContext.request.contextPath}/secure/participant/view/${participant.id}"
                                                   class="btn btn-primary tooltips" data-placement="top"
                                                   data-original-title="View"><i class="icon-archive"></i></a>
                                                <a href="${pageContext.request.contextPath}/secure/participant/remove/${participant.id}"
                                                   class="btn btn-primary tooltips" data-placement="top"
                                                   data-original-title="Remove"><i class="icon-remove"></i></a>
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
                <div class="col-md-12">
                    <div class="btn-group btn-group-justified">
                        <a href="${pageContext.request.contextPath}/secure/participant/browse?page=${previous}&quizId=${quizModel.id}"
                           class="btn btn-primary" ${!hasPrevious?"disabled":""}>Previous</a>
                        <a href="${pageContext.request.contextPath}/secure/participant/browse?page=${next}&quizId=${quizModel.id}"
                           class="btn btn-primary" ${!hasNext?"disabled":""}>Next</a>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="btn-group btn-group-justified">
                        <a href="${pageContext.request.contextPath}/secure/quiz/view/${quizModel.id}"
                           class="btn btn-primary">Back To Quiz</a>
                        <a href="${pageContext.request.contextPath}/secure/quiz/view/${quizModel.id}/participant/select/reset"
                           class="btn btn-primary">Reset</a>
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

