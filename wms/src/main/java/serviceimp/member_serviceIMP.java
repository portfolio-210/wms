package serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.member_DTO;
import service.member_service;
@Service
public class member_serviceIMP implements member_service {

	@Autowired
	private wms.mapper.member_mapper mm;
	
	
	// 회원가입
	@Override
	public int member_join(member_DTO dto) {
		int result = mm.member_join(dto);	
		return result;
	}
	
	// 아이디 중복체크
	@Override
	public String search_id(String mid) {	
		String result = mm.search_id(mid);
		return result;
	}
	
	
	// 로그인 파트
	@Override
	public List<member_DTO> login_id(String mid){
		List<member_DTO> member_dto = mm.login_id(mid);
		return member_dto;
		}
	
	
	
}
