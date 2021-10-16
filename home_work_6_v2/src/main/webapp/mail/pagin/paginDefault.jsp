<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


  <a href="${window.location.href}?page=1&all=true">&laquo;</a>
  <a <c:if test="${page==1}">class="active"</c:if> href="${window.location.href}?page=1&all=true">1</a>
  <a <c:if test="${page==2}">class="active"</c:if> href="${window.location.href}?page=2&all=true">2</a>
  <a <c:if test="${page==3}">class="active"</c:if> href="${window.location.href}?page=3&all=true">3</a>
  <a <c:if test="${page==4}">class="active"</c:if> href="${window.location.href}?page=4&all=true">4</a>
  <a href="${window.location.href}?page=5&&all=true">5</a>
  <a href="${window.location.href}?page=6&&all=true">6</a>
  <a href="${window.location.href}?page=7&&all=true">7</a>
  <a href="${window.location.href}?page=${maxPage}&all=true">&raquo;</a>