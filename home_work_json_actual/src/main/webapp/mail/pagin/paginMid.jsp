<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


  <a href="${window.location.href}?page=1&get_mode=all">&laquo;</a>
  <a href="${window.location.href}?page=${page-3}&get_mode=all">${page-3}</a>
  <a href="${window.location.href}?page=${page-2}&get_mode=all">${page-2}</a>
  <a href="${window.location.href}?page=${page-1}&get_mode=all">${page-1}</a>
  <a class="active" href="${window.location.href}?page=${page}&get_mode=all">${page}</a>
  <a href="${window.location.href}?page=${page+1}&get_mode=all">${page+1}</a>
  <a href="${window.location.href}?page=${page+2}&get_mode=all">${page+2}</a>
  <a href="${window.location.href}?page=${page+3}&get_mode=all">${page+3}</a>
  <a href="${window.location.href}?page=${maxPage}&get_mode=all">&raquo;</a>
  <a href="${window.location.href}?page=1&get_mode=all"></a>
