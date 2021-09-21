<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
<style>
   <%@include file="/css/topmenu.css" %>
</style>
</style>
</head>
<body>
<table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
     <tr> <td>

<div class="topnav">
    <a <c:if test="${active==1}">class="active"</c:if> href="${pageContext.request.contextPath}/">Главная</a>
    <a <c:if test="${active==2}">class="active"</c:if> href="${pageContext.request.contextPath}/allDep">Отделы</a>
    <a <c:if test="${active==3}">class="active"</c:if> href="${pageContext.request.contextPath}/allPos">Должности</a>
    <a <c:if test="${active==4}">class="active"</c:if> href="${pageContext.request.contextPath}/allEmp?page=1">Сотрудники</a>
</div>
</td></tr>
</table>
</body>
</html>


