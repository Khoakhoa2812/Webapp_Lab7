<%@ include file="header.jsp" %>
<h2>Course List</h2>

<table>
    <thead>
        <tr><th>ID</th><th>Code</th><th>Name</th><th>Credits</th><th>Actions</th></tr>
    </thead>
    <tbody>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.id}</td>
                <td>${course.code}</td>
                <td>${course.name}</td>
                <td>${course.credits}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/course/view?id=${course.id}" class="btn">View</a>
                    <a href="${pageContext.request.contextPath}/course/edit?id=${course.id}" class="btn">Edit</a>
                    <a href="${pageContext.request.contextPath}/course/delete?id=${course.id}" class="btn"
                       onclick="return confirm('Are you sure you want to delete this course?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/course/new" class="btn">Add New Course</a>
<%@ include file="footer.jsp" %>
