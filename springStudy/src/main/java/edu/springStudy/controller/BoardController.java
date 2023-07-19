package edu.springStudy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	public String view(int bidx, Model model) {
		
		//1. 화면에서 넘어오는 bidx 추출
		
		//2. 추출한 bidx를 이용하여 일치하는 데이터 조회
		BoardVO vo = boardService.selectOneByBidx(bidx);
		
		//3. 2번 데이터를 화면으로 전달
		model.addAttribute("vo", vo);
		
		return "board/view";
	}
	
	// 글 쓰기
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
	
	// 글 수정
	
/*	@RequestMapping(value="/modify.do",method=RequestMethod.GET)
	public String modify() {
		return "board/modify";
	}
	
	@RequestMapping(value="/modify.do",method=RequestMethod.POST)
	public String modify(BoardVO boardVO) {
		
		System.out.println(boardVO.toString());
		return "redirect:list.do"; // board/list.do
		// return "redirect:/board/list.do"
	}
*/	
	@RequestMapping(value="/modify.do",method=RequestMethod.GET)
	public String modify(int bidx, Model model) {
		
		BoardVO vo = boardService.selectOneByBidx(bidx);
		model.addAttribute("vo", vo);
		
		return "board/modify";
	}
	
	@RequestMapping(value="/modify.do",method=RequestMethod.POST)
	public String modify(BoardVO vo) {
		
		int result = boardService.update(vo);
		
		if(result>0) {
			// 수정 성공
			return "redirect:view.do?bidx="+vo.getBidx();
		}else {
			// 수정 실패
			
			return "redirect:list.do";
		}
		
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public void delete(int bidx,HttpServletResponse res) throws IOException {
		
		int result = boardService.delete(bidx);
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = res.getWriter();
		
		if(result>0) {
			pw.append("<script>alert('삭제되었습니다.');loaction.href='list.do';</script>");
		}else {
			pw.append("<script>alert('삭제되지 않았습니다.');loaction.href='list.do';</script>");
		}
		
		pw.flush();
	}
}
