<%@ include file="/WEB-INF/views/header.jsp" %>
<h2>Add New Course</h2>
<form action="${pageContext.request.contextPath}/courses/add" method="post">
    <div class="form-group">
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" value="" required />
    </div>
    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="" required />
    </div>
    <div class="form-group">
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="" required />
    </div>
    <div class="form-group">
        <label for="credits">Credits:</label>
        <input type="number" id="credits" name="credits" value="" required />
    </div>
    <button type="submit" class="btn">Save</button>
    <a href="${pageContext.request.contextPath}/courses" class="btn">Cancel</a>
</form>
<%@ include file="/WEB-INF/views/footer.jsp" %>