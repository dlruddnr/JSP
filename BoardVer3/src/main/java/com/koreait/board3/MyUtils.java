package com.koreait.board3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp2=String.format("/WEB-INF/view/%s.jsp",jsp);
		request.getRequestDispatcher(jsp).forward(request, response);
		
	
	}
	
	public static int parseStringToInt(String num) {
		try {
			return Integer.parseInt(num);
		}catch(Exception e) {
			return 0;
		}
		
	}
	
	public static int getParamInt(String iboard, HttpServletRequest request) {
		String str=request.getParameter(iboard);
		return parseStringToInt(str);
	}
}


//MyUtils.openJSP();