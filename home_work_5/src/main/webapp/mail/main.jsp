<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <html lang="ru">

<head>
 <meta charset="utf-8" />
 <title>Главная</title>
</head>

<body background="img/cat.jpeg">
 <table border="1" align="center" rules="rows" style="width:60%;">
 <tr> <td>

 <table background="img/1.jpg" background="img/1.jpeg" border="1" bgcolor="" height="35" cellpadding="10" style="width:100%; border-radius:5px;">
 <tr><th>
 <p align="left">${login}</p>
 <p align="right"><input type="button" onclick="location.href='${pageContext.request.contextPath}/logout';" value="Выйти" /></p>
 <h3></h3>
 </th></tr>
 </table>

<table border="1" background="img/1.jpg" bgcolor="" cellpadding="10" style="width:100%; border-radius:5px;">
<tr><th>
<h1>Добро пожаловать в ангарейон</h1>
<h3>Здесь вы можете общаться с вашими друзьями и недругами где бы они не находились</h3>
</th></tr>
</table>
<table background="img/1.jpg" border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
<tr><td rowspan="2" style="width:80%">
 <c:when test="${sessionScope.user != null}">
        <p>Вы уже вошли, может хотите выйти?</p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/logout';" value="Выйти" /></p>
    </c:when>
<h2>Выберите действие</h2>
<p><a href="${pageContext.request.contextPath}/user"><span style="margin-left:5px;">Личный кабинет</span></a></p>
<p><a href="${pageContext.request.contextPath}/message"><span style="margin-left:5px;">Написать сообщение</span></a></p>
<p><a href="${pageContext.request.contextPath}/chat"><span style="margin-left:5px;">Мои сообщения</span></a></p>

</td></tr>
</table >

</td></tr>
</table>
</body>
</html>