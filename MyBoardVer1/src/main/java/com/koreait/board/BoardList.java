package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet("/list")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO> list=BoardDAO.getListDb();
		request.setAttribute("list",list);
		String jsp="/WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String ctnt=request.getParameter("tcnt");
		BoardVO vo= new BoardVO();
		vo.setTcnt(ctnt);
		vo.setTitle(title);
		BoardDAO.insertDb(vo);
		response.sendRedirect("/list");
	}

}
