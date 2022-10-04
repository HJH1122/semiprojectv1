package hjh.spring.mvc.controller;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hjh.spring.mvc.service.BoardService;
import hjh.spring.mvc.vo.BoardVO;

@Controller
public class BoardController {

	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	
	
	@Autowired
	private BoardService bsrv;
	
	@GetMapping("/list")
	public String list(Model m) {
		
		m.addAttribute("bdlist", bsrv.readBoard());
		
		return "board/list";
		
	}
	@GetMapping("/view")
	public String view() {
		return "board/view";
		
	}
	//로그인 안했다면 -> redirect:/login
	//로그인 했다면 -> board/write
	@GetMapping("/write")
	public String write(HttpSession sess) {
		String returnPage = "board/write";
		
		if(sess.getAttribute("m")== null)
			returnPage = "redirect:/login";
		
		
		return returnPage;
		
	}
	@PostMapping("/write")
	public String writeok(BoardVO bvo) {
		
		bsrv.newBoard(bvo);
		
		return "redirect:/list";
		
	}
	
}
