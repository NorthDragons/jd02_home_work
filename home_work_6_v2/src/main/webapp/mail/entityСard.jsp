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
<title>Position</title>
</head>
<body><jsp:include page="topMenuDrop.jsp" />
<body>
<c:choose>
        <c:when test="${department_mode}">
        <jsp:include page="resources/dep.jsp" />
        </c:when>
        <c:when test="${employee_mode}">
        <jsp:include page="resources/emp.jsp" />
        </c:when>
        <c:when test="${position_mode}">
        <jsp:include page="resources/pos.jsp" />
        </c:when>
</c:choose>
</body>
</html>