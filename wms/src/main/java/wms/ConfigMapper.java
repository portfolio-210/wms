package wms;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import wms.dto.ConfigDTO;

@Mapper
public interface ConfigMapper {

	List<ConfigDTO> all(Map<String, Object> keycode);
	List<ConfigDTO> searchall();
	int update1(ConfigDTO configDTO);
	
	
}
