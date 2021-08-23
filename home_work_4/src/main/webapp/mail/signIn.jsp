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

<table style="background-color: #ECE5B6;" width="30%" >
<caption style="background-color: #ECE5B6;" width="50%"><b>Авторизация</b></caption>

      <tr>
	      <th width="50%">Login</TH>
	  	  <td width="50%"><input type="text" name="login" required placeholder="Введите логин"></TD>
	  </tr>
      <tr>
	     <th width="50%">Password</TH>
	  	 <td width="50%"><input type="text" name="password" required placeholder="Введите пароль"></TD>
	  </tr>
	  <tr>
        	 <th></th>
      		  <td width="50%"><input type="submit" value="Войти" ></TD>
      </tr>

</table>
</form>
<p>Не прошли регистрацию?</p>
            <button
            onclick="window.location.href = '${pageContext.request.contextPath}/reg';">Зарегистрироваться</button>
</br>
