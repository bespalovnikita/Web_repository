<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
<c:forEach  var="customer" items="${customerList}">
    <h4><c:out value="${customer.c_id} ${customer.reestrid} ${customer.name} ${customer.code}"/> </h4>
</c:forEach>
</body>
</html>
