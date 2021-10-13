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
<title>Employee</title>
</head>
<body> <jsp:include page="../topMenuDrop.jsp" />
    <c:choose>
        <c:when test="${department}">
            <jsp:include page="../addNewDep.jsp"/>
        </c:when>

        <c:when test="${employee}">
            <jsp:include page="../addNewEmp.jsp"/>
        </c:when>

        <c:when test="${position}">
            <jsp:include page="../addNewPos.jsp"/>
        </c:when>

    </c:choose>
</body>

