package wms.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wms.dto.MemberDTO;
import wms.dto.OfficeDTO;
import wms.mapper.OfficeMapper;
import wms.service.OfficeService;

@Service
public class OfficeServiceimp implements OfficeService{
	@Autowired
    OfficeMapper om;
	
	
	//지점 현황 전체 목록 조회
	@Override
	public List<OfficeDTO> office_list() {
		List<OfficeDTO> all = om.office_list();
		return all;
	}
	
	//검색한 지점 목록 조회
	@Override
	public List<OfficeDTO> search_office(String search) {
		List<OfficeDTO> result = om.search_office(search);
		return result;
	}
	
	//지점 삭제
	@Override
	public int delete_office(String oidx) {
		int result = om.delete_office(oidx);
		return result;
	}
	
	//등록할 지점명 중복 확인
	@Override
	public String check_officename(String officename) {
		String result = om.check_officename(officename);
		return result;
	}
	
	//팝업창 지점 관리자 리스트 출력
	@Override
	public List<MemberDTO> poplist_member() {
		List<MemberDTO> result = om.poplist_member();
		return result;
	}
	
	//관리자 리스트 팝업 관리자 검색
	@Override
	public List<MemberDTO> search_member(Map<String, String> keyword) {
		List<MemberDTO> all = om.search_member(keyword);
		return all;
	}
	
	//관리자 지정 시 해당 관리자의 정보 가져오기
	@Override
	public List<MemberDTO> apply_member(String midx) {
		List<MemberDTO> result = om.apply_member(midx);
		return result;
	}
	
	//officeInsert 지점 등록하기 버튼 시 적용
	@Override
	public int insert_office() {
		int result = om.insert_office();
		return result;
	}
}
