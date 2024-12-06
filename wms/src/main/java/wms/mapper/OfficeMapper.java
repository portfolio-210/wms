package wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dto.OfficeDTO;

@Mapper
public interface OfficeMapper {

	public List<OfficeDTO> office_list();
	public List<OfficeDTO> search_office(String search);
	public int delete_office(String oidx);
	public String check_officename(String officename);
}
