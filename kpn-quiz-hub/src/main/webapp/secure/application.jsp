<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>ASEAN Quiz - KPN</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/qa.css">
    <script language='javascript' src="${pageContext.request.contextPath}/gxt/flash/swfobject.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/gxt/css/gxt-all.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/gxt/css/gxt-gray.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/gxt/css/resources.css"/>
    <link rel="SHORTCUT ICON" href="${pageContext.request.contextPath}/assets/images/favicon/favicon.ico"/>
    <meta name="gwt:property" content="locale=ms">
</head>
<body style="overflow: hidden">
<div id="loading">
    <div class="loading-indicator">
        <img src="${pageContext.request.contextPath}/gxt/images/default/shared/large-loading.gif"
             width="32" height="32" style="margin-right:8px;float:left;vertical-align:top;"/>
        Quiz<br/>
        <span id="loading-msg">Loading&nbsp;Application...</span></div>
</div>
<script type="text/javascript" language="javascript"
        src="${pageContext.request.contextPath}/quiz/quiz.nocache.js"></script>
</body>
</html>
