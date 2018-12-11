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
<div class = "content">
    <div class = "hello_text">Hello!</div>
    <form action = "main_page" method = "POST">
        <br>
        <div class="reg">
            <p>
                <label for="Name">Name :</label>
                <br>
                <input type = "text" name = "Name" id="Name">
            </p>
            <p>
                <label for="Surname">Surname :</label>
                <br>

                <input type = "text" name = "Surname" id="Surname">
            </p>
            <p>
                <label for="Patronymic">Patronymic :</label>
                <br>

                <input type = "text" name = "Patronymic" id="Patronymic">
            </p>
            <button type="submit" name ="send">Say hello</button>
            <button type="reset" name="clear">Clear</button>
        </div>
    </form>
</div>
<div class="other">
    <form action="end.jsp">
        <button type="submit">To the end.</button>
    </form>
    <%
        Cookie cookie = null;
        Cookie[] cookies = null;
        String  name = "",
                surname = "",
                patronymic = "";
        cookies = request.getCookies();
        if(cookies != null){
            for (int i = 0; i < cookies.length; i++){
                cookie = cookies[i];
                if ((cookie.getName()).equals("Surname")) surname = cookie.getValue();
                if ((cookie.getName()).equals("Name")) name = cookie.getValue();
                if ((cookie.getName()).equals("Patronymic")) patronymic = cookie.getValue();
            }
            if ((!name.isEmpty())||(!surname.isEmpty())||(!patronymic.isEmpty())) {
                out.print("А ведь я знаю тебя... ты ");
                if (!surname.isEmpty()) out.print(surname+ " ");
                if (!name.isEmpty()) out.print(name + " ");
                if (!patronymic.isEmpty()) out.print(patronymic + "!");
            }
        }

    %>
</div>
</body>
</html>

<style >
    .content{
        margin: 10px 10px;
    }
    .reg{
        padding-left: 10px;
        width: 250px;
        height: 250px;
        border: solid 1px black;
        float: left;
        position: relative;
    }
    .hello_text{
        font-family: 'Lato', sans-serif;
        font-size: 65px;
        color: maroon;
    }
</style>