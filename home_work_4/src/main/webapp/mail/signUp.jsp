<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<table style="background-color: #ECE5B6;" width="30%" >
<caption style="background-color: #ECE5B6;" width="50%"><b>Регистрация</b></caption>
      <tr><th width="50%">Login</TH>
	  	  <td width="50%"><input type="text" name="login"></TD>
	  </tr>
      <tr>
	     <th width="50%">Password</TH>
	  	 <td width="50%"><input type="text" name="password"></TD>
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
       		 <td width="50%"><input type="text" name="MiddleName"></TD>
     </tr>
  	 <tr>
  	 <th></th>
		  <td width="50%"><input type="submit" value="submit"></TD>
	 </tr>
</table>
</br>
<p>Уже зарегистрированы?</p>
            <button
            onclick="window.location.href = 'http://localhost:8080/home_work_4-1.0-SNAPSHOT/login';">Войти</button>
