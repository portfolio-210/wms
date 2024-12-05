function getFormInfo() {
    var a = document.getElementById("searchKeyword").value.trim();
    
    if (a === "") {
        alert("검색어를 입력하세요");
        return false;
    } else {
        // 검색어를 비우기
        //document.getElementById("searchKeyword").value = "";

        // 새로운 폼 요소 생성
        var frm = document.createElement("form");
        frm.method = "post"; // 폼 메서드 설정
        frm.action = "/config/config_main.do"; // 폼 액션 설정

        // 소속 (part1) 필드 추가
        var part1 = document.createElement("input");
        part1.type = "hidden"; // 숨겨진 입력 필드로 설정
        part1.name = "part1"; // 이름 설정
        part1.value = document.getElementById("part1").value; // 값 설정
        frm.appendChild(part1);

        // 검색형식 (part2) 필드 추가
        var part2 = document.createElement("input");
        part2.type = "hidden"; // 숨겨진 입력 필드로 설정
        part2.name = "part2"; // 이름 설정
        part2.value = document.getElementById("part2").value; // 값 설정
        frm.appendChild(part2);

        // 검색어 필드 추가
        var search = document.createElement("input");
        search.type = "hidden"; // 숨겨진 입력 필드로 설정
        search.name = "search"; // 이름 설정
        search.value = a; // 값 설정
        frm.appendChild(search);

        // 폼을 body에 추가
        document.body.appendChild(frm);

        // 폼 제출
        frm.submit();
    }
}

function searchall(){
	
	var frc = document.createElement("form");
	       frc.method = "get"; // 폼 메서드 설정
	       frc.action = "/config_main.do"; // 폼 액션 설정
	       // 폼을 body에 추가
	       document.body.appendChild(frc);

	       // 폼 제출
	       frc.submit();
	  	
}

