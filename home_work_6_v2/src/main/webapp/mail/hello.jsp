<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="ru">
<head>
<script src="jquery.js"></script>
    <script>
    $(function(){
      $("#includedContent").load("test.html");
    });
    </script>

<meta charset="utf-8" />
<title>Hello</title>

<style>
   .btn {
    display: inline-block; /* Строчно-блочный элемент */
    width: 200px;
    background: #8C959D; /* Серый цвет фона */
    color: #fff; /* Белый цвет текста */
    padding: 1rem 1.5rem; /* Поля вокруг текста */
    text-decoration: none; /* Убираем подчёркивание */
    border-radius: 3px; /* Скругляем уголки */
   }
  </style>

</head>
<body> <jsp:include page="test.jsp" />

<table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
     <tr> <td>
        <table border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
                <form align="center">
<tr>
    <td width="250">Колонка 1</td>
    <td width="250">Колонка 2</td>
    <td width="250">Колонка 3</td>
   </tr>
                </form>
            </td></tr>
        </table>
     </td></tr>
</table>
</body>
</html>