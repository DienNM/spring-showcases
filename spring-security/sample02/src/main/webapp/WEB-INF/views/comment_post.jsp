<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Comment</title>
</head>
<body>
<%@include file="header.jsp" %>

<h1>Post your Comment</h1>

<c:url var="postActionUrl" value="/comments" />
<form:form action="${postActionUrl}" method="POST" modelAttribute="comment">

<table>
    <tr>
        <th width="120">Title</th>
        <td><form:input path="title" name="title" /></td>
    </tr>
    <tr>
        <th width="120">Content</th>
        <td><form:textarea path="content" name="content"></form:textarea></td>
    </tr>
    <tr>
        <td colspan="2"><button type="submit">Post</button></td>
    </tr>
</table>
</form:form>

</body>
</html>