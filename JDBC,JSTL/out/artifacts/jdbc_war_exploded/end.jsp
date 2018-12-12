<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<c:set var="Name" value='${cookie["Name"].value}' />
<c:set var="Surname" value='${cookie["Surname"].value}' />
<c:set var="Patronymic" value='${cookie["Patronymic"].value}' />
<c:if test="${Name != '' || Surname != '' || Patronymic != ''}">
    <h3><c:out value=" В прошлый раз был записан "/> <c:out value="${Surname}"/> <c:out value="${Name}"/> <c:out value="${Patronymic}"/> .</h3>
</c:if>

<sql:setDataSource var = "Base" driver = "com.mysql.jdbc.Driver"
                   url = "jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=UTC"
                   user = "root"  password = "test"/>
<sql:query dataSource = "${Base}" sql = "select * from test.table;" var = "result">
</sql:query>
<table border = "1" width = 300px>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
    </tr>
    <c:forEach var = "row" items = "${result.rows}">
        <tr>
            <td> <c:out value = "${row.name}"/></td>
            <td> <c:out value = "${row.surname}"/></td>
            <td> <c:out value = "${row.patronymic}"/></td>
        </tr>
    </c:forEach>
</table>
</body>

</html>