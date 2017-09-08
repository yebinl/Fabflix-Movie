package com.proj2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj2.models.UsersProcessing;
import com.proj2.models.VerifyUtils;

/**
 * Servlet implementation class SignInEmployee
 */
@WebServlet("/SignInEmployee")
public class SignInEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String u = request.getParameter("user");
		String p = request.getParameter("pswd");
		UsersProcessing up = new UsersProcessing();
		int result = UsersProcessing.NOPASS;
		result = up.checkLegal2(u, p);
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		boolean valid = VerifyUtils.verify(gRecaptchaResponse);
		if (valid) {
			if(result == UsersProcessing.LEGALUSER){
				request.getSession().setAttribute("emp", u);
				request.getRequestDispatcher("dash.jsp").forward(request, response);
			}else if(result == UsersProcessing.WRONGPASSWORD){
				request.setAttribute("err", "2");
				request.getRequestDispatcher("dashlog.jsp").forward(request, response);
			}else if(result == UsersProcessing.NOSUCHUSER){
				request.setAttribute("err", "1");
				request.getRequestDispatcher("dashlog.jsp").forward(request, response);
			}else{
				request.setAttribute("err", "1");
				request.getRequestDispatcher("dashlog.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("err", "3");
			request.getRequestDispatcher("dashlog.jsp").forward(request, response);
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
