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
                    <tr><h2 align="center">Отдел</h2></tr>

                                       <tr>
                                           <td>${department.id}</td><br>
                                           <td>${department.name}</td><br>
                                           <td>${parentDep.name}</td><br>
                                       </tr>

                </form>
        </table>
     </td></tr>
</table>
</body>