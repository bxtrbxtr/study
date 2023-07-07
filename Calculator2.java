package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculator2")
public class Calculator2 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			expCookie.setPath("/calculator2");
			resp.addCookie(expCookie);
			resp.sendRedirect("calculator2"); //sendRedirect는 자기 자신을 호출해도 get요청을 의미함 그러니 doGet함수 호출
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // UTF-8로 요청을 읽어옴
		resp.setCharacterEncoding("UTF-8"); // UTF-8로 응답함
		resp.setContentType("text/html; charset=UTF-8"); // 브라우저에게 html 문서이고 UTF-8로 해석하라 알림
		
		PrintWriter out = resp.getWriter();
		
		Cookie[] cookies = req.getCookies();
		String exp ="0";
		
		if(cookies != null) {
			for(Cookie c : cookies) { 
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("<style>");
		out.println("input{");
		out.println("width: 50px; height: 50px;");
		out.println("}");
		out.println(".output{");
		out.println("height:50px; background: #e9e9e9;");
		out.println("font-size: 24px;");
		out.println("font-weight: bold;");
		out.println("text-align:right; ");
		out.println("padding-right: 10px;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method=\"post\">"); //요청을 하는 페이지가 같으면 action을 안써도 됨
		out.println("<table>");
		out.println("<tr>");
		out.printf("<td colspan=\"4\" class=\"output\">%s</td>", exp);
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type=\"submit\" value=\"CE\" name=\"operator\"/></td>");
		out.println("<td><input type=\"submit\" value=\"C\" name=\"operator\"/></td>");
		out.println("<td><input type=\"submit\" value=\"BS\" name=\"operator\"/></td>");
		out.println("<td><input type=\"submit\" value=\"/\" name=\"operator\"/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type=\"submit\" value=\"7\" name=\"value\"/></td>");
		out.println("<td><input type=\"submit\" value=\"8\" name=\"value\"/></td>");
		out.println("<td><input type=\"submit\" value=\"9\" name=\"value\"/></td>");
		out.println("<td><input type=\"submit\" value=\"*\" name=\"operator\"/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type=\"submit\" value=\"4\" name=\"value\"/></td>");
		out.println("<td><input type=\"submit\" value=\"5\" name=\"value\"/></td>");
		out.println("<td><input type=\"submit\" value=\"6\" name=\"value\"/></td>");
		out.println("<td><input type=\"submit\" value=\"-\" name=\"operator\"/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type=\"submit\" value=\"1\" name=\"value\"/></td>");
		out.println("<td><input type=\"submit\" value=\"2\" name=\"value\"/></td>");
		out.println("<td><input type=\"submit\" value=\"3\" name=\"value\"/></td>");
		out.println("<td><input type=\"submit\" value=\"+\" name=\"operator\"/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td></td>");
		out.println("<td><input type=\"submit\" value=\"0\" name=\"value\"></td>");
		out.println("<td><input type=\"submit\" value=\".\" name=\"dot\"/></td>");
		out.println("<td><input type=\"submit\" value=\"=\" name=\"operator\"/></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
}