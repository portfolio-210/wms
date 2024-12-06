package service;

import java.util.List;

import dto.MemberDTO;

public interface OfficeService {
	public List<dto.OfficeDTO> office_list();
	public List<dto.OfficeDTO> search_office(String search);
	public int delete_office(String oidx);
	public String check_officename(String officename);
	public List<MemberDTO> poplist_member();
}
