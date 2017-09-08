package com.proj2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proj2.models.*;


/**
 * Servlet implementation class androidsignin
 */
@WebServlet("/androidsignin")
public class androidsignin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u = request.getParameter("user");
		String p = request.getParameter("pswd");
		UsersProcessing up = new UsersProcessing();
		int result = UsersProcessing.NOPASS;
		result = up.checkLegal(u, p);
		response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
		if(result == UsersProcessing.LEGALUSER){
			response.getOutputStream().print("Legal");
		}else if(result == UsersProcessing.WRONGPASSWORD){
			response.getOutputStream().print("Wrong Password");
		}else if(result == UsersProcessing.NOSUCHUSER){
			response.getOutputStream().print("No such user");
		}else{
			response.getOutputStream().print("Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
