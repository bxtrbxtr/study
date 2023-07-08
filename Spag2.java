package com.newlecture.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/spag2")
public class Spag2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "";
		if(Integer.parseInt(req.getParameter("cnt"))%2==1){ 
			result = "홀수";
		} else{ 
			result = "짝수";
		}
		req.setAttribute("result", result); // request에 result 결과값을 키와 밸류로 저장
		//redirect = 현재 작업한 내용과 상관없이 새로운 요청
		//forward = 현재 작업한 내용을 이어갈 수 있도록 공유
		RequestDispatcher dispatcher 
			=req.getRequestDispatcher("spag2.jsp"); // 경로
		dispatcher.forward(req, resp);	// 포워딩함
	}
}
