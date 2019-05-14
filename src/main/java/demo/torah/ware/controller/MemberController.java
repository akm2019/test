package demo.torah.ware.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.torah.ware.service.MemberService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/login")
	public String login(Model model, @RequestParam Map<String, Object> paramMap) {
		
		model.addAttribute("message", paramMap.get("message"));
		return "member/login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		session.invalidate();
		
		return "redirect:/login";
	}
	
	@PostMapping("/loginExec")
	public String loginExec(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, Model model) {
		
		Map<String, Object> map = memberService.memberLogin(paramMap);
		
		if(map != null) {
			
	 
			HttpSession session = request.getSession(true);
			session.setAttribute("member", map);
			
			return "redirect:/board/list";
		}else {
			return "redirect:/login?message="+"없어";
		}
		
	}
	
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/member/joinExec")
	public String joinExec(@RequestParam Map<String, Object> paramMap) {
		
		System.out.println("@@@@@@@@@@@@@ "+ paramMap.get("userId"));
		
		memberService.memberRegist(paramMap);
		
		
		return "redirect:/login";
	}
}
