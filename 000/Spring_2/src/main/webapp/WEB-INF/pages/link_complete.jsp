<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ура!</title>
</head>
<body>
<div class="link_complete_page">
    <form action="/">
       <h3> ${selected_person.name} и дом ${selected_house.address} были связаны! </h3>
            <p>
        <button type="submit">Вернуться на главную страницу</button>
            </p>
    </form>
</div>

</body>
</html>
