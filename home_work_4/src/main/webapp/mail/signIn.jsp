<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>

<style type="text/css">
<!--
.tab { margin-left: 40px; }
-->
</style>

</head>

<form action="">

<table style="background-color: #ECE5B6;" width="30%" >
<caption style="background-color: #ECE5B6;" width="50%"><b>Авторизация</b></caption>

      <tr>
	      <th width="50%">Login</TH>
	  	  <td width="50%"><input type="text" name="login"></TD>
	  </tr>
      <tr>
	     <th width="50%">Password</TH>
	  	 <td width="50%"><input type="text" name="password"></TD>
	  </tr>
	  <tr>
        	 <th></th>
      		  <td width="50%"><input type="submit" value="Войти" ></TD>
      </tr>

</table>
</form>
<p>Не прошли регистрацию?</p>
            <button
            onclick="window.location.href = 'http://localhost:8080/home_work_4-1.0-SNAPSHOT/mailreg';">Зарегистрироваться</button>
</br>
