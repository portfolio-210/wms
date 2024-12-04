<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <title>이행 물류 시스템</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
    <script src="../js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.css?v=1">
    <link rel="stylesheet" href="../css/default.css?v=20241125">  
    <link rel="stylesheet" href="../css/jumbotron.css">  
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
  </head>
  <body>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <a class="navbar-brand" href="#">ADMINISTRATOR</a>
  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown" style="width:100px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">입고관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">상품입고</a>
          <a class="dropdown-item" href="#">재고 및 창고이동</a>
          <a class="dropdown-item" href="#">재고 팔레트 이동</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:100px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">오더관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">오더등록 및 현황</a>
          <a class="dropdown-item" href="#">배송선택(본사,지점)</a>
          <a class="dropdown-item" href="#">반품처리</a>
          <a class="dropdown-item" href="#">취소처리</a>
          <a class="dropdown-item" href="#">교환반품/취소리스트</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:160px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">창고 및 기사배정</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">창고리스트</a>
          <a class="dropdown-item" href="#">창고등록</a>
          <a class="dropdown-item" href="#">배송기사 배정</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:120px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">배송 관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">배송현황 및 운송장 출력</a>
        </div>
      </li>
      <li class="nav-item dropdown" style="width:150px;">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">배송 기사관리</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">배송기사 리스트</a>
          <a class="dropdown-item" href="#">배송 기사별 배송현황</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">환경설정</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">관리자 현황</a>
          <a class="dropdown-item" href="#">지점 현황</a>
          <a class="dropdown-item" href="#">거래처 현황</a>
          <a class="dropdown-item" href="#">팔레트 현황</a>
        </div>
      </li>
    </ul>
      <span style="color: white; margin-right: 5px;">[본사] 홍길동 님 환영합니다.</span>
      <button class="btn btn-outline-success my-2 my-sm-0" type="button">로그아웃</button>
  </div>
</nav>

<main role="main" style="height: 850px;">
  <div class="container">
    <div>
    <p class="sub_title font16_bold">관리자 현황</p>
    <div class="mb-3" style="position: relative;">
        <ul class="ul-2">
            <li class="num_font13_bold">소 속</li>
            <li>
                <select id="searchType" style="width: 100px; height: 40px; margin-right: 5px;" class="form-control font12">
                    <option id="workspace1" value="본사">본사</option>
                    <option id="workspace2" value="지점">지점</option>
                </select>
            </li>
            <li></li>
            <li></li>
        </ul> 
       <ul class="ul-2">
		    <li class="num_font13_bold">검색형식</li>
		    <li style="width: 85%; display: flex; flex-direction: row;">
		        <select id="searchType" style="width: 100px; height: 40px; margin-right: 5px;" class="form-control font12">
		            <option value="name">이름</option>
		            <option value="id">아이디</option>
		            <option value="contact">연락처</option>
		        </select>
		        <input type="text" id="searchKeyword" style="width: 200px; height: 40px;" class="form-control font12" placeholder="검색어를 입력하세요">
		        <button type="button" class="btn btn-primary font12" style="width: 70px; height: 40px; margin-left:10px; margin-right: 10px;" onclick="search()">검색</button>
		        <button type="button" class="btn btn-dark font12" style="width: 70px; height: 40px; margin-right: 10px;" onclick="searchAll()">전체</button> 
		    </li>
		</ul>
     </div>
     <div class="mb-3">
        <table class="table table-striped font12">
            <thead>
              <tr align="center" style="height: 30px; line-height: 30px;">
                <th scope="col" style="width: 50px;">NO</th>
                <th scope="col" style="width: 150px;">구분</th>
                <th scope="col" style="width: 150px;">아이디</th>
                <th scope="col" style="width: 100px;">이름</th>
                <th scope="col" style="width: 100px;">직책</th>
                <th scope="col" style="width: 250px;">이메일</th>
                <th scope="col" style="width: 150px;">연락처</th>
                <th scope="col">현황</th>
                <th scope="col" style="width: 100px;">적용</th>
              </tr>
            </thead>
            <tbody>
            
              <tr align="center">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <select style="width: 80px; height: 30px;" class="form-control font12">
                        <option>대기</option>
                        <option>근무</option>
                        <option>휴직</option>
                        <option>퇴사</option>
                    </select>
                </td>
                <td style="text-align: center;">
                    <button type="button" class="btn btn-dark font12" style="width: 50px; height: 30px; margin-right: 10px;">적용</button> 
                </td>
              </tr>
             
            </tbody>
          </table>
     </div>
     <div class="mb-3">
        <ul class="pageing">
          <li>1</li>
        </ul>
      </div>
    </div>
  </div>
</main>


<footer class="container" style="border-top:1px solid black; height: 30px; padding-top: 10px;">
  <p style="height: 30px; line-height: 30xp;">Copyright &copy; 이행 물류 시스템 Company 2024 All Rights Reserved.</p>
</footer>
<script src="./config.js?v=1"></script>
  </body>
</html>