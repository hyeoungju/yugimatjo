<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기맛줘</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <link rel="stylesheet" href="../css/customize.css">
</head>
<body>
	<header id="header">
		<jsp:include page="/incl/header.jsp"/>
	</header>
	
	<form action="search_result.do" method="get">
		<div class="container filteringbox">
    <div class="row">
      <div class="col-sm-3">
        <label for="state">예산</label>
        <select class="custom-select d-block w-100" id="state" required name="foodPrice">
          <option value="">선택하세요.</option>
          <option>10,000원 미만</option>
          <option>10,000 ~ 30,000원</option>
          <option>30,000 ~ 50,000원</option>
          <option>50,000 ~ 100,000원</option>
        </select>
        <div class="invalid-feedback">
          Please provide a valid state.
        </div>
      </div>
      <div class="col-sm-3">
        <label for="state">인원</label>
        <select class="custom-select d-block w-100" id="state" name="resCapacity" required>
          <option value="">선택하세요.</option>
          <option>1인</option>
          <option>2인</option>
          <option>5인 이하</option>
          <option>6인 이상</option>
        </select>
        <div class="invalid-feedback">
          Please provide a valid state.
        </div>
      </div>
      <div class="col-sm-3">
        <label for="state">음식종류</label>
        <select class="custom-select d-block w-100" id="state" name="foodType" required>
          <option value="">선택하세요.</option>
          <option>한식</option>
          <option>일식</option>
          <option>중식</option>
          <option>양식</option>
          <option>분식</option>
        </select>
        <div class="invalid-feedback">
          Please provide a valid state.
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-5">
        <div id="sido">
          <label for="state">위치</label>
          <select id="sidoSelect" onchange="changeSidoSelect();" class="custom-select d-block w-100" name="resLocation1">
            <option value>(시)를 선택하세요.</option>
          </select>
        </div>
      </div>
      <div class="col-sm-5">
        <select id="gugunSelect" onchange="changeSecondSelect();" class="custom-select d-block w-100 city" name="resLocation2">
          <option value>(구)를 선택하세요.</option>
        </select>
      </div>
    </div>
    <div class="row search_button">
      <input type="submit" value="필터적용">
    </div>
  </div>
	</form>
	
	<div class="container-fluid oimg position-relative" style="width:100%;height:300px;background-image: url('./img/banner/b2.png');">
    <div class="row" style="margin-top : 160px;">
      <div class="col text-center" style="margin-top:50px;">
        <h1 class=" text-danger font-weight-bold">여기맛줘</h1>
        <h1>맛집을 추천하고, 추천받고 !</h1>
        <h1 class=" font-weight-bold">여기 맛줘와 맛있는 하루를</h1>
      </div>
    </div>
  </div>
	
	<footer>
		<jsp:include page="/incl/footer.jsp"/>
	</footer>
	
	
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
<script type="text/javascript">
    //참고
    // 대분류
    var firstList = new Array("대구", "서울", "경기", "부산", "대전");
    // 중분류
    var secondList1 = new Array("달서구", "중구", "수성구", "서구", "남구", "달성군", "동구", "북구");
    var secondList2 = new Array("강남", "강북", "성북구", "서초구", "성동구", "금천구", "동대문구");
    var secondList3 = new Array("남양주", "고양", "일산동구", "일산서구");
    var secondList4 = new Array("강서구", "금정구", "동래구", "수영구");
    var secondList5 = new Array("대덕구", "동구", "서구", "유성구", "중구");
    // 페이지 로딩시 자동 실행
    window.onload = function() {
      var v_sidoSelect = document.getElementById("sidoSelect"); // SELECT TAG

      for (i = 0; i < firstList.length; i++) { // 0 ~ 3
        // 새로운 <option value=''>값</option> 태그 생성
        var optionEl = document.createElement("option");

        // option태그에 value 속성 값으로 저장
        optionEl.value = firstList[i];

        // text 문자열을 새로 생성한 <option> 태그의 값으로 추가
        optionEl.appendChild(document.createTextNode(firstList[i]));

        // 만들어진 option 태그를 <select>태그에 추가
        v_sidoSelect.appendChild(optionEl);
      }

      var v_gugunSelect = document.getElementById("gugunSelect"); // SELECT TAG
      v_gugunSelect.style.display = "none"; // 태그 감추기
      var v_gugunSelect = document.getElementById("lastSelect"); // SELECT TAG
      v_gugunSelect.style.display = "none"; // 태그 감추기

    }

    // 대분류 선택시
    function changeSidoSelect() {
      var v_sidoSelect = document.getElementById("sidoSelect"); // SELECT TAG
      var idx = v_sidoSelect.options.selectedIndex; // 선택값 0 ~ 5

      if (idx < 1 && idx > 5) {
        return;
      }

      gugunSelectFill(idx); // 중분류 생성
    }


    function gugunSelectFill(idx) {
      var v_gugunSelect = document.getElementById("gugunSelect"); // SELECT TAG
      var v_secondSelect = document.getElementById("lastSelect");

      var data = null;

      if (idx == 0) {
        v_gugunSelect.style.display = "none"; // 중분류 태그 감추기
        v_secondSelect.style.display = "none";
        return;
      }

      if (idx == 1) {
        data = secondList1

      }
      if (idx == 2) {
        data = secondList2

      }
      if (idx == 3) {
        data = secondList3

      }
      if (idx == 4) {
        data = secondList4

      }
      if (idx == 5) {
        data = secondList5

      }


      v_gugunSelect.innerHTML = ""; // 태그 출력

      for (i = 0; i < data.length; i++) {
        // 새로운 <option value=''>값</option> 태그 생성
        var optionEl = document.createElement("option");

        // value 속성 태그에 저장
        optionEl.value = data[i];

        // text 문자열을 새로 생성한 <option> 태그에 추가
        optionEl.appendChild(document.createTextNode(data[i]));

        // 만들어진 option 태그를 <select>태그에 추가
        v_gugunSelect.appendChild(optionEl);
      }

      v_gugunSelect.style.display = ""; // 중분류 태그 출력


    }

    // 대분류 선택시
    function changeSecondSelect() {
      var v_sidoSelect = document.getElementById("sidoSelect"); // SELECT TAG
      var v_secondSelect = document.getElementById("gugunSelect"); // SELECT TAG
      var idx = v_sidoSelect.options.selectedIndex;
      var idx2 = v_secondSelect.options.selectedIndex; // 선택값 0 ~ 5

      // alert("select: " + selText);
      if (idx < 1 && idx > 5) {
        return;
      }


      lastSelectFill(idx, idx2, idx3, idx4, idx5); // 중분류 생성
    }

    function lastSelectFill(idx, idx2, idx3, idx4, idx5) {
      var v_lastSelect = document.getElementById("lastSelect"); // SELECT TAG
      var data = null;

      if (idx == 0) {
        v_lastSelect.style.display = "none"; // 중분류 태그 감추기
        btnArea.style.display = "none";
        return;
      }

      if (idx == 1 && idx2 == 0) {
        data = lastList1_1
      }
      if (idx == 1 && idx2 == 1) {
        data = lastList1_2
      }
      if (idx == 1 && idx2 == 2) {
        data = lastList1_3
      }
      if (idx == 1 && idx2 == 3) {
        data = lastList1_4
      }
      if (idx == 2 && idx2 == 0) {
        data = lastList2_1
      }
      if (idx == 2 && idx2 == 1) {
        data = lastList2_2
      }
      if (idx == 2 && idx2 == 2) {
        data = lastList2_3
      }
      if (idx == 2 && idx2 == 3) {
        data = lastList2_4
      }


      v_lastSelect.innerHTML = ""; // 태그 출력

      for (i = 0; i < data.length; i++) {
        // 새로운 <option value=''>값</option> 태그 생성
        var optionEl = document.createElement("option");

        // value 속성 태그에 저장
        optionEl.value = data[i];

        // text 문자열을 새로 생성한 <option> 태그에 추가
        optionEl.appendChild(document.createTextNode(data[i]));

        // 만들어진 option 태그를 <select>태그에 추가
        v_lastSelect.appendChild(optionEl);
      }

      v_lastSelect.style.display = ""; // 중분류 태그 출력

    }
  </script>
</body>
</html>