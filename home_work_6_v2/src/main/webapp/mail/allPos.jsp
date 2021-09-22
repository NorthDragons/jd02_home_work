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
<title>Positions</title>
<style>
         <%@include file="/css/buttonStyle.css" %>
   }
  </style>
</head>
<body> <jsp:include page="topMenu.jsp" />

<body>
<table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
     <tr> <td>
        <table border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
                <form align="center">
                    <caption><h2>Должности</h2></caption>
                    <c:forEach items="${requestScope.positions}"
                                   			var="pos">
                                       <tr>
                                           <td>${pos.id}</td>
                                           <td>${pos.name}</td>
                                           <td><a href="${pageContext.request.contextPath}/position?id=${pos.id}" class="btn">
                                           Карточка Должности</a>
                                           </td>
                                       </tr>
                    </c:forEach>
                </form>
        </table>
     </td></tr>
</table>
</body>

<body> <jsp:include page="pagin/paginate.jsp" />

</html>