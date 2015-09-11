<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%@include file="header.jsp" %>

<h1>Login</h1>
<c:url var="loginActionUrl" value="/login" />
<form action="${loginActionUrl}" method="POST">

<c:if test="${param.error != null}">
    Failed to login.
        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
            Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
        </c:if>
</c:if>

<table>
    <tr>
        <th width="120">Email</th>
        <td><input name="email" /></td>
    </tr>
    <tr>
        <th width="120">Password</th>
        <td><input type="password" name="password" /></td>
    </tr>
    
    <%-- <input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
    
    <tr>
        <td colspan="2"><button type="submit">Login</button></td>
    </tr>
</table>
</form>

</body>
</html>