<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String result = "";
if(Integer.parseInt(request.getParameter("cnt"))%2==1){ 
	result = "홀수";
} else{ 
	result = "짝수";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%if(Integer.parseInt(request.getParameter("cnt"))%2==1){ %> //코드 블럭은 위쪽으로 몰아넣고 아래는 출력만 담당할 수 있게 코드 분리
	홀수입니다.														  //model = 요청에 따른 가공된 데이터(result), view = 출력 화면(html), controller= 입력과 제어(코드 로직)
	<%} else{ %>
	짝수입니다.
	<%} %> --%>
	<%=result %>입니다.
</body>
</html>