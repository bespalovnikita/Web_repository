<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Привет</title>
</head>
<body>
<c:out value='${customer.address} ${customer.housetype} теперь тоже в базе.'/>

<table border="1" width=300px>
    <tr>
        <th>Адрес</th>
        <th>Тип</th>
    </tr>
    <c:forEach var="house_T" items="${houseList}">
        <tr>
            <td><c:out value="${house_T.address}"/></td>
            <td><c:out value="${house_T.housetype}"/></td>
        </tr>
    </c:forEach>
</table>
<form method="GET" action="${pageContext.request.contextPath}/">
    <button type="submit">На главную</button>
</form>
</body>

</html>