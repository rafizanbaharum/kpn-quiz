<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                                List of instructors
                            </div>
                            <div class="panel-body">
                                <table class="table table-hover" id="sample-table-1">
                                    <thead>
                                        <tr>
                                            <th class="center">#</th>
                                            <th>Username</th>
                                            <th>Name</th>
                                            <th>Phone</th>
                                            <th>Type</th>
                                            <th>School</th>
                                            <th>State</th>
                                            <th>School Phone</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:choose>
                                            <c:when test="${fn:length(instructorModels) gt 0}">
                                                <c:forEach var="instructor" items="${instructorModels}" varStatus="idx">
                                                    <tr>
                                                        <td class="center">${idx.count}</td>
                                                        <td class="hidden-xs">${instructor.username}</td>
                                                        <td class="hidden-xs">${instructor.name}</td>
                                                        <td class="hidden-xs">${instructor.phone}</td>
                                                        <td class="hidden-xs">${instructor.schoolType}</td>
                                                        <td class="hidden-xs">${instructor.schoolName}</td>
                                                        <td class="hidden-xs">${instructor.stateName}</td>
                                                        <td class="hidden-xs">${instructor.schoolPhone}</td>
                                                        <td class="center">
                                                            <div class="visible-md visible-lg hidden-sm hidden-xs">
                                                                <a href="${pageContext.request.contextPath}/secure/instructor/view/${instructor.id}"
                                                                   class="btn btn-primary tooltips" data-placement="top"
                                                                   data-original-title="View"><i
                                                                        class="icon-archive"></i>
                                                                </a>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <tr>
                                                    <td>Nothing to preview</td>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="btn-group btn-group-justified">
                            <a href="${pageContext.request.contextPath}/secure/instructor/browse?page=${previous}"
                               class="btn btn-primary" ${!hasPrevious?"disabled":""}>Previous</a>
                            <a href="${pageContext.request.contextPath}/secure/instructor/browse?page=${next}"
                               class="btn btn-primary" ${!hasNext?"disabled":""}>Next</a>
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

