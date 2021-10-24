<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


  <a href="${window.location.href}?page=1&get_mode=all">&laquo;</a>
  <a <c:if test="${page==1}">class="active"</c:if> href="${window.location.href}?page=1&get_mode=all">1</a>
  <a <c:if test="${page==2}">class="active"</c:if> href="${window.location.href}?page=2&get_mode=all">2</a>
  <a <c:if test="${page==3}">class="active"</c:if> href="${window.location.href}?page=3&get_mode=all">3</a>
  <a <c:if test="${page==4}">class="active"</c:if> href="${window.location.href}?page=4&get_mode=all">4</a>
  <a href="${window.location.href}?page=5&&get_mode=all">5</a>
  <a href="${window.location.href}?page=6&&get_mode=all">6</a>
  <a href="${window.location.href}?page=7&&get_mode=all">7</a>
  <a href="${window.location.href}?page=${maxPage}&get_mode=all">&raquo;</a>
