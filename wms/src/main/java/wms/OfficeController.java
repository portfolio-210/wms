package wms;

import java.io.PrintWriter;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.OfficeDTO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import service.OfficeService;

@ComponentScan(basePackages = {"wms.dto","wms.service","wms.serviceimp"})
@Controller
public class OfficeController {
	PrintWriter pw = null;

	@Resource(name="OfficeDTO")
	OfficeDTO odto;
	
	@Autowired
	OfficeService os;

//officeMain.jsp Controller
	//전체 지점 현황 페이지 출력
	@GetMapping("/office/officeMain.do")
	public String office_main(Model m) {
		List<OfficeDTO> all = os.office_list();
		m.addAttribute("all", all);
		m.addAttribute("total", all.size());
		return null;
	}
	
	//검색 지점 현황 페이지 출력
	@PostMapping("/office/officeMain.do")
	public String search_ok(@RequestParam("search") String search, Model m) {
		List<OfficeDTO> searchAll = os.search_office(search);
		m.addAttribute("all", searchAll);
		return null;
	}
	
	//지점 삭제
	@GetMapping("/office/office_delete.do")
	public String office_delete(@RequestParam("oidx")String oidx, @RequestParam("key")String key, ServletResponse res) {
		res.setContentType("text/html;charset=utf-8");
		try {
			this.pw = res.getWriter();
			
			Decoder decoder = Base64.getDecoder();
			byte[] keycheck = decoder.decode(key);
			String keycode = new String(keycheck);
			if(keycode.equals("wms.test")) {
				byte[] oidxcheck = decoder.decode(oidx);
				String no = new String(oidxcheck);
				int result = os.delete_office(no);
				if(result > 0) {
					this.pw.print("<script>"
							+ "alert('해당 지점이 삭제 되었습니다.');"
							+ "location.href='./officeMain.do';"
							+ "</script>");
				}
				else {
					this.pw.print("<script>"
							+ "alert('해당 게시물의 정보가 올바르지 않습니다.');"
							+ "location.href='./officeMain.do';"
							+ "</script>");
				}
			}
			else {
				this.pw.print("<script>"
						+ "alert('해당 페이지에 접근이 잘 못 되었습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
		} catch (Exception e) {
			System.out.println("삭제 실패");
			System.out.println(e.getMessage());
		} finally {
			this.pw.close();
		}
		return null;
	}
	
	
//officeInsert.jsp Controller
	//등록할 지점 중복 검사
	@CrossOrigin("*")	//AJAX CORS 방지
	@PostMapping("/office/officenameCheck.do")
	public String oname_check(@RequestParam("officename") String officename, HttpServletResponse res) {
		res.setContentType("text/html;charset=utf-8");
		try {
			this.pw = res.getWriter();
			String result = "";
			
			if(officename.equals("")) {
				System.out.println("빈 값");
			}
			else {
				result = os.check_officename(officename);
				this.pw.print(result);
			}
		} catch (Exception e) {
			this.pw.print("<script>"
					+ "alert('서버가 불안정합니다. 잠시 후에 다시 시도 해주세요.');"
					+ "history.go(-1);"
					+ "</script>");
		} finally {
			this.pw.close();
		}
		return null;
	}
	
	
	
}
