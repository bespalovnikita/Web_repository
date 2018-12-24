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
    <div class="new_person">
        <div class="hello_text">
        Привет!
        </div>
        <form action="end" method="POST">
            <div class="reg">
                <p>
                    <label for="Name">Имя :</label>
                    <br>
                    <input type="text" name="Name" id="Name">
                </p>
                <p>
                    <label for="Surname">Фамилия :</label>
                    <br>
                    <input type="text" name="Surname" id="Surname">
                </p>
                <p>
                    <label for="Patronymic">Отчество :</label>
                    <br>
                    <input type="text" name="Patronymic" id="Patronymic">
                </p>
                <button type="submit">Отправить в БД и просмотреть</button>
                <button type="reset" name="clear">Очистить форму</button>
            </div>
        </form>
        <form method="post" action="houseBuilder">
            <button type="submit">Добавить дом</button>
        </form>
        <form method="post" action="houseManager">
            <button type="submit">К управлению домами</button>
        </form>
        <form method="post" action="/persons">
            <button type="submit">Получить JSONы всех людей</button>
        </form>

        <form method="post" action="possessions">
            <select name="selected_person_id">
                <c:forEach  var="person" items="${personList}">
                    <option value=${person.personid}>${person.name} ${person.surname} ${person.patronymic}</option>
                </c:forEach>
            </select>
            <button type="submit">Просмотреть владения</button>
        </form>

    </div>


    </div>

</body>
</html>

<style>

    .content {
        margin: 10px 10px;
    }

    .reg {
        padding-left: 10px;
        width: 220px;
        height: 250px;
        border: solid 1px black;
        float: left;
        position: relative;
    }

    .hello_text {
        font-family: 'Lato', sans-serif;
        font-size: 65px;
        color: maroon;
    }

</style>