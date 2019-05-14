package demo.torah.ware.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.torah.ware.paging.PageMaker;
import demo.torah.ware.paging.Paging;
import demo.torah.ware.service.BoardService;
import demo.torah.ware.util.CommonUtil;

@Controller
public class BoardController {
	
	@Autowired public BoardService boardService;
	@Autowired public CommonUtil commonUtil;

	@GetMapping("/board/list")
	public String boardList(Model model, @ModelAttribute("paging") Paging paging) {
		
		model.addAttribute("list", this.boardService.boardList(paging.getPage(), paging));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPaging(paging);
		pageMaker.setTotalCount(this.boardService.boardTotalCnt());
		
		model.addAttribute("pageMaker", pageMaker);  // 게시판 하단의 페이징 관련, 이전페이지, 페이지 링크 , 다음 페이지
		
		return "board/list";
	}
	
	@GetMapping("/board/regist")
	public String boardRegist(Model model) {
		
		 Map<String, Object> member = (Map<String, Object>) commonUtil.getSession().getAttribute("member");
		
		model.addAttribute("member", member);
		return "board/regist";
	}
	
	@PostMapping("/board/registExec")
	public String boardRegistExec(@RequestParam Map<String,Object> paramMap) {
		
		Map<String, Object> member = (Map<String, Object>) commonUtil.getSession().getAttribute("member");
		 
		paramMap.put("regUserId", member.get("userIdx"));
		
		int result = boardService.boardRegist(paramMap);
	
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/board/editExec")
	public String boardEditExec(@RequestParam Map<String,Object> paramMap) {
		
		Map<String, Object> member = (Map<String, Object>) commonUtil.getSession().getAttribute("member");
		
		paramMap.put("updUserId", member.get("userIdx"));
		
		int result = boardService.boardEdit(paramMap);
		
		
		return "redirect:/board/view/"+paramMap.get("boardIdx");
	}
	
	
	@GetMapping("/board/view/{boardIdx}")
	public String boardView(Model model, @PathVariable String boardIdx) {
		Map<String, Object> board = boardService.boardView(boardIdx);
		
		model.addAttribute("board", board);
		return "board/view";
	}
	
	@GetMapping("/board/edit/{boardIdx}")
	public String boardEdit(Model model, @PathVariable String boardIdx) {
		
		Map<String, Object> board = boardService.boardView(boardIdx);
		
		model.addAttribute("board", board);
		return "board/edit";
	}
	
	@PostMapping("/board/delete/{boardIdx}")
	public String boardDelete(@PathVariable String boardIdx) {
		boardService.boardDelete(boardIdx);
		return "redirect:/board/list";
	}
}
