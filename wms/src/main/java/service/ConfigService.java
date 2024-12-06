package service;

import java.util.List;
import java.util.Map;

public interface ConfigService {

	List<dto.ConfigDTO> all(Map<String, String> keycode);
	List<dto.ConfigDTO> searchall();
}
