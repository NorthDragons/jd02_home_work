<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


  <a href="${window.location.href}?page=1&all=true">&laquo;</a>
  <a href="${window.location.href}?page=${page-3}&all=true">${page-3}</a>
  <a href="${window.location.href}?page=${page-2}&all=true">${page-2}</a>
  <a href="${window.location.href}?page=${page-1}&all=true">${page-1}</a>
  <a class="active" href="${window.location.href}?page=${page}&all=true">${page}</a>
  <a href="${window.location.href}?page=${page+1}&all=true">${page+1}</a>
  <a href="${window.location.href}?page=${page+2}&all=true">${page+2}</a>
  <a href="${window.location.href}?page=${page+3}&all=true">${page+3}</a>
  <a href="${window.location.href}?page=${maxPage}&all=true">&raquo;</a>