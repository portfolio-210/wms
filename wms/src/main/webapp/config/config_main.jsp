<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!-- Header -->
<%@ include file="../header.jsp"%>
<!-- Nav -->
<%@ include file="../nav.jsp"%>   

<main role="main" style="height: 850px;">
  <div class="container">
    <div>
    <p class="sub_title font16_bold">관리자 현황</p>
    <div class="mb-3" style="position: relative;">
        <ul class="ul-2">
            <li class="num_font13_bold">소 속</li>
            <li>
                <select name="part1" id="searchType" style="width: 100px; height: 40px; margin-right: 5px;" class="form-control font12">
                    <option value="1">본사</option>
                    <option value="2">지점</option>
                </select>
            </li>
            <li></li>
            <li></li>
        </ul> 
       <ul class="ul-2">
		    <li class="num_font13_bold">검색형식</li>
		    <li style="width: 85%; display: flex; flex-direction: row;">
		        <select name="part2" id="searchType" style="width: 100px; height: 40px; margin-right: 5px;" class="form-control font12">
		            <option value="1">이름</option>
		            <option value="2">아이디</option>
		            <option value="3">연락처</option>
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

<!-- Footer -->
<%@ include file="../footer.jsp"%>