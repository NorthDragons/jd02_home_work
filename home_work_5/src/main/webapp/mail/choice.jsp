<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <table border="1" align="center" rules="rows" style="width:60%;">
    <body bgcolor="">
    <tr> <td>
    <table border="1" background="img/1.jpg" bgcolor="" cellpadding="10" style="width:100%; border-radius:5px;">
    <caption style="background-color: #ECE5B6;" width="50%"><h1>Приветствую путник, если ты желаешь открыть для себя мир общения, выбери действие:</h1></caption>
    <tr><th>
    <button width="50%"
     onclick="window.location.href = '${pageContext.request.contextPath}/login';">Войти</button> </br></br>

    <button width="50%"
     onclick="window.location.href = '${pageContext.request.contextPath}/reg';">Зарегистрироваться</button>
    </th></tr>
    </td></tr>
    </table>
    </body>
