package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie[] cookies = req.getCookies(); // 쿠키는 배열로 읽어옴
	
		String value = req.getParameter("value"); // 기본값을 위한 임시 변수
		String operator = req.getParameter("operator"); // "
		String dot = req.getParameter("dot");
		
		String exp ="";
		if(cookies != null) {
			for(Cookie c : cookies) { 
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		
		if(operator!=null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(operator!=null && operator.equals("C")) {
			exp = "";
		}
		else {
			exp = exp + ((value == null)?"":value);
			exp = exp + ((operator == null)?"":operator);
			exp = exp + ((dot == null)?"":dot);
		}
		
			Cookie expCookie = new Cookie("exp", exp);
			if(operator!=null && operator.equals("C")) {
				expCookie.setMaxAge(0);
			}
			resp.addCookie(expCookie);
			resp.sendRedirect("calcpage");
		
	}
}
