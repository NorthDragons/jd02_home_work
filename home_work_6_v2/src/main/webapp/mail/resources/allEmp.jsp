<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<body>
<table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
     <tr> <td>
        <table border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
                <form align="center">
                    <caption><h2>Сотрудники</h2></caption>
                    <c:forEach items="${requestScope.allEmployers}"
                                   			var="employees">
                                       <tr>
                                           <td>${employees.id}</td>
                                           <td>${employees.name}</td>
                                           <td><a href="${pageContext.request.contextPath}/employeeActual?id=${employees.id}&get_mode=one" class="btn">
                                           Карточка сотрудника</a>
                                           </td>
                                       </tr>
                    </c:forEach>
                </form>
        </table>
     </td></tr>
</table>
</body>
