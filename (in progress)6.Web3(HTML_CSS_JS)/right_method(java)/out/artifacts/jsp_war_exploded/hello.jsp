<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
<title></title>
</head>
<body>
    <div class="hello_text">Hello, <%= request.getParameter("name")%> ! </div>
</body>
</html>

<style >

    .hello_text{
        font-family: 'Comic Sans MS', cursive, sans-serif;
        font-size: 35px;
        color: maroon;
    }

    .hello_text:hover{
        font-size: 35px;
        color: gold;
        background-color:rgba(0,0,0,.4);
    }

</style>