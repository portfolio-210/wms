package wms.service;

import java.util.List;
import java.util.Map;

import wms.dto.MemberDTO;
import wms.dto.OfficeDTO;

public interface OfficeService {
	public List<OfficeDTO> office_list();
	public List<OfficeDTO> search_office(String search);
	public int delete_office(String oidx);
	public String check_officename(String officename);
	public List<MemberDTO> poplist_member();
	public List<MemberDTO> search_member(Map<String, String> keyword);
	public List<MemberDTO> apply_member(String midx);
	//officeInsert 지점 등록하기 버튼 시 적용
	public int insert_office();
}
