<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Управление домами</title>
</head>
<body>
<div class="house_managing">

    <form method="post" action="link_complete">
        <p>
        <h2>Имущество</h2>
    <select name="selected_house_id">
        <c:forEach  var="house" items="${houseList}">
            <option value=${house.houseid}>${house.address}</option>
        </c:forEach>
    </select>
        </p>
        <p>
        <h2>Человек</h2>
    <select name="selected_person_id">
        <c:forEach  var="person" items="${personList}">
            <option value=${person.personid}>${person.name} ${person.surname} ${person.patronymic}</option>
        </c:forEach>
    </select>
        </p>
        <button type="submit">Связать</button>
    </form>
</div>

</body>
</html>
