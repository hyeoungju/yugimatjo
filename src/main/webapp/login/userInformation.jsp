<%@page import="com.matjo.rsrs.user.Grade"%>
<%@page import="com.matjo.rsrs.user.User"%>
<%@page import="com.matjo.rsrs.user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="./css/customize.css">
<style>
  	.mb-31 {
	  text-align: center;
	  padding: 25px;
	  font-weight: bold;
  	}
    body {
      min-height: 100vh;
      background-color: linear-gradient(to left rgba(255,113,31,.8));
    }

    .input-form {
      max-width: 680px;
      margin : 65px 0;
      padding: 32px;
      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
    .btn {
  	 background: linear-gradient(90deg, rgba(255,113,31,1) 0%, rgba(255,202,155,1) 100%);
     color: white;
     width: 300px;
     position: relative;
     left: 25%;
     }
  </style>
</head>
<body>
<header id="header">
	<jsp:include page="/incl/header.jsp"/>
</header>

    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-31">회원정보</h4>
        <form class="validation-form" action="mypage" method="post" enctype="multipart/form-data">
          <div class="row">
            
             <div class="col-md-6 mb-3">
              <label for="id">아이디 : <%=session.getAttribute("userId") %></label><br>
              <label for="id">등급 : <%=session.getAttribute("grade") %></label><br>
             
             <% if(request.getAttribute("") == "메추리알") { %>
          		<img alt="egg1" src="../img/egg/egg1.png">
             <% } else if (request.getAttribute("") == "계란") {%>
        		<img alt="egg1" src="../img/egg/egg2.png">
           	<%} %>
            </div>
           
          </div>
        </form>
        <button class="btn" type="submit" onclick="location.href='/rsrs/login/mypage.jsp'">뒤로가기</button>
      </div>
    </div>
    
<footer class="my-3 text-center text-small">
   <p class="mb-1">&copy; 2022 YM</p>
</footer>
	

<footer>
	<jsp:include page="/incl/footer.jsp"/>
</footer>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>	
</body>
</html>