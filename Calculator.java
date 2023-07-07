package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculator")
public class Calculator extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if(req.getMethod().equals("GET")) { //무조건 대문자로 사용해야 함
			System.out.println("GET요청이 왔습니다.");
		} else if(req.getMethod().equals("POST")) {
			System.out.println("POST요청이 왔습니다.");
		}
		
		super.service(req, resp); //부모의 doGet, doPost를 호출 
								  //service 함수를 사용하는 상태에서 super.service(req, resp);를 적지 않으면 doGet, doPost를 따로 호출하지 않음 
		
		//공통적으로 처리할 부분이 있으면 service 메소드를 쓰고 각자 특화된 처리가 필요하면 doGet,doPost
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 메소드가 호출 되었습니다."); //service를 통해 호출되는 함수
														 //service를 사용하지 않을때도 자동적으로 service를 통해 호출됨
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드가 호출 되었습니다."); //service를 통해 호출되는 함수
														//service를 사용하지 않을때도 자동적으로 service를 통해 호출됨
	}
	
}