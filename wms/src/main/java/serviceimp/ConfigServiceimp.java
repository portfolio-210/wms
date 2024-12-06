package serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.ConfigDTO;
import service.*;


@Service
public class ConfigServiceimp implements ConfigService {

		@Autowired
		wms.mapper.ConfigMapper ConfigMapper;
	
	
		@Override
		public List<ConfigDTO> all(Map<String, String> keycode) {
				
			List<ConfigDTO> all = ConfigMapper.all(keycode);
			
			return all;
		}
		
		@Override
		public List<ConfigDTO> searchall() {
		
		return ConfigMapper.searchall();
		}
		
}
