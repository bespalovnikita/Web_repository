<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление домов в базу</title>
</head>
<body>
<div class="new_house">
    <h3>Добавление домов! </h3>

    <form action="/" method="POST">
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
