package edu.springStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.springStudy.service.BoardService;
import edu.springStudy.vo.BoardVO;

@RequestMapping(value="/ajax")
@Controller
public class AjaxController {
	
	@Autowired
	BoardService boardService;

	@RequestMapping(value="/sample.do")
	public String sample() {
		return "ajax/sample";
	}
	
	@RequestMapping(value="/stringCall.do")
	@ResponseBody
	public String stringCall() {
		return "hihihihi";
	}
	
	@RequestMapping(value="/jsonCall.do", method=RequestMethod.POST)
	@ResponseBody
	public BoardVO jsonCall(int bidx) {
		
		System.out.println("bidx::::"+bidx);
		
		BoardVO vo = new BoardVO();
		vo.setTitle("ajax 테스트 데이터입니다.");
		vo.setId("oh1234");
		vo.setBody("ajax로 데이터 insert합니다.");
		
		boardService.insert(vo);
		
		return vo;
	}
	
	@RequestMapping(value="/findBoard.do")
	@ResponseBody
	public BoardVO findBoard(int bidx) {
		return boardService.selectOneByBidx(bidx);
	}
	
	
}











