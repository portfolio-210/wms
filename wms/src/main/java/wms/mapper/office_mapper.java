package wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import DTO.office_DTO;

@Mapper
public interface office_mapper {

	public List<office_DTO> office_list();
	public List<office_DTO> search_office(String search);
	public int delete_office(String oidx);
}
