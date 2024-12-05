package wms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface config_mapper {

	List<DTO.config_DTO> all(Map<String, String> keycode);
	List<DTO.config_DTO> searchall();
	
}
