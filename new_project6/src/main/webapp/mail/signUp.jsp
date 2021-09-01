<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, ">
<title>Квиз</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/save" method="POST">

<table border="1" align="center" rules="rows" style="width:60%;">
 <tr> <td>

<table border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
<caption style="background-color: #ECE5B6;" width="50%"><b>Регистрация</b></caption>
      <tr><th width="50%">Login</TH>
	  	  <td width="50%"><input type="text" name="login" required placeholder="Введите логин"></TD>
	  </tr>
      <tr>
	     <th width="50%">Password</TH>
	  	 <td width="50%"><input type="text" name="password" required placeholder="Введите пароль"</TD>
	  </tr>
	  <tr>
           	     <th width="50%">Имя</TH>
           		 <td width="50%"><input type="text" name="firstName" required placeholder="Введите имя"></TD>
      </tr>
	  <tr>
           	     <th width="50%">Фамилия</TH>
           		 <td width="50%"><input type="text" name="lastName" required placeholder="Введите фвмилию"></TD>
      </tr>
     <tr>
       	     <th width="50%">Отчество</TH>
       		 <td width="50%"><input type="text" name="middleName" required placeholder="Введите отчество"></TD>
     </tr>
     <tr>
            	     <th width="50%">День рождения</TH>
            		 <td width="50%"><input type="text" name="birthday" required placeholder="Введите Дату"></TD>
          </tr>
</table>
</td></tr>
</table>

<table align="center" rules="rows" style="width:60%;">
 <tr> <td>
 <input type="submit" value="Зарегистрироваться" style="width:100%">

<p align="center">Уже зарегистрированы?</p>
 <button  rules="rows" style="width:100%;"
            onclick="window.location.href = '${pageContext.request.contextPath}/login';">Войти</button>
</td></tr>
</table>

</form>
</br>


