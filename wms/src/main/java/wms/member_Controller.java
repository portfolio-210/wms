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
	
	PrintWriter pw = null;
	
	
	// 회원가입
	@PostMapping("/joinok.do")
	public String joinok(@ModelAttribute("join") member_DTO dto,
						HttpServletResponse res)throws Exception {	

		PrintWriter pw = null;	
		res.setContentType("text/html;characterset=utf8");
	
		// mspot 값이 "N"이라면 "본사"로 변경
	    if ("N".equals(dto.getMspot())) {
	        dto.setMspot("본사");
	    }
		
		
		//md5 part
		String userpw = dto.getMpass();	
		StringBuilder repass = secode(userpw);
		dto.setMpass(repass.toString());
		
		try {
			int result = ms.member_join(dto);
			pw = res.getWriter();
				if(result > 0) {
				pw.print("<script>"
						+ "alert('정상적으로 회원가입이 완료 되었습니다.');"
						+ "location.href='/index.jsp';"
						+ "</script>");
				}	
				else {
					pw.print("<script>"
							+ "alert('회원가입에 실패하였습니다. 다시 시도해 주세요.')"
							+ "history.go(-1);"
							+ "</script>");
				}
		} 
		catch (Exception e) {
			pw = res.getWriter();
			pw.print("<script>"
					+ "alert('데이터 오류로 인하여 가입이 되지 않습니다. 다시 시도해 주세요');"
					+ "history.go(-1);"
					+ "</script>");
		}
		finally {
			pw.close();
		}
		return null;
	}
	

	// 아이디 중복체크
	@CrossOrigin("*")
	@PostMapping("/idcheck.do")
	public String idcheck(@RequestParam("mid") String mid, HttpServletResponse res) throws Exception {	
				
		PrintWriter pw = res.getWriter();
		String result ="ok";
		if(mid.equals("")) {
			System.out.println("값이 없음");
		}
		else {
			// DB의 값을 검토하는 구간
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
    						ServletResponse res, 
    						HttpServletRequest req) {
    	
        res.setContentType("text/html;charset=utf-8"); 
        
        List<member_DTO> member_dto = ms.login_id(mid);
        
        if (member_dto.size() == 0) { 
            System.out.println("회원정보가 없음");
        } else {
            System.out.println(member_dto.get(0).getMid());

            
            
            try {
            	
            	// 로그인 pw 보안
                this.pw = res.getWriter();
                StringBuilder repass = secode(mpass);  

                if (member_dto.get(0).getMpass().equals(repass.toString())) {   
      	
                	/*
                	// 세션 설정
                    HttpSession session = req.getSession();
                    session.setAttribute("id", member_dto.get(0).getMid());
                    session.setAttribute("name", member_dto.get(0).getMname());
                    session.setAttribute("email", member_dto.get(0).getMemail());                    
                    */
                    // 로컬스토리지 처리
                    if (local_id == null) {
                        this.pw.print("<script>"
                        				+ "window.localStorage.removeItem('mid');"
                        				+ "</script>");
                    } else {
                        this.pw.print("<script>"
                        				+ "window.localStorage.setItem('mid', '" + mid + "');"
                        				+ "</script>");
                    }
                    
                    this.pw.print("<script>"
                    		+ "alert('로그인되었습니다. 환영합니다');"
                    		+ "location.href='./admin_main.jsp';"
                    		+ "</script>");

                } else {    // 로그인 실패
                    this.pw.print("<script>"
                    		+ "alert('아이디 및 패스워드를 다시 확인해주세요.');"
                    		+ "history.go(-1);"
                    		+ "</script>");
                }

            } catch (Exception e) {
                this.pw.print("<script>"
                		+ "alert('데이터 오류로 인하여 다시 시도해 주세요.');"
                		+ "history.go(-1);"
                		+ "</script>");
            }
        }
        return null; 
    }
	
	
    // 메인페이지
    @GetMapping("/admin_main.do")
    public String main(Model m, HttpServletRequest req) {    
        // 세션에서 값 가져오기
        HttpSession session = req.getSession();
        
        // 세션에 저장된 로그인 정보 가져오기
        String id = (String) session.getAttribute("id");
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");

        // 모델에 데이터 추가
        m.addAttribute("id", id);
        m.addAttribute("name", name);
        m.addAttribute("email", email);

        return "./admin_main.jsp"; // JSP나 Thymeleaf 템플릿을 반환
    }
	
	
	
	
}//
