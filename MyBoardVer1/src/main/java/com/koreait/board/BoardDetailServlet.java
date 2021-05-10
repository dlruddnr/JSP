package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard=request.getParameter("iboard");
		int intIboard=Integer.parseInt(iboard);
		BoardVO vo=BoardDAO.selOne(intIboard);
		List<BoardVO> list=BoardDAO.selComeList(intIboard);
		System.out.println(vo.getIboard());
		System.out.println(vo.getTitle());
		request.setAttribute("data", vo);
		request.setAttribute("list", list);
		String jsp="/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
