package edu.springStudy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.springStudy.service.BoardService;
import edu.springStudy.service.UserService;
import edu.springStudy.vo.UserVO;

@RequestMapping(value="/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public void login(UserVO vo,HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		
		UserVO loginVO = userService.selectUserByLogin(vo);
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = res.getWriter();
		
		/*
		 각 로그인 여부 상황에 맞게 사용자에게 경고창을 띄워 안내하는 기능을 구현하세요
		  
		 */
		
		/*
		 
		 게시글 상세페이지에서 내가 쓴 글인 경우에만 게시글 수정,삭제버튼 보이게 수정하세요
		 
		 */
		if(loginVO != null) {
			//login할 회원이 데이터베이스에 존재
			System.out.println("회원존재");
			
			session.setAttribute("login", loginVO);
			pw.append("<script>alert('로그인에 성공했습니다.');location.href='"+req.getContextPath()+"/';</script>");
			
		}else {
			//login할 회원이 데이터베이스에 존재 X
			System.out.println("회원존재 X");
			pw.append("<script>alert('로그인에 실패했습니다.');location.href='"+req.getContextPath()+"/user/login.do';</script>");
		}
		
		pw.flush();
	}
	
	@RequestMapping(value="/logout.do")
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = res.getWriter();
		
		try {
			HttpSession session = req.getSession();
			session.invalidate();
			session.setAttribute("key", null);
			pw.append("<script>alert('로그아웃 되었습니다.');"
						+"location.href='"
					    +req.getContextPath()+"/';</script>");
			
		}catch(Exception e) {
			e.printStackTrace();
			pw.append("<script>alert('로그아웃시 예외가 발생했습니다.');"
					+"location.href='"
				    +req.getContextPath()+"/';</script>");
		}
		
		pw.flush();
		
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value="/checkId.do", method=RequestMethod.POST)
	@ResponseBody
	public String checkId(String id) {
		int result = userService.selectCntById(id);
		
		return result+"";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(UserVO vo, String ageStr) {
		
		// 화면에서 age가 null로 넘어오는 경우 vo에 매핑되지 않기 때문에
		if(ageStr != null && !ageStr.equals("")) {
			vo.setAge(Integer.parseInt(ageStr));
		}
		
		int result = userService.insert(vo);
		
		if(result>0) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		return "redirect:login.do";
	}
}
