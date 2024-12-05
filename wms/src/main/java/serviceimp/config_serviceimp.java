package serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.config_DTO;
import service.*;


@Service
public class config_serviceimp implements config_service {

		@Autowired
		wms.mapper.config_mapper config_mapper;
	
	
		@Override
		public List<config_DTO> all(Map<String, String> keycode) {
				
			List<config_DTO> all = config_mapper.all(keycode);
			
			return all;
		}
		
		@Override
		public List<config_DTO> searchall() {
		
		return config_mapper.searchall();
		}
		
}
