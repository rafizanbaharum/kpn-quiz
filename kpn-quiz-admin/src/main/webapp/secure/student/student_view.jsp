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
    <jsp:include page="/secure/include/student_navbar.jsp"/>
    <div class="main-content">
        <div class="container">
            <jsp:include page="/secure/include/student_breadcrumb.jsp">
                <jsp:param name="BREADCRUMB" value="${STUDENT_BREADCRUMB}"/>
                <jsp:param name="TITLE" value="${STUDENT_TITLE}"/>
            </jsp:include>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="icon-external-link-sign"></i>
                            View a student
                        </div>
                        <div class="panel-body">
                            <h2><i class="icon-edit-sign teal"></i> VIEW</h2>

                            <hr>
                            <form:form id="form" commandName="studentModel"
                                       action="${pageContext.request.contextPath}/secure/student/update"
                                       method="POST">
                                <form:hidden path="id"/>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="errorHandler alert alert-danger no-display">
                                            <i class="icon-remove-sign"></i> You have some form errors. Please check
                                            below.
                                        </div>
                                        <div class="successHandler alert alert-success no-display">
                                            <i class="icon-ok"></i> Your form validation is successful!
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="control-label">
                                                Student Name <span class="symbol required"></span>
                                            </label>
                                            <form:input path="name" placeholder="Insert your student Name"
                                                        cssClass="form-control" readonly="true"/>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">
                                                NRIC <span class="symbol required"></span>
                                            </label>
                                            <form:input path="nric" placeholder="Identification number"
                                                        cssClass="form-control" readonly="true"/>

                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">
                                                Username <span class="symbol required"></span>
                                            </label>
                                            <form:input path="username" placeholder="Username" cssClass="form-control"
                                                        readonly="true"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group connected-group">
                                            <label class="control-label">
                                                Date of Birth <span class="symbol required"></span>
                                            </label>

                                            <div class="row">
                                                <div class="col-md-4">
                                                    <form:select path="dob_dd" cssClass="form-control" disabled="true">
                                                        <option value="">DD</option>
                                                        <c:forEach begin="1" end="31" var="dd">
                                                            <option value="${dd}" ${dd == studentModel.dob_dd ? 'selected' : ''}>${dd}</option>
                                                        </c:forEach>
                                                    </form:select>
                                                </div>
                                                <div class="col-md-4">
                                                    <form:select path="dob_mm" cssClass="form-control" disabled="true">
                                                        <option value="">MM</option>
                                                        <c:forEach begin="1" end="12" var="mm">
                                                            <option value="${mm}" ${mm == studentModel.dob_mm ? 'selected' : ''}>${mm}</option>
                                                        </c:forEach>
                                                    </form:select>
                                                </div>
                                                <div class="col-md-4">
                                                    <form:input path="dob_yyyy" placeholder="YYYY"
                                                                cssClass="form-control" disabled="true"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <br/>
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
                                    <div class="col-md-4">
                                        <button class="btn btn-primary btn-block" type="submit">
                                            Edit <i class="icon-circle-arrow-right"></i>
                                        </button>
                                    </div>
                                    <div class="col-md-4">
                                        <button class="btn btn-primary btn-block" type="submit">
                                            Reset <i class="icon-circle-arrow-right"></i>
                                        </button>
                                    </div>
                                    <div class="col-md-4">
                                        <button class="btn btn-primary btn-block" type="submit">
                                            Remove <i class="icon-circle-arrow-right"></i>
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