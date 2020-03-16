<%@page import="com.bit.emaillist.dao.EmaillistDaoimpl"%>
<%@page import="com.bit.emaillist.dao.EmaillistDao"%>
<%@page import="com.bit.emaillist.vo.EmailVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--이 페이지는 가능 수행용 페이지 --%>
    <%
    //dao를 이용해서 insert 수행
    //인코딩 세팅
    request.setCharacterEncoding("UTF-8");
    //서블릿 초기화 파라미터에서 DB정보 확인
    ServletContext context = getServletContext();
    String dbuser = context.getInitParameter("dbuser");
    String dbpass = context.getInitParameter("dbpass");
    //
    String lastName = request.getParameter("last_name");
    String firstName = request.getParameter("first_name");
    String email= request.getParameter("email");
    //vo생성
    EmailVO vo = new EmailVO(lastName, firstName, email);
    EmaillistDao dao = new EmaillistDaoimpl(dbuser, dbpass);
    boolean isSuccess = dao.insert(vo);
    
    
    //성공하면 다시 index.jsp로 redirect
    if(isSuccess){
    	response.sendRedirect(request.getContextPath());
    }else{
    response.sendRedirect(request.getContextPath());
    }
    %>
