<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="ru">
<head>
<script src="jquery.js"></script>
    <script>
    $(function(){
      $("#includedContent").load("test.html");
    });
    </script>

<meta charset="utf-8" />
<title>Hello</title>

<style>
      <%@include file="/css/buttonStyle.css" %>

</style>

</head>
<body> <jsp:include page="topMenuDrop.jsp" />

<table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
     <tr> <td>
        <table border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
                <form align="center">
<tr>
    <td width="250"><h2>Информация по Отделам </h2></td>
    <td width="250"><h2>Информация по Должностям </h2></td>
    <td width="250"><h2>Информация по Сотрудникам </h2></td>
   </tr>
                </form>
            </td></tr>
        </table>
     </td></tr>
</table>
</body>
</html>