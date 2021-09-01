<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <html lang="ru">

<head>
 <meta charset="utf-8" />
 <title>Главная</title>
</head>

<body background="img/cat.jpeg">

 <table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
 <tr> <td>

<table border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
<tr><td rowspan="2" style="width:80%">
<h2>Новое Сообщение</h2>

<form action="${pageContext.request.contextPath}/message" method="POST">
  <p><b>Получатель:</b><br>
   <input type="recipient" size="39" name="user" required placeholder="Введите получателя"></p>
  <p><b>Сообщение:</b><Br>
   <textarea name="message" required placeholder="Введите получателя" cols="41" rows="3"></textarea></p>
  <p><input type="submit" value="Отправить">
   <input type="reset" value="Очистить"></p>
 </form>

</td></tr>
</table>

</td></tr>
</table>
</body>