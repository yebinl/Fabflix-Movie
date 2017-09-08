package com.proj2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;

import com.proj2.models.*;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = (String)request.getSession().getAttribute("user");
		if(user==null)
		{
			response.sendRedirect("login.jsp");
		}
		String ccid = request.getParameter("ccid");
		String firstname = request.getParameter("first");
		String lastname = request.getParameter("last");
		String exp = request.getParameter("exp");
		checkoutprocess cp = new checkoutprocess();
		int result = checkoutprocess.NOPASS;
		
		result = cp.checkLegal(ccid,firstname,lastname,exp);
		
		if(result == checkoutprocess.PASS){
			ArrayList al = new ArrayList();
			int id = 0;
			al = (ArrayList)request.getSession().getAttribute("cart");
			id = Integer.parseInt(request.getSession().getAttribute("customid").toString());
			for(int i=0;i<al.size();i++){
				cartData cd = new cartData();
				cd=(cartData)al.get(i);
				for(int j = 0;j<cd.getNumber();j++){
					cp.storeinfo(cd.getMovieid(), id);
				}
				request.getSession().removeAttribute("cart");
			}
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else if(result == checkoutprocess.NOPASS || result == checkoutprocess.WRONGINFO){
			request.setAttribute("err", "1");
			request.getRequestDispatcher("checko.jsp").forward(request, response);
		}else{
			
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
