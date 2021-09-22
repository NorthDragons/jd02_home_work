<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<style>
   <%@include file="/css/paginate.css" %>
</style>
</head>
<body>
<table align="center">
<td>
<div class="pagination">

<c:choose>
<c:when test="${maxPage < 8}">
<body> <jsp:include page="paginMin.jsp" />
</c:when>
<c:when test="${maxPage > 7}">
<c:if test="${page < 5}"><body> <jsp:include page="paginDefault.jsp" /></c:if>
<c:if test="${page > maxPage-3}"> <body> <jsp:include page="paginMax.jsp" /></c:if>
<c:if test="${page > 4 && page < maxPage-2}"><body> <jsp:include page="paginMid.jsp" /></c:if>
</c:when>
</c:choose>
</div>
</td>
</table>
</body>
</html>
