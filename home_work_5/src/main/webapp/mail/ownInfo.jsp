<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <html lang="ru">

<head>
 <meta charset="utf-8" />
 <title>Главная</title>
</head>

<body background="img/2.png">

     <table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
     <tr> <td>

    <table border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
    <tr><td rowspan="2" style="width:80%">
    <h2>Личный кабинет</h2>

    <p>Логин: ${login}</p>
    <p>Фамилия: ${lastName}</p>
    <p>Имя: ${firstName}</p>
    <p>Отчество: ${middleName}</p>
    <p>Дата рождения: ${birthday}</p>
    <p>Баланс: 0.0 р</p>

    </td></tr>
    </table>

    </td></tr>
    </table>
    </body>