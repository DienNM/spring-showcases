<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h3>Spring Security Sample Case 2</h3>

<sec:authorize access="authenticated" var="authenticated"/>
<c:choose>
    <c:when test="${authenticated}">
        <li>
            <div>Welcome <sec:authentication property="name" /></div>
        </li>
        <li>
            <c:url var="logoutUrl"  value="/logout" />
            <div><a href="${logoutUrl}">Logout</a></div>
        </li>
    </c:when>
    <c:otherwise>
        <c:url var="loginUrl" value="/login/form"/>
        <li>
            <a href="${loginUrl}">Login</a>
        </li>
    </c:otherwise>
</c:choose>

<hr>
<c:url var="postCommentUrl"  value="/comments/post" />
<c:url var="listCommentUrl"  value="/comments" />
<a href="${postCommentUrl}">New Comment</a>
<a href="${listCommentUrl}">List Comments</a>

<hr>
