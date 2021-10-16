<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



  <a href="${window.location.href}?page=1&all=true">&laquo;</a>
  <a href="${window.location.href}?page=${page-3}&all=true">${maxPage-6}</a>
  <a href="${window.location.href}?page=${page-2}&all=true">${maxPage-5}</a>
  <a href="${window.location.href}?page=${page-1}&all=true">${maxPage-4}</a>
  <a href="${window.location.href}?page=${maxPage-3}&all=true">${maxPage-3}</a>
  <a <c:if test="${page==maxPage-2}">class="active"</c:if> href="${window.location.href}?page=${maxPage-2}&all=true">${maxPage-2}</a>
  <a <c:if test="${page==maxPage-1}">class="active"</c:if> href="${window.location.href}?page=${maxPage-1}&all=true">${maxPage-1}</a>
  <a <c:if test="${page==maxPage}">class="active"</c:if> href="${window.location.href}?page=${maxPage}&all=true">${maxPage}</a>
  <a href="${window.location.href}?page=${maxPage}&all=true">&raquo;</a>