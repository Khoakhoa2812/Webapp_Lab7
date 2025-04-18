<%@ include file="/WEB-INF/views/header.jsp" %>
<h2>Course List</h2>
<c:if test="${courses.size() == 0}">
    <p>No courses found.</p>
</c:if>
<c:if test="${courses.size() > 0}">
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Code</th>
                <th>Name</th>
                <th>Description</th>
                <th>Credits</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.code}</td>
                    <td>${course.name}</td>
                    <td>${course.description}</td>
                    <td>${course.credits}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/courses/view/${course.id}" class="btn">View</a>
                        <a href="${pageContext.request.contextPath}/courses/edit/${course.id}" class="btn">Edit</a>
                        <a href="${pageContext.request.contextPath}/courses/delete/${course.id}" class="btn" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
<a href="${pageContext.request.contextPath}/courses/new" class="btn">Add New Course</a>
<%@ include file="/WEB-INF/views/footer.jsp" %>
