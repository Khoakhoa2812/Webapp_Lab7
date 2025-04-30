<%@ include file="../header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Admin Dashboard</h2>

<c:if test="${not empty admin}">
    <table>
        <tr>
            <th>Full Name:</th>
            <td>${admin.name}</td>
        </tr>
        <tr>
            <th>Access Level:</th>
            <td>${admin.access_level}</td>
        </tr>
        <tr>
            <th>Last Login:</th>
            <td>${admin.last_login}</td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/home" class="btn">Home</a>
    <br/>
</c:if>

<c:if test="${empty admin}">
    <p>Error: Admin data not available.</p>
</c:if>

<%@ include file="../footer.jsp" %>
