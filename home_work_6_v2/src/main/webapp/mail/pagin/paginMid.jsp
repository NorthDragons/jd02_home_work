<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


  <a href="${window.location.href}?page=1&mode=1">&laquo;</a>
  <a href="${window.location.href}?page=${page-3}&mode=1">${page-3}</a>
  <a href="${window.location.href}?page=${page-2}&mode=1">${page-2}</a>
  <a href="${window.location.href}?page=${page-1}&mode=1">${page-1}</a>
  <a class="active" href="${window.location.href}?page=${page}&mode=1">${page}</a>
  <a href="${window.location.href}?page=${page+1}&mode=1">${page+1}</a>
  <a href="${window.location.href}?page=${page+2}&mode=1">${page+2}</a>
  <a href="${window.location.href}?page=${page+3}&mode=1">${page+3}</a>
  <a href="${window.location.href}?page=${maxPage}&mode=1">&raquo;</a>