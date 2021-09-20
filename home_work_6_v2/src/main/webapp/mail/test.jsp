<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
     <tr> <td>

<div class="topnav">
  <a class="active" href="${pageContext.request.contextPath}/">Главная</a>
  <a href="${pageContext.request.contextPath}/allDep">Отделы</a>
  <a href="${pageContext.request.contextPath}/allPos">Должности</a>
  <a href="${pageContext.request.contextPath}/allEmp">Сотрудники</a>
</div>


</td></tr>
</table>
</body>
</html>


