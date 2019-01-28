<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление людей в базу</title>
</head>
<body>
<div class="new_person">
    <h3>Добавление людей! </h3>

    <form action="${pageContext.request.contextPath}/persons_Showing" method="POST">
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
</div>
</body>
</html>

<style>
    .reg {
        padding-left: 10px;
        width: 220px;
        height: 250px;
        border: solid 1px black;
        float: left;
        position: relative;
    }
</style>