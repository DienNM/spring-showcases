<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comments</title>
</head>
<body>

<h1>List of Comments</h1>
<sec:authorize access="authenticated" var="authenticated"/>
<c:choose>
    <c:when test="${authenticated}">
        <li>
            <div>Welcome <sec:authentication property="name" /></div>
        </li>
    </c:when>
    <c:otherwise>
        <c:url var="loginUrl" value="/login/form"/>
        <li>
            <a href="${loginUrl}">Login</a>
        </li>
    </c:otherwise>
</c:choose>


<c:url var="postCommentUrl"  value="/comments/post" />
<c:url var="logoutUrl"  value="/logout" />



<a href="${postCommentUrl}">New Comment</a> 
<a href="${logoutUrl}">Logout</a>

<table border="1">
    <thead>
        <tr>
            <th width="20">#</th>
            <th width="200">Title</th>
            <th width="100">Author</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${comments}" var="comment" varStatus="status">
            <tr>
                <c:url var="detailCommentUrl"  value="/comments/${comment.id}" />
                <td><a href="${detailCommentUrl}">${status.index + 1}</a></td>
                <td>${comment.title}</td>
                <td>${comment.author}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>