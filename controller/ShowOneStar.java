package com.proj2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proj2.models.*;

/**
 * Servlet implementation class ShowOneStar
 */
@WebServlet("/ShowOneStar")
public class ShowOneStar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int starid = 0;
		try{
			starid=Integer.parseInt(request.getParameter("starid"));
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("main.jsp");
		}
		ArrayList al = new ArrayList();
		onestar os = new onestar();
		al = os.getonestar(starid);		
				
		request.setAttribute("resultset",al);
		
		request.getRequestDispatcher("onestar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
