package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet("/comment")
public class BoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard=request.getParameter("iboard");
		request.setAttribute("data",iboard);
		String jsp="/WEB-INF/jsp/comment.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard=request.getParameter("iboard");
		System.out.println("aaaaa");
		int intIboard=Integer.parseInt(iboard);
		String tcnt=request.getParameter("tcnt");
		BoardVO vo=new BoardVO();
		vo.setIboard(intIboard);
		vo.setTcnt(tcnt);
		BoardDAO.insertDbCome(vo);
		BoardVO data=BoardDAO.selOne(intIboard);
		List<BoardVO> list=BoardDAO.selComeList(intIboard);
		request.setAttribute("list",list);
		request.setAttribute("data",data);
		System.out.println("확인"+list.get(0).getTitle());
		String jsp="/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
