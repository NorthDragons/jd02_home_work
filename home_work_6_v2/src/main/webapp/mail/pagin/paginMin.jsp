<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <a href="${window.location.href}?page=1">&laquo;</a>
              <c:if test="${maxPage>=1}">  <a <c:if test="${page==1}">class="active"</c:if> href="${window.location.href}?page=1">1</a></c:if>
              <c:if test="${maxPage>=2}">  <a <c:if test="${page==2}">class="active"</c:if> href="${window.location.href}?page=2">2</a></c:if>
              <c:if test="${maxPage>=3}">  <a <c:if test="${page==3}">class="active"</c:if> href="${window.location.href}?page=3">3</a></c:if>
              <c:if test="${maxPage>=4}">  <a <c:if test="${page==4}">class="active"</c:if> href="${window.location.href}?page=4">4</a></c:if>
              <c:if test="${maxPage>=5}">  <a <c:if test="${page==5}">class="active"</c:if> href="${window.location.href}?page=5">5</a></c:if>
              <c:if test="${maxPage>=6}">  <a <c:if test="${page==6}">class="active"</c:if> href="${window.location.href}?page=6">6</a></c:if>
              <c:if test="${maxPage>=7}">  <a <c:if test="${page==7}">class="active"</c:if> href="${window.location.href}?page=7">7</a></c:if>
  <a href="${window.location.href}?page=${maxPage}">&raquo;</a>