package edu.springStudy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.springStudy.service.BoardService;
import edu.springStudy.vo.BoardVO;

@RequestMapping(value="/board")
@Controller
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/list.do")
	public String list(Model model) {
		
/*		List<String> list = new ArrayList<String>();
		
		list.add("첫번째 게시물입니다.");
		list.add("두번째 게시물입니다.");
		list.add("세번째 게시물입니다.");
		list.add("네번째 게시물입니다.");
*/
		
		/*
		 위 list 데이터를 board/list.jsp로 포워드하여 테이블 형태로 출력하세요.
		 */
		
		List<BoardVO> list = boardService.list();
		
		model.addAttribute("list", list);
		
		return "board/list";
		//prefix -> WEB-INF/views/board/list.jsp
		//suffix -> jsp
	}
	
	@RequestMapping(value="/view.do")
	public String view() {
		
		System.out.println("1111");
		return "board/view";
	}
	
	@RequestMapping(value="/write.do",method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
/*	
	@RequestMapping(value="/write.do",method=RequestMethod.POST)
	public String write(@RequestParam("title")String t, String writer, String body) {
		
		
		return "redirect:list.do"; // board/list.do
		// return "redirect:/board/list.do"
	}*/
	
	@RequestMapping(value="/write.do",method=RequestMethod.POST)
	public String write(BoardVO boardVO) {
		
		System.out.println(boardVO.toString());
		return "redirect:list.do"; // board/list.do
		// return "redirect:/board/list.do"
	}
	
	
}
