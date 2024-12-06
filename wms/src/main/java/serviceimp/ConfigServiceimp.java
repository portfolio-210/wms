package serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.ConfigDTO;
import service.*;


@Service
public class ConfigServiceimp implements ConfigService {

		@Autowired
		wms.mapper.ConfigMapper cm;
	
	
		@Override
		public List<ConfigDTO> all(Map<String, Object> keycode) {
				
			List<ConfigDTO> all = cm.all(keycode);
			
			return all;
		}
		
		@Override
		public List<ConfigDTO> searchall() {
		
		return cm.searchall();
		}
		
		
		@Override
		public int update1(ConfigDTO configDTO) {
		return cm.update1(configDTO);
		}
		
		
}
