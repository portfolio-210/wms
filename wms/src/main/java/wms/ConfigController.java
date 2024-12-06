package wms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.ConfigDTO;
import jakarta.annotation.Resource;
import service.ConfigService;

@ComponentScan(basePackages = {"DTO","service","serviceimp"})
@Controller
public class ConfigController {
	
			@Resource(name="config_dto")
			ConfigDTO cd;
			
			@Autowired
			ConfigService cs;
			
			@PostMapping("/config/config_main.do")
			public String search(@RequestParam("part1") String part1, @RequestParam("part2") String part2, @RequestParam("search") String search, 
                    Model m) {
				Map<String, String> keycode = new HashMap<>();
				keycode.put("part1",part1);
				keycode.put("part2",part2);
				keycode.put("search",search);
				List<ConfigDTO> all = cs.all(keycode);
				
				
				m.addAttribute("members", all); // 'm'을 사용하여 모델에 추가
				return null;
			}
			
			@GetMapping("/config/config_main.do")
		    public String showMembers(Model m) {
		        List<ConfigDTO> members = cs.searchall(); // 전체 멤버 가져오기
		        m.addAttribute("members", members); // 모델에 추가
		        return null; // JSP 페이지 이름 반환
		    }
			

       
        
    

}
