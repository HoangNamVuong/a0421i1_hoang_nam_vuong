<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/29/2021
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/jquery/jquery-3.6.0.min.js"></script>
    <link type="text/css" href="/bootstrap-4.6.0-dist/css/bootstrap.css">
    <script src="/bootstrap-4.6.0-dist/js/bootstrap.js"></script>
</head>
<body>
<h1>List Student</h1>

<a href="student?action=add"> Add</a>

<c:if test="${mess!=null}">
    <strong style="color: red">${mess}</strong>
</c:if>
<table border="1" class="table table-striped">
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Class ID</th>
        <th>Point</th>
        <th>gender</th>
        <th>Email</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${studentList}" var="student" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.birthday}</td>
            <td>${student.classId}</td>
            <td>${student.point}</td>
            <td>
                <c:if test="${student.gender}">
                    <sp>Male</sp>
                </c:if>
                <c:if test="${!student.gender}">
                    <sp>Female</sp>
                </c:if>
            </td>
            <td>${student.email}</td>
            <td><a href="/student?action=edit&id=${student.id}">Edit</a></td>
        </tr>
    </c:forEach>

</table>
<script>

</script>
</body>
</html>
