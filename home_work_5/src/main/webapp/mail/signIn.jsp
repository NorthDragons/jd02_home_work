<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, ">
<title>Квиз</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="POST">

<table border="1" align="center" rules="rows" style="width:60%;">
 <tr> <td>

<table border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
<caption style="background-color: #ECE5B6;" width="50%"><b>Авторизация</b></caption>

      <tr>
	      <th width="50%">Login</TH>
	  	  <td width="50%"><input type="text" name="login" required placeholder="Введите логин"></TD>
	  </tr>
      <tr>
	     <th width="50%">Password</TH>
	  	 <td width="50%"><input type="text" name="password" required placeholder="Введите пароль"></TD>
	  </tr>

</table>
</td></tr>
</table>

<table align="center" rules="rows" style="width:60%;">
 <tr> <td>
 <input type="submit" value="Войти" style="width:100%">

<p align="center">Нет аккаунта?</p>
 <button  rules="rows" style="width:100%;"
            onclick="window.location.href = '${pageContext.request.contextPath}/reg';">Зарегистрироваться</button>
</td></tr>
</table>

</form>

</br>
