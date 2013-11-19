<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-12">

    <c:choose>
        <c:when test="${null != msgSuccess}">
            <%--<div class="errorHandler alert alert-danger no-display">--%>
            <div class="errorHandler alert alert-danger">
                <i class="icon-remove-sign"></i> You have some form errors. Please check
                below.
            </div>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${null != msgError}">
            <div class="successHandler alert alert-success">
                <i class="icon-ok"></i> Your form validation is successful!
            </div>
        </c:when>
    </c:choose>
</div>
