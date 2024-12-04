package service;

import java.util.List;

import DTO.member_DTO;

public interface member_service {

	// 1) 회원가입
	public int member_join(member_DTO dto);
	
	//2) 아이디 중복확인
	public String search_id(String mid);
	
	//3) 로그인 
	public List<member_DTO> login_id(String mid);
}
