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
<body>
        <c:if test="${employee_mode}"><form action="${pageContext.request.contextPath}/employeeActual" method="GET"></c:if>
        <c:if test="${department_mode}"><form action="${pageContext.request.contextPath}/departmentActual" method="GET"></c:if>
        <c:if test="${position_mode}"><form action="${pageContext.request.contextPath}/positionActual" method="GET"></c:if>
         <tr align="center"><td>
           ID :<br>
           <input type="text" name="id"><br>
           <input type="hidden" name="get_mode" value="one"><br>
           </td></tr>
<tr align="center"><td><br>
<input type="submit" value=${title} style="width:50%"><br><br>
</td></tr>

        </form>
                </table>
             </td></tr>
        </table>

</body>