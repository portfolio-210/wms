package wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import DTO.member_DTO;

@Mapper
public interface member_mapper {

		//1) 회원가입
		int member_join(member_DTO dto);
		
		//2 아이디 중복확인
		String search_id(String mid);
		
		//3) 로그인 사용자 정보 체크
		List<member_DTO> login_id(String mid);
}
