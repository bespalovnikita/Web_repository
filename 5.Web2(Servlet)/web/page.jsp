<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>
    .hello_text {
        font-family: 'Lato', sans-serif;
        font-size: 35px;
        color: maroon;
    }
</style>
<head>
    <title>Hello!</title>
</head>
<body>
<div>
    <p>
    <div class="hello_text">Hello, <%=request.getAttribute("name")%> !</div>
    </p>
</div>
</body>
</html>