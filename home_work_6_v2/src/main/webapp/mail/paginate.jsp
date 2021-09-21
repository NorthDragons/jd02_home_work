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
<c:when test="${page < 5}">
  <a href="${window.location.href}?page=1">&laquo;</a>
  <a <c:if test="${page==1}">class="active"</c:if> href="${window.location.href}?page=1">1</a>
  <a <c:if test="${page==2}">class="active"</c:if> href="${window.location.href}?page=2">2</a>
  <a <c:if test="${page==3}">class="active"</c:if> href="${window.location.href}?page=3">3</a>
  <a <c:if test="${page==4}">class="active"</c:if> href="${window.location.href}?page=4">4</a>
  <a href="${window.location.href}?page=5">5</a>
  <a href="${window.location.href}?page=6">6</a>
  <a href="${window.location.href}?page=7">7</a>
  <a href="${window.location.href}?page=${maxPage}">&raquo;</a>
</c:when>

<c:when test="${page > maxPage-3}">
  <a href="${window.location.href}?page=1">&laquo;</a>
  <a href="${window.location.href}?page=${page-3}">$${maxPage-6}</a>
  <a href="${window.location.href}?page=${page-2}">$${maxPage-5}</a>
  <a href="${window.location.href}?page=${page-1}">$${maxPage-4}</a>
  <a href="${window.location.href}?page=${maxPage-3}">${maxPage-3}</a>
  <a <c:if test="${page==maxPage-2}">class="active"</c:if> href="${window.location.href}?page=${maxPage-2}">${maxPage-2}</a>
  <a <c:if test="${page==maxPage-1}">class="active"</c:if> href="${window.location.href}?page=${maxPage-1}">${maxPage-1}</a>
  <a <c:if test="${page==maxPage}">class="active"</c:if> href="${window.location.href}?page=${maxPage}">${maxPage}</a>
  <a href="${window.location.href}?page=${maxPage}">&raquo;</a>
</c:when>

<c:when test="${page > 4}">
  <a href="${window.location.href}?page=1">&laquo;</a>
  <a href="${window.location.href}?page=${page-3}">${page-3}</a>
  <a href="${window.location.href}?page=${page-2}">${page-2}</a>
  <a href="${window.location.href}?page=${page-1}">${page-1}</a>
  <a class="active" href="${window.location.href}?page=${page}">${page}</a>
  <a href="${window.location.href}?page=${page+1}">${page+1}</a>
  <a href="${window.location.href}?page=${page+2}">${page+2}</a>
  <a href="${window.location.href}?page=${page+3}">${page+3}</a>
  <a href="${window.location.href}?page=${maxPage}">&raquo;</a>
</c:when>



</c:choose>

</div>
</td>
</table>

</body>
</html>
