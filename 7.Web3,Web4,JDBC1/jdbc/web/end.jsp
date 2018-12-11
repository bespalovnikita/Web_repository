<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>

<body>
<%
    Cookie cookie = null;
    Cookie[] cookies = null;
    cookies = request.getCookies();
    if( cookies != null ) {
        out.print("<h2> Hello, </h2>");
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if (cookie.getName().equals("Name")) out.print(cookie.getValue( ) + " ");
        }
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if (cookie.getName().equals("Surname")) out.print(cookie.getValue( ) + " ");
        }
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if (cookie.getName().equals("Patronymic")) out.print(cookie.getValue( ) + "!!");
        }
    } else {
        out.println("<h2>No cookies founds</h2>");
    }
%>
</body>

</html>