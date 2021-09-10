<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, ">
<title>Квиз</title>
</head>

<body background="img/3.jpg">

     <table background="img/1.jpg" border="1" align="center" rules="rows" style="width:60%;">
     <tr> <td>

    <table border="1" bgcolor="" height="100" cellpadding="10" style="width:100%; border-radius:5px;">
    <tr><td rowspan="2" style="width:80%">
    <form align="center">
    <h2>Выбери раздел</h2>
	<button onclick="window.location.href = '${pageContext.request.contextPath}/login';">Отделы</button>
    <button onclick="window.location.href = '${pageContext.request.contextPath}/login';">Должности</button>
    <button onclick="window.location.href = '${pageContext.request.contextPath}/login';">Сотрудники</button>

</form>
    </td></tr>
    </table>

    </td></tr>
    </table>
    </body>