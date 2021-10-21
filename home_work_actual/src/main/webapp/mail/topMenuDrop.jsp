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
   <%@include file="/css/topMenuDrop.css" %>
</style>
</style>
</head>

<body>
<table valign="top" background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%; top:-9;">
     <tr> <td>
<nav>
	<ul>
	    <li><a href="${pageContext.request.contextPath}/">Главная</a></li>
	    <li>
	        <a href="#">Отделы</a>
                <ul>
	                <li><a href="${pageContext.request.contextPath}/departmentActual?page=1&get_mode=all">Все отделы</a></li>
	                <li><a href="${pageContext.request.contextPath}/departmentActual?get_mode=one">Карточка отдела</a></li>
	                <li><a href="${pageContext.request.contextPath}/departmentActual?get_mode=add">Добавить отдел</a></li>
	                <li><a href="${pageContext.request.contextPath}/departmentActual?get_mode=update">Редактировать отдел</a></li>
	            </ul>
        </li>
	    <li>
	        <a href="#">Должности</a>
              	<ul>
	                <li><a href="${pageContext.request.contextPath}/positionActual?page=1&get_mode=all">Все должности</a></li>
	                <li><a href="${pageContext.request.contextPath}/positionActual?get_mode=one">Карточка должности</a></li>
	                <li><a href="${pageContext.request.contextPath}/positionActual?get_mode=add">Добавить должность</a></li>
	                <li><a href="${pageContext.request.contextPath}/positionActual?get_mode=update">Редактировать должность</a></li>
	            </ul>
        </li>
		<li>
		    <a href="#">Сотрудники</a>
                <ul>
			         <li><a href="${pageContext.request.contextPath}/employeeActual?page=1&get_mode=all">Все сотрудники</a></li>
			         <li><a href="${pageContext.request.contextPath}/employeeActual?get_mode=one">Карточка сотрудника</a></li>
			         <li><a href="${pageContext.request.contextPath}/employeeActual?get_mode=add">Добавить сотрудника</a></li>
			         <li><a href="${pageContext.request.contextPath}/employeeActual?get_mode=update">Редактировать сотрудника</a></li>
			    </ul>
        </li>
	</ul>
</nav>
</div>
</td></tr>
</table>
</body>
</html>


