<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
  <meta charset="utf-8">
  <title>Новое Сообщение</title>
 </head>

 <table border="1" align="center" rules="rows" style="width:60%;">
     <body bgcolor="">
     <tr> <td>
     <table border="1" background="images/168.png" bgcolor="" cellpadding="10" style="width:100%; border-radius:5px;">
     <tr><th>
<form action="${pageContext.request.contextPath}/" method="POST">
  <p><b>Получатель:</b><br>
   <input type="text" size="40" name="user" required placeholder="Введите получателя">
  </p>

  <p>Сообщение<Br>
   <textarea name="comment" required placeholder="Введите получателя" cols="40" rows="3"></textarea></p>
  <p><input type="submit" value="Отправить">
   <input type="reset" value="Очистить"></p>
 </form>
 </th></tr>
 </table>
 </td></tr>
 </body>
 <table>
