package wms.service;

import java.util.List;
import java.util.Map;

import wms.dto.ConfigDTO;

public interface ConfigService {
	
	
	List<ConfigDTO> all(Map<String, Object> keycode);
	List<ConfigDTO> searchall();
	int update1(ConfigDTO configDTO);
	
}
