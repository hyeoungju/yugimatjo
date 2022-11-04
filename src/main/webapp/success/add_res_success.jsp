<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="./css/customize.css">
<style type="text/css">
	.add_res_result { height : 100vh;}
	.resList { display : inline; }
	.sucess {margin : 50px;}
</style>
</head>
<body>
<header id="header">
	<jsp:include page="/incl/admin_header.jsp"/>
</header>

   <div class="row add_res_result">
   	<div class="resList">
   		<h3 class="sucess">등록되엇습니다.</h3>
   		<h1 class="sucess resname">${resName}</h1>   		
   		<button class="w-10 btn btn-lg btn-primary sucess" type="button" style="background-color : rgba(255,113,31); border : none;" onclick="location='/rsrs/restaurant/add_res.jsp'">다시 등록하러 가기</button>   
   </div>
   </div>

  
 <footer>
		<jsp:include page="/incl/footer.jsp"/>
</footer>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
 </body>
</body>
</html>