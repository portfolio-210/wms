package service;

import java.util.List;

public interface OfficeService {
	public List<dto.OfficeDTO> office_list();
	public List<dto.OfficeDTO> search_office(String search);
	public int delete_office(String oidx);
}
