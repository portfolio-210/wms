package service;

import java.util.List;
import java.util.Map;

import dto.ConfigDTO;

public interface ConfigService {
	
	
	List<dto.ConfigDTO> all(Map<String, Object> keycode);
	List<dto.ConfigDTO> searchall();
	int update1(ConfigDTO configDTO);
	
}
