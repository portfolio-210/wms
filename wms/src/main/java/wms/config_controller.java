package wms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DTO.config_DTO;
import jakarta.annotation.Resource;
import service.config_service;

@ComponentScan(basePackages = {"DTO","service","serviceimp"})
@Controller
public class config_controller {
	
			@Resource(name="config_dto")
			config_DTO cd;
			
			@Autowired
			config_service cs;
			
			@PostMapping("config/config_main.do")
			public String search(@RequestParam("part1") String part1, @RequestParam("part2") String part2, @RequestParam("search") String search, 
                    Model m) {
				Map<String, String> keycode = new HashMap<>();
				keycode.put("part1",part1);
				keycode.put("part2",part2);
				keycode.put("search",search);
				List<config_DTO> all = cs.all(keycode);
				
				
				m.addAttribute("members", all); // 'm'을 사용하여 모델에 추가
				
				return null;
			}

       
        
    

}
