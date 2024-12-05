package service;

import java.util.List;
import java.util.Map;

public interface config_service {

	List<DTO.config_DTO> all(Map<String, String> keycode);
}
