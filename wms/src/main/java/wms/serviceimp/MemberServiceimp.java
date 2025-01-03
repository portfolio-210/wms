package wms.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wms.dto.MemberDTO;
import wms.mapper.MemberMapper;
import wms.service.MemberService;

@Service
public class MemberServiceimp implements MemberService {

	@Autowired
	private MemberMapper mm;
	
	
	// 회원가입
	@Override
	public int member_join(MemberDTO dto) {
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
	public List<MemberDTO> login_id(String mid){
		List<MemberDTO> member_dto = mm.login_id(mid);
		return member_dto;
		}
	
	
	
}
