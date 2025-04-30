<%@ include file="../header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Teacher Dashboard</h2>

<c:if test="${not empty teacher}">
    <table>
        <tr>
            <th>Full Name:</th>
            <td>${teacher.name}</td>
        </tr>
        <tr>
            <th>Department:</th>
            <td>${teacher.department}</td>
        </tr>
        <tr>
            <th>Hire Date:</th>
            <td>${teacher.hiredate}</td>
        </tr>
        <tr>
            <th>Office:</th>
            <td>${teacher.office}</td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/home" class="btn">Home</a>
    <br/>
</c:if>

<c:if test="${empty teacher}">
    <p>Error: Teacher data not available.</p>
</c:if>

<%@ include file="../footer.jsp" %>
