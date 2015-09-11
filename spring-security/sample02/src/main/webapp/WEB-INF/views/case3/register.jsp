<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
</head>
<body>
<%@include file="header.jsp" %>

<h1>Add User</h1>

<c:url var="addActionUrl" value="/login/register/submit" />
<form:form action="${addActionUrl}" method="POST" modelAttribute="user">

<table>
    <tr>
        <th width="120">Email</th>
        <td><form:input path="email" name="email" /></td>
    </tr>
    <tr>
        <th width="120">Password</th>
        <td><form:input path="password" name="password" /></td>
    </tr>
    <tr>
        <th width="120">First Name</th>
        <td><form:input path="firstName" name="firstName" /></td>
    </tr>
    <tr>
        <th width="120">Last Name</th>
        <td><form:input path="lastName" name="lastName" /></td>
    </tr>
    <tr>
        <th width="120">Encrypted</th>
        <td><form:checkbox path="encrypted" name="encrypted" /></td>
    </tr>
    <tr>
        <td colspan="2"><button type="submit">Add</button></td>
    </tr>
</table>
</form:form>

</body>
</html>