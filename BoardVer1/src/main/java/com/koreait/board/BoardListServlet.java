package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	//get방식은 대부분 화면을 띄우는게 목적,jsp파일을 대부분 응답으로 한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data",Database.list);
		String jsp="/WEB-INF/jsp/list.jsp";
		RequestDispatcher rd= request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
