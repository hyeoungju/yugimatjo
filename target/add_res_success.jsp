<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div id="wrapper">

   <div id="content-wrapper">
   		<h3>회원가입되었습니다.</h3>
   		<jsp:useBean id="resName" class="com.matjo.rsrs.restaurant.Restaurant" scope="request"/>
   			식당이름 : <jsp:getProperty property="resName" name="resName"/>
   </div>
  </div>
  </body>
</body>
</html>