<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="utf-8" />
<title>Positions</title>
<style>
         <%@include file="/css/buttonStyle.css" %>
   }
  </style>
</head>
<body> <jsp:include page="topMenuDrop.jsp" />

<body>
    <c:choose>
        <c:when test="${department}">
        <jsp:include page="../allDep.jsp" />
        </c:when>

        <c:when test="${employee}">
        <jsp:include page="../allEmp.jsp" />
        </c:when>

        <c:when test="${position}">
        <jsp:include page="../allPos.jsp" />
        </c:when>





</body>

<body> <jsp:include page="pagin/paginate.jsp" />

</html>