<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-fluid">
      <nav class="navbar navbar-light bg-primary">

        <div class="col-sm">
          	<a class="navbar-brand" href="/rsrs/main/main.jsp"><img src="./img/logo/yugi.png" alt="logo">YUGIMATJO</a>         
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