<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식당 검색결과</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="../css/result_res.css">
<link rel="stylesheet" href="../css/customize.css">
</head>
<body>
	<header id="header">
		<jsp:include page="/incl/header.jsp"/>
	</header>
	
	<div class="container filteringbox" style="margin-bottom : 150px;">
		<div class="row">
		<h3>검색결과</h3>
		</div>
		<div class="row">
			<table class="result-table">
			<tr class="table-header">
				<th>식당이름</th>
				<th>평점</th>
				<th>음식</th>
				<th>평균가격</th>
				<th>인원</th>
			</tr>
			<c:forEach var="restaurant" items="${rList}">
				<tr class="resList">
						<td><a href="/rsrs/restaurant/subpage?resName=${restaurant.resName}">${restaurant.resName}</a></td><td>${restaurant.resScore}</td>
						<td>${restaurant.foodType}</td><td>${restaurant.foodPrice}</td>
						<td>${restaurant.resCapacity}</td>
				</tr>
			</c:forEach>	
			</table>
		</div>		
	</div>
	<footer>
		<jsp:include page="/incl/footer.jsp"/>
	</footer>
	
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</body>
</html>