<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Hello page.</title>
    <meta name="description" content="Hello.">
</head>

<body>
    <form method="post" action="${pageContext.request.contextPath}/house_builder">
        <button type="submit">Добавить дом</button>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/person_builder">
        <button type="submit">Добавить человека</button>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/link_manager">
        <button type="submit">К управлению домами</button>
    </form>
    <form method="get" action="${pageContext.request.contextPath}/persons">
        <button type="submit">Получить JSONы всех людей</button>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/search_page">
        <button type="submit">Поиск</button>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/person_possessions">
        <select name="selected_person_id">
            <c:forEach  var="person" items="${personList}">
                <option value=${person.personid}>${person.name} ${person.surname} ${person.patronymic}</option>
            </c:forEach>
        </select>
        <button type="submit">Просмотреть владения</button>
    </form>
</body>
</html>
