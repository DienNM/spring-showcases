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

<h1>Comment Detail</h1>

<c:url var="postCommentUrl"  value="/comments/post" />
<c:url var="listCommentUrl"  value="/comments" />

<a href="${postCommentUrl}">New Comment</a> 
<a href="${listCommentUrl}">List Comments</a>

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