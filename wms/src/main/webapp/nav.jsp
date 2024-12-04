<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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