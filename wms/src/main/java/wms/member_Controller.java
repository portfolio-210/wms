package wms;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DTO.member_DTO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.member_service;

@ComponentScan(basePackages = "DTO,service,serviceimp")
@Controller
public class member_Controller implements security {
	@Resource(name="memberdto")
	member_DTO dto;
	
	@Autowired
	private member_service ms;
	
	String output = null;
	javascript js = new javascript();
	
	
	
	// 회원가입
	@PostMapping("/joinok.do")
	public String joinok(@ModelAttribute("join") member_DTO dto,Model m)throws Exception {	
	
		// mspot 값이 "N"이라면 "본사"로 변경
	    if ("N".equals(dto.getMspot())) {
	        dto.setMspot("본사");
	    }
		//md5
		String userpw = dto.getMpass();	
		StringBuilder repass = secode(userpw);
		dto.setMpass(repass.toString());
		
		try {
			int result = ms.member_join(dto);
				if(result > 0) {
					this.output=this.js.ok("정상적으로 회원가입이 완료 되었습니다.", "./wms_login.jsp");
				}	
				else {
					this.output=this.js.no("회원가입에 실패하였습니다. 다시 시도해 주세요.");
				}
		} 
		catch (Exception e) {
			this.output=this.js.no("데이터 오류로 인하여 가입이 되지 않습니다. 다시 시도해 주세요");
		}
		m.addAttribute("output", output);
		return "output";
	}
	

	// 아이디 중복체크
	@CrossOrigin("*")
	@PostMapping("/idcheck.do")
	public String idcheck(@RequestParam("mid") String mid, 
			HttpServletResponse res) throws Exception {	
				
		PrintWriter pw = res.getWriter();
		String result ="ok";
		if(mid.equals("")) {
		}
		else {
			result = ms.search_id(mid);
			System.out.println("중복체크"+result);
			pw.print(result);
			pw.close();
		}
		return null;
	}

	
	// 로그인 
    @PostMapping("/loginok.do")
    public String loginok(@RequestParam("mid") String mid, 
    						@RequestParam("mpass") String mpass,
    						@RequestParam(value = "local_id", required = false) String local_id,
    						HttpServletRequest req,
    						Model m) {
        
        List<member_DTO> member_dto = ms.login_id(mid);
        
        if (member_dto.size() == 0) { 
        } else {
        try {
            StringBuilder repass = secode(mpass);  // 로그인 pw 보안
	            if (member_dto.get(0).getMpass().equals(repass.toString())) {   
	                HttpSession session = req.getSession();
	                session.setAttribute("id", member_dto.get(0).getMid());
	                session.setAttribute("name", member_dto.get(0).getMname());
	                session.setAttribute("email", member_dto.get(0).getMemail());      
	                session.setAttribute("mpart", member_dto.get(0).getMpart());      
	                session.setAttribute("mspot", member_dto.get(0).getMspot());      
	                
	                if (local_id == null) {
	                    	this.output=this.js.script("window.localStorage.removeItem('mid')");
	                } else {
	                    	this.output=this.js.script("window.localStorage.setItem('mid', '" + mid + "')");
	                }
	                		this.output=this.js.ok("로그인되었습니다. 환영합니다","./wms_main.do");
	            } 
	            else {  
	                	this.output=this.js.no("아이디 및 패스워드를 다시 확인해주세요.");
	            }
        } catch (Exception e) {
            this.output=this.js.no("데이터 오류로 인하여 다시 시도해 주세요.");
        	}
    }
        m.addAttribute("output", this.output);
        return "output"; 
    }
	
    
    // 메인페이지
    @GetMapping("/wms_main.do")
    public String main(Model m, HttpServletRequest req) {    
       
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");
        String mpart = (String) session.getAttribute("mpart");
        String mspot = (String) session.getAttribute("mspot");
        //System.out.println("세션 id="+id);
        //System.out.println("세션 name="+name);
        //System.out.println("세션 email="+email);

        m.addAttribute("id", id);
        m.addAttribute("name", name);
        m.addAttribute("email", email);

        return "wms_main"; 
    }
    
    
	//로그아웃
	@GetMapping("/logout.do")
	public String logout(HttpServletRequest req, 
						Model m) {

		HttpSession session = req.getSession();
		session.removeAttribute("id");
		session.removeAttribute("name");
		session.removeAttribute("email");
		session.removeAttribute("mpart");
		session.removeAttribute("mspot");
		
		try {
			if (session.getAttribute("id") == null) {
				this.output = this.js.ok("로그아웃 되었습니다","./wms_login.jsp");
			} else {
			    this.output = this.js.no("로그인 실패! 다시시도해주세요.");
			}
		} catch (Exception e) {
				this.output = this.js.no("시스템 서버 오류로 인하여 다시 시도해주세요.");
		} 
		m.addAttribute("output", this.output);
		return "output";
	}	
}//end
