<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<body>
<table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
     <tr> <td>
        <table bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">

<form action="${pageContext.request.contextPath}/employee" method="POST">

 <h2 align="center">Введите данные </h2>
  <tr align="center">
  <td>
  Имя:<br>
  <input type="text" name="name"><br>
  </td>
  </tr>
  <tr align="center">
  <td>
  Зарплата:<br>
  <input type="text" name="salary">
</td>
</tr>

<tr align="center">
  <td>
  ID Отдела:<br>
  <input type="text" name="depId">
</td>
</tr>

<tr align="center">
  <td>
  ID Должности:<br>
  <input type="text" name="posId">
</td>
</tr>

<tr align="center"><td>
<br>
<input type="submit" value="Добавить сотрудника" style="width:50%"><br><br>
</td></tr>

</form>
        </table>
     </td></tr>
</table>
</body>