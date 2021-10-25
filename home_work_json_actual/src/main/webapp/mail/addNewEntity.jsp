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
<title>${title}</title>
</head>
<body> <jsp:include page="topMenuDrop.jsp" />
    <table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
         <tr> <td>
         <table bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
     <h2 align="center">${title}</h2>

    <c:choose>
        <c:when test="${department_mode}">
            <jsp:include page="department/addNewDep.jsp"/>
        </c:when>

        <c:when test="${employee_mode}">
            <jsp:include page="employee/addNewEmp.jsp"/>
        </c:when>

        <c:when test="${position_mode}">
            <jsp:include page="position/addNewPos.jsp"/>
        </c:when>

    </c:choose>
    </table>
         </td></tr>
    </table>
</body>

