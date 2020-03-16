package com.bit.emaillist.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emaillist.dao.EmaillistDao;
import com.bit.emaillist.dao.EmaillistDaoimpl;
import com.bit.emaillist.vo.EmailVO;

//@webServlet 어노테이션을 이용한 서블릿 매핑
//@WebServlet("/el") -> urlPattern만 필요할 경우
@WebServlet(name="EmaillistServlet", urlPatterns= "/el")
public class EmaillistServlet extends BaseServlet {
	//model 2에서의 SERVLET은 CONTROLLER의 역할 수행
	//model 1의 jsp가 요청 처리, 로직 처리를 위한 모두 담당했던 역할 을 대신 수행
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//action parameter 를 이용한 조건 분기
		String action =req.getParameter("a");
		
		if("form".equals(action)) {
			//a=form일경우 
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/form.jsp");
			rd.forward(req, resp);
		}else {
		//list 페이지 처리
		EmaillistDao dao = new EmaillistDaoimpl(dbuser, dbpass);
		List<EmailVO> list = dao.getList();
		//사용자로부터 받은 요청 객체 + 로직을 수행하고 난 후의 model1을 싣고 jsp로 제어권ㅇ을 넘긴다
		req.setAttribute("list", list);
		RequestDispatcher rd =getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/index.jsp");
		//요청과 응답의 제어권을 jsp로 전달
		rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("a");
		if("insert".equals(action)) {
			//a hidden field가 insert일 경우의 처리
			String lastName = req.getParameter("last_name");
			String firstName = req.getParameter("first_name");
			String email = req.getParameter("email");	
			
			EmailVO vo= new EmailVO(lastName, firstName, email);
			EmaillistDao dao = new EmaillistDaoimpl(dbuser, dbpass);
			
			boolean isSuccess = dao.insert(vo);
			if(isSuccess) {
				System.out.println("INSERT SUCCESS");
			}else {
				System.err.println("INSERT FAILED");
			}
			resp.sendRedirect(req.getContextPath()+"/el");
		}else if("delete".equals(action)) {
			//a hidden field가 delete일경우 처리
			String no = req.getParameter("no");
			EmaillistDao dao = new EmaillistDaoimpl(dbuser, dbpass);
			boolean isSuccess =dao.delete(Long.valueOf(no));
			if(isSuccess) {
				System.out.println("DELETE SUCCESS");
				
			}else {
				System.err.println("DELETE FAILED");
			}
			resp.sendRedirect(req.getContextPath()+"/el");
		}
		else {
			resp.sendError(405);
		}
	
	}
	
}
