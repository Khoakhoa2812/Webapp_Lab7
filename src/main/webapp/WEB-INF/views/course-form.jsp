<%@ include file="header.jsp" %>
<c:if test="${course != null}">
    <h2>Edit Course</h2>
    <form action="${pageContext.request.contextPath}/course/update" method="post">
        <input type="hidden" name="id" value="${course.id}" />
</c:if>
<c:if test="${course == null}">
    <h2>Add New Course</h2>
    <form action="${pageContext.request.contextPath}/course/add" method="post">
</c:if>

    <div class="form-group">
        <label>Code:</label>
        <input type="text" name="code" value="${course.code}" required />
    </div>
    <div class="form-group">
        <label>Name:</label>
        <input type="text" name="name" value="${course.name}" required />
    </div>
    <div class="form-group">
        <label>Description:</label>
        <input type="text" name="description" value="${course.description}" />
    </div>
    <div class="form-group">
        <label>Credits:</label>
        <input type="number" name="credits" value="${course.credits}" min="0" />
    </div>
    <button type="submit" class="btn">Save</button>
    <a href="${pageContext.request.contextPath}/courses" class="btn">Cancel</a>
</form>
<%@ include file="footer.jsp" %>
