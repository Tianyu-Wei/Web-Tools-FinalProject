<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tianyuwei
  Date: 3/25/20
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${sessionScope.result}" var="testresult">
    name: <c:out value="${testresult.name}"/><br>
    amount: <c:out value="${testresult.amount}"/><br>
    price: <c:out value="${testresult.price}"/>
</c:forEach>
</body>
</html>
