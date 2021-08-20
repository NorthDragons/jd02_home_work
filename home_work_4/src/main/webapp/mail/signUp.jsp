<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, ">
<title>Квиз</title>
</head>
<body>
<form action="/home_work_4-1.0-SNAPSHOT/registration" method="POST">

<table style="background-color: #ECE5B6;" width="30%" >
<caption style="background-color: #ECE5B6;" width="50%"><b>Регистрация</b></caption>
      <tr><th width="50%">Login</TH>
	  	  <td width="50%"><input type="text" name="login"></TD>
	  </tr>
      <tr>
	     <th width="50%">Password</TH>
	  	 <td width="50%"><input type="text" name="password" required></TD>
	  </tr>
	  <tr>
           	     <th width="50%">Имя</TH>
           		 <td width="50%"><input type="text" name="firstName"></TD>
      </tr>
	  <tr>
           	     <th width="50%">Фамилия</TH>
           		 <td width="50%"><input type="text" name="lastName"></TD>
      </tr>
     <tr>
       	     <th width="50%">Отчество</TH>
       		 <td width="50%"><input type="text" name="middleName"></TD>
     </tr>
     <tr>
            	     <th width="50%">День рождения</TH>
            		 <td width="50%"><input type="text" name="birthday"></TD>
          </tr>
  	 <tr>
  	 <th></th>
		  <td width="50%"><input type="submit" value="submit"></TD>
	 </tr>
</table>
</form>
</br>
<p>Уже зарегистрированы?</p>
            <button
            onclick="window.location.href = 'http://localhost:8080/home_work_4-1.0-SNAPSHOT/login';">Войти</button>
