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
	                <li><a href="${pageContext.request.contextPath}/allDep?page=1">Все отделы</a></li>
	                <li><a href="#">Карточка отдела</a></li>
	                <li><a href="#">Добавить отдел</a></li>
	                <li><a href="#">Редактировать отдел</a></li>
	            </ul>
        </li>
	    <li>
	        <a href="#">Должности</a>
              	<ul>
	                <li><a href="${pageContext.request.contextPath}/allPos?page=1">Все должности</a></li>
	                <li><a href="#">Карточка должности</a></li>
	                <li><a href="#">Добавить должность</a></li>
	                <li><a href="#">Редактировать должность</a></li>
	            </ul>
        </li>
		<li>
		    <a href="#">Сотрудники</a>
                <ul>
			         <li><a href="${pageContext.request.contextPath}/allEmp?page=1">Все сотрудники</a></li>
			         <li><a href="#">Карточка сотрудника</a></li>
			         <li><a href="#">Добавить</a>
			            <ul>
			                <li><a href="#">Добавить одного сотрудника</a></li>
			                <li><a href="#">Добавить несколько сотрудников</a></li>
			                <li><a href="#">Сгенерировать сотрудников</a></li>
			            </ul>
			         </li>
			         <li><a href="#">Редактировать сотрудника</a></li>
			    </ul>
        </li>
	</ul>
</nav>
</div>
</td></tr>
</table>
</body>
</html>


