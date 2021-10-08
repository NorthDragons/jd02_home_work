<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="utf-8" />
<title>Employee</title>
</head>
<body> <jsp:include page="../topMenuDrop.jsp" />

<body>
<table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
     <tr> <td>
        <table bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
<form action="${pageContext.request.contextPath}/findEmp" method="GET">


 <h2 align="center">Введите данные </h2>
  <tr align="center">
  <td>
  Имя сотрудника:<br>
  <input type="text" name="name"><br>
  </td></tr>

  <tr align="center"><td>
  Зарплата:<br>
  <input type="text" name="salary">
  <select>
    <option name="mode" value="more">Больше</option>
    <option name="mode" value="less">Меньше</option>
  </select>
</td></tr>


<tr align="center"><td><br>
<input type="submit" value="Искать" style="width:50%"><br><br>
</td></tr>

</form>

        </table>
     </td></tr>
</table>



</body>