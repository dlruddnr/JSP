package com.koreait.board2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no=request.getParameter("no");
		int intNo=Integer.parseInt(no);
		BoardVO vo=(BoardVO)Database.db.get(intNo);
		request.setAttribute("data", vo);
		String jsp="/WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no=request.getParameter("no");
		String ctnt=request.getParameter("ctnt");
		String title=request.getParameter("title");
		int intNo=Integer.parseInt(no);
		BoardVO vo=(BoardVO)Database.db.get(intNo);
		vo.setCtnt(ctnt);
		vo.setCtnt(title);
		response.sendRedirect("/detail?no="+no);
	}

}
