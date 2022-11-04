<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
   <div id="content-wrapper">
   		<c:if test="${not empty errorMsgs}">
   			<h3>다음과 같은 에러가 발생했습니다.</h3>
   			<ul>
   				<c:forEach var="errorMsg" items="${errorMsgs}" >
   					<li>${errorMsg}</li>
   				</c:forEach>
   				<c:when test="">
   					<c:choose></c:choose>
   					<c:otherwise></c:otherwise>
   				</c:when>
   			</ul>
   		</c:if>
   </div>
  </div>
</body>
</html>