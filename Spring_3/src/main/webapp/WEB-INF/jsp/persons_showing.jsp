<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Привет</title>
</head>
<body>
<c:out value='Привет ${reestr.name} ${reestr.surname} ${reestr.patronymic}! Теперь ты тоже в базе.'/>

<table border="1" width=300px>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
    </tr>
    <c:forEach var="person_T" items="${reestrList}">
        <tr>
            <td><c:out value="${person_T.name}"/></td>
            <td><c:out value="${person_T.surname}"/></td>
            <td><c:out value="${person_T.patronymic}"/></td>
        </tr>
    </c:forEach>
</table>
<form method="GET" action="${pageContext.request.contextPath}/">
    <button type="submit">На главную</button>
</form>
</body>

</html>