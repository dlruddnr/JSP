package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod3")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard=request.getParameter("iboard");
		int intIboard=Integer.parseInt(iboard);
		System.out.println(iboard);
		BoardVO data=BoardDAO.selBoard(intIboard);
		System.out.println(data.getIboard());
		System.out.println(data.getTitle());
		System.out.println(data.getCtnt());
		request.setAttribute("data", data);
		String jsp="/WEB-INF/view/mod3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard=request.getParameter("iboard");
		int intIboard=Integer.parseInt(iboard);
		String title=request.getParameter("title");
		String ctnt=request.getParameter("ctnt");
		System.out.println("제목:"+title);
		System.out.println("내용:"+ctnt);
		BoardVO vo=new BoardVO();
		vo.setIboard(intIboard);
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		BoardDAO.updBoard(vo);
		//System.out.println("영향받은 행"+a);
		response.sendRedirect("/detail?iboard="+iboard);
	}

}
