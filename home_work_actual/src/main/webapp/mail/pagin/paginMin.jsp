<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <a href="${window.location.href}?page=1&all=true">&laquo;</a>
              <c:if test="${maxPage>=1}">  <a <c:if test="${page==1}">class="active"</c:if> href="${window.location.href}?page=1&all=true">1</a></c:if>
              <c:if test="${maxPage>=2}">  <a <c:if test="${page==2}">class="active"</c:if> href="${window.location.href}?page=2&all=true">2</a></c:if>
              <c:if test="${maxPage>=3}">  <a <c:if test="${page==3}">class="active"</c:if> href="${window.location.href}?page=3&all=true">3</a></c:if>
              <c:if test="${maxPage>=4}">  <a <c:if test="${page==4}">class="active"</c:if> href="${window.location.href}?page=4&all=true">4</a></c:if>
              <c:if test="${maxPage>=5}">  <a <c:if test="${page==5}">class="active"</c:if> href="${window.location.href}?page=5&all=true">5</a></c:if>
              <c:if test="${maxPage>=6}">  <a <c:if test="${page==6}">class="active"</c:if> href="${window.location.href}?page=6&all=true">6</a></c:if>
              <c:if test="${maxPage>=7}">  <a <c:if test="${page==7}">class="active"</c:if> href="${window.location.href}?page=7&all=true">7</a></c:if>
  <a href="${window.location.href}?page=${maxPage}&all=true">&raquo;</a>