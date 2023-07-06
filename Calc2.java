package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8"); // UTF-8로 요청을 읽어옴
		resp.setCharacterEncoding("UTF-8"); // UTF-8로 응답함
		resp.setContentType("text/html; charset=UTF-8"); // 브라우저에게 html 문서이고 UTF-8로 해석하라 알림
		
		ServletContext application = req.getServletContext(); // 애플리케이션
		HttpSession session = req.getSession(); // 세션 
		Cookie[] cookies = req.getCookies(); // 쿠키는 배열로 읽어옴
		
		PrintWriter out = resp.getWriter(); // 출력 스트림 
	
		String v_ = req.getParameter("v"); // 기본값을 위한 임시 변수
		String op = req.getParameter("operator"); // "
	
		int v = 0;
		
		if(v_!=null && !v_.equals("")) { // 가져온 값이 null과 공백이 아닐 시, 임시 변수 값을 v에 삽입
			v = Integer.parseInt(v_);
		}
		
		if(op.equals("=")) { //계산 로직
			
			int x = 0;
			for(Cookie c : cookies) { // for-each로 쿠키 배열 값을 읽어 삽입했던 쿠키의 key값을 찾아 x에 삽입
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			String operator="";
//			int x = (Integer)session.getAttribute("value");
//			int x = (Integer)application.getAttribute("value");
			int y = v;
//			String operator = (String)application.getAttribute("op");
//			String operator = (String)session.getAttribute("op");
			for(Cookie c : cookies) { // "
				if(c.getName().equals("operator")) {
					operator = c.getValue();
					break;
				}
			}
			
			int result = 0;
		
			if(operator.equals("+")) { //
				result = x + y;
			}else {
				result = x - y;
			}
			out.println(result);
		}else{
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
			
			Cookie valueCookie = new Cookie("value",String.valueOf(v));
			//쿠키 심는건 무조건 스트링
			Cookie opCookie = new Cookie("operator",op);
			valueCookie.setPath("/"); //이 경로에서만 브라우저가 쿠키를 가져옴
			valueCookie.setMaxAge(60*60*24*7);  //쿠키 만료 시간
			opCookie.setPath("/");
			resp.addCookie(valueCookie); //쿠키 삽입
			resp.addCookie(opCookie);
			
		}
		
	}
}
