package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String jsp, HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException{
		String jsp2=String.format("/WEB-INF/view/%s.jsp", jsp);
		rq.getRequestDispatcher(jsp2).forward(rq, rs);
	}
	
	public static int strToInt(String str) {
		try {
			return Integer.parseInt(str);
		}catch(Exception e) {
			return 0;
		}
		
	}
	
	public static int getParamInt(String key,HttpServletRequest req) {
		return strToInt(req.getParameter(key));
	}
}
