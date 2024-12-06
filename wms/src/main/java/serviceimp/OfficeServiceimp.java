package serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.OfficeDTO;
import service.OfficeService;

@Service
public class OfficeServiceimp implements OfficeService{
	@Autowired
	wms.mapper.OfficeMapper om;
	
	
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
}
