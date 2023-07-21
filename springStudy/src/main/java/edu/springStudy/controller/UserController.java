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
		 �� �α��� ���� ��Ȳ�� �°� ����ڿ��� ���â�� ��� �ȳ��ϴ� ����� �����ϼ���
		  
		 */		
		/*
		 
		 �Խñ� ������������ ���� �� ���� ��쿡�� �Խñ� ����,������ư ���̰� �����ϼ���
		 
		 */
		if(loginVO != null) {
			//login�� ȸ���� �����ͺ��̽��� ����
			System.out.println("ȸ������");
			
			session.setAttribute("login", loginVO);
			pw.append("<script>alert('�α��ο� �����߽��ϴ�.');location.href='"+req.getContextPath()+"/';</script>");
			
		}else {
			//login�� ȸ���� �����ͺ��̽��� ���� X
			System.out.println("ȸ������ X");
			pw.append("<script>alert('�α��ο� �����߽��ϴ�.');location.href='"+req.getContextPath()+"/user/login.do';</script>");
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
			
			pw.append("<script>alert('�α׾ƿ� �Ǿ����ϴ�.');"
						+"location.href='"
					    +req.getContextPath()+"/';</script>");
			
		}catch(Exception e) {
			e.printStackTrace();
			pw.append("<script>alert('�α׾ƿ��� ���ܰ� �߻��߽��ϴ�.');"
					+"location.href='"
				    +req.getContextPath()+"/';</script>");
		}
		
		pw.flush();
		
	}
	
	
	
}
