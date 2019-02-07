<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
<h4>
<c:forEach  var="customer" items="${customerList}">
    <c:out value="${customer.name} "/>
    <h4>
    <c:forEach  var="document" items="${customer.documentList}">
        <c:out value="${document.name} ${document.status.name} ${document.doctype.name}"/>
    </c:forEach>
    </h4>
</c:forEach>


</body>
</html>
