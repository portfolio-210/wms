//office_main.jsp
var search_word = document.getElementById("search");

//검색 버튼 클릭 시 적용 함수
function search_office(){
	console.log(search_word);
	if(search_word.value == ""){
		//검색어를 입력하지 않은 경우
		alert("검색할 지점명을 입력해주세요.");
		search_word.focus();
	}
	else {
		//검색어를 입력한 경우
		var search = search_word.value.trim();
		search = search.replaceAll(" ", "");
		
		if(search.length == 0){
			alert("검색어를 다시 한 번 확인해주세요.");
			search_word.focus();
		}

		else {
			frm.method="post";
			frm.action="../office/office_main.do";
			frm.submit();
		}
	}
}

//전체 버튼 클릭 시 적용 함수
function searchAll_office(){
	search_word.value = "";
	frm.method="post";
	frm.action="../office/office_main.do";
	frm.submit();
}

//수정 버튼 클릭 시 적용 함수
function modify_office(){
	
}

//삭제 버튼 클릭 시 적용 함수
function delete_office(oidx){
	console.log(oidx);
	var key = window.btoa("wms.test");
	if(confirm("해당 게시물을 삭제하시겠습니까?\n삭제된 데이터는 복구하지 못합니다.")){
		location.href="../office/office_delete.do?oidx=" + window.btoa(oidx) + "&key=" + key;
	}
}


//office_insert.jsp

//지점명 중복체크 버튼 클릭 시 적용 함수
function officenameCheck(){
	var officename = frm.officename.value;
	officename = officename.replaceAll(" ", "");
	
	//ajax로 중복 이름 있는 지 확인
}

//아이디 찾기 버튼 클릭 시 적용 함수
function findId(){
	location.href = "";	//pop_list로 이동
}

//등록하기 버튼 클릭 시 적용 함수
function insert_ok(){
	var oaddress = frm.oaddress.value;
	if(oaddress == ""){
		alert("상세 주소를 입력해주세요.");
	}
}

//취소하기 버튼 클릭 시 적용 함수
function cancel(){
	frm.reset();
}

//주소 찾기 카카오 API 연동





