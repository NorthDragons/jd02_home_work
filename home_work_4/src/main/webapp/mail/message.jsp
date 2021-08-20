<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
  <meta charset="utf-8">
  <title>Тег INPUT</title>
 </head>
 <body>

 <form name="test" method="post" action="input1.php">
  <p><b>Получатель:</b><br>
   <input type="text" size="40" name="user" required placeholder="Введите получателя">
  </p>

  <p>Сообщение<Br>
   <textarea name="comment" required placeholder="Введите получателя" cols="40" rows="3"></textarea></p>
  <p><input type="submit" value="Отправить">
   <input type="reset" value="Очистить"></p>
 </form>