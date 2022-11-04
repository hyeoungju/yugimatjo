<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="search_result.do" method="get">
위치 : <input type="text" name="resLocation">
음식종류 : <input type="text" name="foodType">
가격 : <input type="text" name="foodPrice">
인원 : <input type="text" name="resCapacity">
<input type="submit" value="찾기">
</form>
</body>
</html>