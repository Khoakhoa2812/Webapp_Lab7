<%@ include file="header.jsp" %>
<h2>Course Details</h2>

<div>
    <p><strong>ID:</strong> ${course.id}</p>
    <p><strong>Code:</strong> ${course.code}</p>
    <p><strong>Name:</strong> ${course.name}</p>
    <p><strong>Description:</strong> ${course.description}</p>
    <p><strong>Credits:</strong> ${course.credits}</p>
</div>

<a href="${pageContext.request.contextPath}/course/edit?id=${course.id}" class="btn">Edit</a>
<a href="${pageContext.request.contextPath}/courses" class="btn">Back to List</a>
<%@ include file="footer.jsp" %>
