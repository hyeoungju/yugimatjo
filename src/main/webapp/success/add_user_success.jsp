<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="../css/customize.css">
<style type="text/css">
	.container {height : 100vh; margin : 0 auto;}
	.join_txt {margin-top : 200px;}
	.btn {
  	 background: linear-gradient(90deg, rgba(255,113,31,1) 0%, rgba(255,202,155,1) 100%);
     color: white;
     width: 300px;
     position: relative;
     left: 25%;
     margin-top : 100px;
     }
</style>
</head>
<body>
<header id="header">
	<div class="container-fluid">
      <nav class="navbar navbar-light bg-primary">

        <div class="col-sm">
         	<a class="navbar-brand" href="/rsrs/restaurant/add_res.jsp"><img src="../img/logo/yugi.png" alt="logo"/>YUGIMATJO</a>
        </div>
        <div class="col col-md-4">
        </div>
        <div class="col-sm">
          <nav class="nav justify-content-end ">
            <a class="nav-link text-white" href="#">#앙비앙스</a>
            <a class="nav-link text-white" href="#">#분위기 맛집</a>
          </nav>
        </div>

      </nav>
      <ul class="nav border-bottom shadow-sm p-3 bg-white rounded" style="align-items:center;">
        <li class="nav-item dropdown">
          <a class="nav-link text-dark dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-expanded="false">맛집 찾기</a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="#">편안한</a>
            <a class="dropdown-item" href="#">럭셔리한</a>
            <a class="dropdown-item" href="#">데이트하기 좋은</a>
            <a class="dropdown-item" href="#">가성비 좋은</a>
            <a class="dropdown-item" href="#">단체가능</a>
          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link text-dark">등급보기</a>
        </li>
        <%if(session.getAttribute("userId")==null){ %>
        <li class="nav-item">
          <a class="nav-link text-dark" href=" /rsrs/login/login">로그인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link color-primary" href="/rsrs/join/add_user.jsp">회원가입</a>
        </li>
        <%}else{ %>
        <li class="nav-item">
        	<%=session.getAttribute("userId") %>님 환영합니다!
        </li>
        <li class="nav-item">
          <a class="nav-link color-primary" href="/rsrs/login/logout">로그아웃</a>
        </li>
        <%} %>
      </ul>
    </div>
</header>

<div class="container">
	<div class="row join_txt">
	 <h2>${userName} 님, 회원가입 되었습니다.</h2>
	</div>
	 <button class="btn" type="submit"><a style= "color:white;" href="/rsrs/main/main.jsp">뒤로가기</a></button>
	
</div>

<footer>
	<jsp:include page="/incl/footer.jsp"/>
</footer>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>