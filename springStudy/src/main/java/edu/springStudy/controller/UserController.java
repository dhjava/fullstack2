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
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public void login(UserVO vo, HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		
		UserVO loginVO = userService.selectUserByLogin(vo);
		
		/*
		 각 로그인 여부 상황에 맞게 사용자에게 경고창을 띄워 안내하는 기능을 구현하세요
		 */
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = res.getWriter();
		
		if(loginVO != null) {
			// login할 회원이 데이터베이스에 존재
			System.out.println("회원존재");
			
			session.setAttribute("login", loginVO);
			
			pw.append("<script>alert('로그인이 되었습니다.');loaction.href='"+req.getContextPath()+"/';</script>");
			
			
		}else {
			// login할 회원이 데이터베이스에 존재X
			System.out.println("회원존재X");
			
			pw.append("<script>alert('존재하지 않는 아이디나 비밀번호입니다.');loaction.href='"+req.getContextPath()+"/';</script>");
			
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
		
		pw.append("<script>alert('로그아웃 되었습니다.');" + "location.href='" + req.getContextPath()+"/';</script>");
		}catch(Exception e) {
			e.printStackTrace();
			pw.append("<script>alert('로그아웃 시 예외가 발생했습니다.');" + "location.href='" + req.getContextPath()+"/';</script>");
		}
		pw.flush();
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public void join(UserVO vo, HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		
		UserVO joinVO = userService.selectUserByJoin(vo);
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = res.getWriter();
		
		if(joinVO > 0) {
			// login할 회원이 데이터베이스에 존재
			System.out.println("회원가입 완료");
			
			session.setAttribute("join", joinVO);
			
			pw.append("<script>alert('가입을 축하드립니다.');loaction.href='"+req.getContextPath()+"/';</script>");
			
			
		}else {
			// login할 회원이 데이터베이스에 존재X
			System.out.println("회원가입 실패");
			
			pw.append("<script>alert('가입에 실패했습니다. 다시 입력해주세요.');loaction.href='"+req.getContextPath()+"/';</script>");
			
		}
		
		pw.flush();
	}
}
