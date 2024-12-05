package service;

import java.util.List;

public interface office_service {
	public List<DTO.office_DTO> office_list();
	public List<DTO.office_DTO> search_office(String search);
	public int delete_office(String oidx);
}
