<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление домов в базу</title>
</head>
<body>
<div class="new_house">
    <h3>Добавление домов! </h3>

    <form action="${pageContext.request.contextPath}/house_showing" method="POST">
        <div class="reg">
            <p>
                <label for="address">Адрес :</label>
                <br>
                <input type="text" name="address" id="address">
            </p>
            <p>
                <label for="housetype">Тип дома :</label>
                <br>
                <input type="text" name="housetype" id="housetype">
            </p>
            <button type="submit">Подтвердить</button>
            <button type="reset" name="clear">Очистить</button>
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