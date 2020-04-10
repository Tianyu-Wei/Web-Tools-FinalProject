<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: weier
  Date: 4/7/2020
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>BORAJI.COM</title>
</head>
<body>
<h1>Spring MVC 5 + Spring Security 5 + Hibernate 5 example</h1>
<h2>${message}</h2>

<form action="/logout" method="post">
    <input value="Logout" type="submit">
</form>
</body>
</html>
