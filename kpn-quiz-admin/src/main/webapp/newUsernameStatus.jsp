<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:choose>
        <c:when test="${status eq true}">
            <div class="alert error"><span class="icon"></span>
                <strong>Name Not available</strong>
                <p>Please choose another name</p>
            </div>
        </c:when>
        <c:otherwise>
            <%--<div class="alert success">--%>
                <%--<span class="icon"></span><span class="hide">x</span>--%>
                <%--<strong>Name available</strong>--%>
            <%--</div>--%>
        </c:otherwise>
    </c:choose>