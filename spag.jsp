<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(Integer.parseInt(request.getParameter("cnt"))%2==1){ %> <!-- 이런 방식의 코드는 출력과 코드가 뒤섞여 알아보기 힘듬 -->
	홀수입니다.
	<%} else{ %>
	짝수입니다.
	<%} %>
</body>
</html>