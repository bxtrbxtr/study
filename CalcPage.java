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

@WebServlet("/calcpage")
public class CalcPage extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
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
		out.println("<form action=\"calc3\" method=\"post\">");
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
