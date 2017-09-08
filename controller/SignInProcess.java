package com.proj2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proj2.models.*;



@WebServlet("/SignInProcess")
public class SignInProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String u = request.getParameter("user");
		String p = request.getParameter("pswd");
		UsersProcessing up = new UsersProcessing();
		int result = UsersProcessing.NOPASS;
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		boolean valid = VerifyUtils.verify(gRecaptchaResponse);
		if (valid) {
			result = up.checkLegal(u, p);
			
			if(result == UsersProcessing.LEGALUSER){
				request.getSession().setAttribute("user", u);
				request.getSession().setAttribute("customid", up.idsearch(u));
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else if(result == UsersProcessing.WRONGPASSWORD){
				request.setAttribute("err", "1");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else if(result == UsersProcessing.NOSUCHUSER){
				request.setAttribute("err", "2");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				
			}
		}else{
			request.setAttribute("err", "3");
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
