<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<body>
<form action="${pageContext.request.contextPath}/positionActual?put_mode="${put_mode} method="POST">
<c:if test="${put_mode eq 'update'}"><tr align="center"><td>
  ID (обязательное поле):<br>
  <input type="text" name="id"><br>
  </td></tr></c:if>

  <tr align="center"><td>
  Наименование должности:<br>
  <input type="text" name="name"><br>
  </td></tr>

<tr align="center"><td><br>
<input type="submit" value="Добавить должность" style="width:50%"><br><br>
</td></tr>

</form>
        </table>
     </td></tr>
</table>
</body>