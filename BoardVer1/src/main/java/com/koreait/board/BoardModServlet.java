package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		System.out.println(no);
		request.setAttribute("data",Database.list.get(Integer.parseInt(no)));
		RequestDispatcher dis=request.getRequestDispatcher("WEB-INF/jsp/mod.jsp");
		dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no=request.getParameter("no");
		String title=request.getParameter("title");
		String ctnt=request.getParameter("ctnt");
		System.out.println(no);
		System.out.println(title);
		System.out.println(ctnt);
		int intNO=Integer.parseInt(no);
		BoardVO vo=Database.list.get(intNO);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		response.sendRedirect("/detail?no=" + no);
	}

}
