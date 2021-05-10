package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;


@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String upw=request.getParameter("upw");
		
		UserVO vo= new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		int result=UserDAO.loginUser(vo);
		switch(result) {
		case 1:
			response.sendRedirect("/board/list");
			break;
		case 2:
			//doGet(request,response);
			//response.sendRedirect("login");
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			
		}
	}

}
