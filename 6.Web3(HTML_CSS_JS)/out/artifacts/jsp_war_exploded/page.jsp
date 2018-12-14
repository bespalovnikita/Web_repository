<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.12.2018
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Страница с приветствием.</title>
    <meta name="description" content="Приветствие.">
</head>


<body>
<div class="content">
    <div class="hello_text">Здравствуйте!</div>
    <form action="hello.jsp" method="GET">
        <br>
        <div class="reg">
            <p>
                <label for="name">Имя :</label>
                <br>
                <input type="text" name="name" id="name">
            </p>
            <button type="submit" name="send">Отправить</button>
            <button type="reset" name="clear">Очистить содержимое</button>
        </div>
    </form>
</div>
</body>

</html>

<style>
    .content {
        margin: 10px 10px;
    }

    .reg {
        padding-left: 10px;
        width: 250px;
        height: 110px;
        border: solid 1px black;
        float: left;
        position: relative;
    }

    .hello_text {
        font-family: 'Lato', sans-serif;
        font-size: 35px;
        color: maroon;
    }

</style>