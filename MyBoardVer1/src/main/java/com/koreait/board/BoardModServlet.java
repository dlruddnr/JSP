package com.koreait.board;

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
		String iboard=request.getParameter("iboard");
		int intIboard=Integer.parseInt(iboard);
		BoardVO vo=BoardDAO.selOne(intIboard);
		request.setAttribute("data", vo);
		String jsp="/WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard=request.getParameter("iboard");
		int intIboard=Integer.parseInt(iboard);
		String title=request.getParameter("title");
		String tcnt=request.getParameter("tcnt");
		BoardVO vo= new BoardVO();
		vo.setIboard(intIboard);
		vo.setTcnt(tcnt);
		vo.setTitle(title);
		BoardDAO.updateDb(vo);
		request.setAttribute("data", vo);
		String jsp="/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
