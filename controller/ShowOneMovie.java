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
 * Servlet implementation class ShowOneMovie
 */
@WebServlet("/ShowOneMovie")
public class ShowOneMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int movieid = 0;
		try{
			movieid=Integer.parseInt(request.getParameter("movieid"));
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("main.jsp");
		}
		ArrayList al = new ArrayList();
		onemovie om = new onemovie();
		al = om.getonemovie(movieid);
		
		
		movieData md = (movieData)al.get(0);
		
		request.setAttribute("resultset",al);
		
		request.getRequestDispatcher("onemovie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
