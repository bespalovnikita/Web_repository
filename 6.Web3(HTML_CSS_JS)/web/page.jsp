<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Welcome page</title>
    <meta name="description" content="Приветствие.">
</head>


<body>
<div class="content">
    <div class="hello_text">Hello!</div>
    <form action="hello.jsp" method="GET">
        <br>
        <div class="reg">
            <p>
                <label for="name">Имя :</label>
                <br>
                <input type="text" name="name" id="name">
            </p>
            <button type="submit" name="send">Send</button>
            <button type="reset" name="clear">Clear</button>
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