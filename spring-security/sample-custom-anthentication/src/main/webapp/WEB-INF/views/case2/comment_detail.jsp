<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comment Detail</title>
</head>
<body>
<%@include file="header.jsp" %>

<h1>Comment Detail</h1>
<table>
    <tbody>
	    <tr>
	         <th width="100">Author</th>
	        <td>${comment.author}</td>
	    </tr>
	    <tr>
             <th>Title</th>
            <td>${comment.title}</td>
        </tr>
        <tr>
             <th>content</th>
            <td>${comment.content}</td>
        </tr>
    </tbody>
</table>
</body>
</html>