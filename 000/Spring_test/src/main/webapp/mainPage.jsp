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
    <div class="content">
        <div class="hello_text">
        Helloz!
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
                <button type="submit">Send data and view DB.</button>
                <button type="reset" name="clear">Clear</button>
            </div>
        </form>
    </div>


    <%
            Cookie cookie = null;
            Cookie[] cookies = null;
            String name = "",
                    surname = "",
                    patronymic = "";
            cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if ((cookie.getName()).equals("Surname")) surname = cookie.getValue();
                    if ((cookie.getName()).equals("Name")) name = cookie.getValue();
                    if ((cookie.getName()).equals("Patronymic")) patronymic = cookie.getValue();
                }
                if ((!name.isEmpty()) || (!surname.isEmpty()) || (!patronymic.isEmpty())) {
                    out.print("А в прошлый раз заходил ");
                    if (!surname.isEmpty()) out.print(surname + " ");
                    if (!name.isEmpty()) out.print(name + " ");
                    if (!patronymic.isEmpty()) out.print(patronymic + "!");
                }
            }
    %>
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