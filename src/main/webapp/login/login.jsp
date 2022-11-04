<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="./css/customize.css">
</head>
<body>
	<header id="header">
		<jsp:include page="/incl/header.jsp"/>
	</header>
	
		<div class="container login">
	   <form action="login" method="post">
	   <div class="col-sm-5">
       <h1 class="h3 mb-3 fw-normal">Login</h1>   
       <div class="form-floating">
         <label for="floatingInput">아이디</label>
         <input type="text" class="form-control" id="floatingInput" placeholder="Id" name="userId">
       <div class="form-floating">
         <label for="floatingPassword">비밀번호</label>
         <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="passwd">
       </div>
       </div>
	   
	   </div>
       <div class="col-sm-3">
       <button class="w-100 btn btn-lg btn-primary" type="submit" style="background-color : rgba(255,113,31); border : none;">Login</button>       
       <button class="w-100 btn btn-lg btn-primary" type="button" style="background-color : rgba(255,113,31); border : none;" onclick="location='/rsrs/join/add_user.jsp'">Sign in</button>
       </div>
     </form>		
	</div>
	
	
	
	<footer>
		<jsp:include page="/incl/footer.jsp"/>
	</footer>
	
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</body>
</html>