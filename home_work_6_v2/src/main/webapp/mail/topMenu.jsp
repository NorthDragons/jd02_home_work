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
<c:set var="active" value="${active}"/>
<c:choose>
    <c:when test="${active==1}">
              <a class="active" href="${pageContext.request.contextPath}/">Главная</a>
              <a href="${pageContext.request.contextPath}/allDep">Отделы</a>
              <a href="${pageContext.request.contextPath}/allPos">Должности</a>
              <a href="${pageContext.request.contextPath}/allEmp">Сотрудники</a>
    </c:when>
    <c:when test="${active==2}">
              <a href="${pageContext.request.contextPath}/">Главная</a>
              <a class="active" href="${pageContext.request.contextPath}/allDep">Отделы</a>
              <a href="${pageContext.request.contextPath}/allPos">Должности</a>
              <a href="${pageContext.request.contextPath}/allEmp">Сотрудники</a>
    </c:when>
    <c:when test="${active==3}">
              <a href="${pageContext.request.contextPath}/">Главная</a>
              <a href="${pageContext.request.contextPath}/allDep">Отделы</a>
              <a class="active" href="${pageContext.request.contextPath}/allPos">Должности</a>
              <a href="${pageContext.request.contextPath}/allEmp">Сотрудники</a>
    </c:when>
    <c:when test="${active==4}">
              <a href="${pageContext.request.contextPath}/">Главная</a>
              <a href="${pageContext.request.contextPath}/allDep">Отделы</a>
              <a href="${pageContext.request.contextPath}/allPos">Должности</a>
              <a class="active" href="${pageContext.request.contextPath}/allEmp">Сотрудники</a>
    </c:when>
    <c:otherwise>
              <a href="${pageContext.request.contextPath}/">Главная</a>
              <a href="${pageContext.request.contextPath}/allDep">Отделы</a>
              <a href="${pageContext.request.contextPath}/allPos">Должности</a>
              <a href="${pageContext.request.contextPath}/allEmp">Сотрудники</a>
    </c:otherwise>
</c:choose>


</div>


</td></tr>
</table>
</body>
</html>


