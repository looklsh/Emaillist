<%@page import="com.bit.emaillist.vo.EmailVO"%>
<%@page import="com.bit.emaillist.dao.EmaillistDaoimpl"%>
<%@page import="com.bit.emaillist.dao.EmaillistDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//context 초기화 파라미터 불러오기
ServletContext context = getServletContext();
String dbuser = context.getInitParameter("dbuser");
String dbpass = context.getInitParameter("dbpass");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일링 리스트</title>
</head>
<body>
	<h1>메일링 리스트</h1>
	<h3>Model 2 버전</h3>
<% 
/*
EmaillistDao dao = new EmaillistDaoimpl(dbuser,dbpass);
List<EmailVO>list= dao.getList();
*/
List<EmailVO> list = (List<EmailVO>)request.getAttribute("list");
for(EmailVO vo:list){
%>	
	<!-- 리스트출력 위해 루프 -->
	<table border="1">
		<tr>
			<th>성</th>
			<td><%=vo.getLastName() %></td>
		
		</tr>
		<tr>
			<th>이름</th>
			<td><%=vo.getFirstName() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=vo.getEmail() %></td>
		</tr>		
		<!-- 삭제버튼 -->
		<tr>
			<td colspan="2">
				<form method="post"
					action="<%= request.getContextPath() %>/el">
					<input type="hidden" name="a" value="delete">
					<input type="hidden" name="no" value="<%=vo.getNo() %>">
				<button type="submit">삭제</button>		
					</form>
			</td>
		</tr>
	</table>
	<% } %>
	<!-- 작성 폼으로 링크 -->
	<a href="<%=request.getContextPath() %>/el?a=form">이메일 등록</a>
</body>
</html>