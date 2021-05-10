package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;


@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String unm=request.getParameter("unm");
		int gender=MyUtils.getParamInt("gender",request);
		UserVO vo=new UserVO();
		vo.setUid(id);
		vo.setUpw(pw);
		vo.setGender(gender);
		vo.setUnm(unm);
		
		UserDAO.joinUser(vo);
		response.sendRedirect("login");
	}

}