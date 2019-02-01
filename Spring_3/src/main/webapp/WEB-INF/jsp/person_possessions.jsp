<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Владения</title>
</head>
<body>
<div class="possessions">
    <H1>Владения ${possess_person.name} ${possess_person.surname} ${possess_person.patronymic} : </H1>
    <p>
            <c:forEach  var="customer" items="${houseList}">
          <h3><c:out value="${customer.address} ${customer.housetype}"/> </h3>
            </c:forEach>
    </p>
    <form action="${pageContext.request.contextPath}/">
        <button type="submit">На главную страницу</button>
    </form>
</div>

</body>
</html>
