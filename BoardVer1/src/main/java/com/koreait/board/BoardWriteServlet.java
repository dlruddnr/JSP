package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp="/WEB-INF/jsp/write.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String ctnt= request.getParameter("ctnt");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		Database.list.add(vo);
		response.sendRedirect("/list"); // get방식으로 list로 이동
	}

}
//클라이언트(브라우저)에서 값이 서버쪽으로 넘어옴
//값 빼는는거는 request.getParameter(키값)
//서블릿에서 jsp로 값 전달하는 방법
//-값 넣는 방법
//request.setArrtibute(키값,value값)
//-값 뺴는 방법
//request.getAttribute(키갑)