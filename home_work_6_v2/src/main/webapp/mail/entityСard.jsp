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
<title>Position</title>
</head>
<body> <jsp:include page="topMenuDrop.jsp" />

<body>
<table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
 <tr> <td>
   <table border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
    <form align="center">
        <caption><h2>${entity}</h2></caption>
            <c:choose>
                <c:when test="entity == Отдел">
                    <tr>
                       <td>${department.id}</td><br>
                       <td>${department.name}</td><br>
                       <td>${parentDep.name}</td><br>
                   </tr>
                </c:when>

                <c:when test="entity == Должность">
                <tr>
                    <td>${position.id}</td><br>
                    <td>${position.name}</td><br>
                </tr>
                </c:when>

                <c:when test="entity == 'Сотрудник'">
                <tr>
                    <td>${employee.id}</td><br>
                    <td>${employee.name}</td><br>
                    <td><p><fmt:formatNumber type = "number"
                                    maxFractionDigits = "3" value = "${employee.salary}" /></p></td><br>
                    <td>${position}</td><br>
                    <td>${department}</td><br>
                </tr>
                </c:when>

            </c:choose>


    </form>
    </table>
 </td></tr>
</table>



</body>