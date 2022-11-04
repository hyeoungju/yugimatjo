<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
  <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 
<link rel="stylesheet" href="./css/customize.css">
</head>
<body>
<header id="header">
	<div class="container-fluid">
      <nav class="navbar navbar-light bg-primary">

        <div class="col-sm">
          	<a class="navbar-brand" href="/rsrs/main/main.jsp"><img src="../img/logo/yugi.png" alt="logo">YUGIMATJO</a>         
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
        <%if(session.getAttribute("userId")==null){ %>
        <li class="nav-item">
          <a class="nav-link text-dark" href=" /rsrs/login/login">로그인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link color-primary" href="/rsrs/join/add_user.jsp">회원가입</a>
        </li>
        <%}else{ %>
        <li class="nav-item">
          <a class="nav-link text-dark" href="/rsrs/login/mypage.jsp">마이페이지</a>
        </li>
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
    <div class="input-form-backgroud row" style="max-width: 680px;
      margin-top: 100px;
      margin-bottom: 100px;
      padding: 32px;
      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-31" style="text-align: center;
	  padding: 25px;
	  font-weight: bold;">회원가입</h4>
        <form class="validation-form" action="add_user.do" method="post">
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">이름</label>
              <input type="text" class="form-control" id="name" placeholder="이름" name="userName" required>
              <div class="invalid-feedback">
                이름을 입력해주세요.
              </div>
            </div>
             <div class="col-md-6 mb-3">
              <label for="id">아이디</label>
              <input type="text" class="form-control" id="id" placeholder="id" name="userId" required>
              <div class="invalid-feedback">
                아이디를 입력해주세요.
              </div>
            </div>
             <div class="col-md-6 mb-3">
              <label for="passwd">비밀번호</label>
              <input type="password" class="form-control" id="passwd" placeholder="비밀번호" name="passwd" required>
              <div class="invalid-feedback">
                비밀번호를 입력해주세요.
              </div>
            </div>
            <div class="col-md-6 mb-3">
              <label for="nickname">닉네임</label>
              <input type="text" class="form-control" id="nickname" placeholder="닉네임" name="nickname" required>
              <div class="invalid-feedback">
                닉네임을 입력해주세요.
              </div>
            </div>
          </div>
            <button class="btn" type="submit" style="background: linear-gradient(90deg, rgba(255,113,31,1) 0%, rgba(255,202,155,1) 100%); color: white; width: 300px; position: relative; left: 25%;">가입 완료</button>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2022 YM</p>
    </footer>
  </div>
  
<footer>
	<jsp:include page="/incl/footer.jsp"/>
</footer>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

<script>
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  </script>
</body>
</html>