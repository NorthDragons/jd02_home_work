<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



  <a href="${window.location.href}?page=1">&laquo;</a>
  <a href="${window.location.href}?page=${page-3}&mode=1">${maxPage-6}</a>
  <a href="${window.location.href}?page=${page-2}&mode=1">${maxPage-5}</a>
  <a href="${window.location.href}?page=${page-1}&mode=1">${maxPage-4}</a>
  <a href="${window.location.href}?page=${maxPage-3}&mode=1">${maxPage-3}</a>
  <a <c:if test="${page==maxPage-2}">class="active"</c:if> href="${window.location.href}?page=${maxPage-2}&mode=1">${maxPage-2}</a>
  <a <c:if test="${page==maxPage-1}">class="active"</c:if> href="${window.location.href}?page=${maxPage-1}&mode=1">${maxPage-1}</a>
  <a <c:if test="${page==maxPage}">class="active"</c:if> href="${window.location.href}?page=${maxPage}&mode=1">${maxPage}</a>
  <a href="${window.location.href}?page=${maxPage}">&raquo;</a>