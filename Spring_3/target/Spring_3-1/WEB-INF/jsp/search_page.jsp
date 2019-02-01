<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form method="POST" action="${pageContext.request.contextPath}/filter">
    <input type="text" name="Name" id="Name" placeholder="Имя">
    <input type="text" name="Surname" id="Surname" placeholder="Фамилия">
    <input type="text" name="Patronymic" id="Patronymic" placeholder="Отчество">
    <input type="text" name="Address" id="Address" placeholder="Адрес дома">
    <button type="submit">Фильтровать</button>
<table border="1" width=600px>
    <tr>
        <th width=100px>Имя</th>
        <th width=100px>Фамилия</th>
        <th width=100px>Отчество</th>
        <th width=100px>Имущество</th>
    </tr>
    <c:forEach var="person_T" items="${personList}">
        <tr>
            <td><c:out value="${person_T.name}"/></td>
            <td><c:out value="${person_T.surname}"/></td>
            <td><c:out value="${person_T.patronymic}"/></td>
            <td><c:forEach  var="house" items="${person_T.houses}">
                <option value=${house.houseid}>${house.address}</option>
            </c:forEach></td>
        </tr>
    </c:forEach>
</table>

</form>
<form method="GET" action="${pageContext.request.contextPath}/">
    <button type="submit">На главную</button>
</form>

</body>

</html>
