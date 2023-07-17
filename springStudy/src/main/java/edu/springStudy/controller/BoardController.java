package edu.springStudy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/board")
@Controller
public class BoardController {
	
	@RequestMapping(value="/list.do")
	public String list(Model model) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("첫번째 게시물입니다.");
		list.add("두번째 게시물입니다.");
		list.add("세번째 게시물입니다.");
		list.add("네번째 게시물입니다.");
		
		/*
		 위 list 데이터를 board/list.jsp로 포워드하여 테이블 형태로 출력하세요.
		 */
		model.addAttribute("list", list);
		
		return "board/list";
		//prefix -> WEB-INF/views/board/list.jsp
		//suffix -> jsp
	}
	
	@RequestMapping(value="/view.do")
	public String view() {
		
		
		return "board/view";
	}
	
	
}
