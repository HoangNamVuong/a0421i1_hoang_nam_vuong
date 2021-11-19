<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/29/2021
  Time: 2:42 AM
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
<h1>Edit TComplex</h1>
<form action="/tComplex?action=edit" method="post">
    ID      <input type="text" name="idMatBang"  value="${tComplex.idMatBang}"><br>
    Ma MB      <input type="text" name="maMatBang" value="${tComplex.maMatBang}"><br>
    Dien Tich      <input type="text" name="dienTich" value="${tComplex.dienTich}"><br>
<%--    Trang Thai    <input type="text" name="idTrangThai" value="${tComplex.idTrangThai}"><br>--%>
    Trang Thai       <select name="idTrangThai">
    <option value="0">--chon trang thai--</option>
    <c:forEach items="${trangThaiList}" var="trangThai">
        <option value="${trangThai.idTrangThai}"${trangThai.idTrangThai==tComplex.idTrangThai?"selected":""}>${trangThai.kieuTrangThai}</option>
        <%--                    <c:if test="${!class1.id==student.classId}">--%>
        <%--                        <option value="${class1.id}">${class1.name}</option>--%>
        <%--                    </c:if>--%>
    </c:forEach>
</select><br>
    So Tang      <input type="text" name="idSoTang" value="${tComplex.idSoTang}"><br>
    Loai MB    <input type="text" name="idLoaiMatBang" value="${tComplex.idLoaiMatBang}"><br>
    Gia Tien     <input type="text" name="giaTien" value="${tComplex.giaTien}"><br>
    Ngay Bat Dau  <input type="date" name="ngayBatDau" value="${tComplex.ngayBatDau}"><br>
    Ngay Ket Thuc  <input type="date" name="ngayKetThuc" value="${tComplex.ngayKetThuc}"><br>
    <button type="submit">Add</button>
   </form>
</body>
</html>
