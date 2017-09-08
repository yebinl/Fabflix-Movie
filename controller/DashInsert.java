package com.proj2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj2.models.*;
import java.util.*;

/**
 * Servlet implementation class DashInsert
 */
@WebServlet("/DashInsert")
public class DashInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mod = 0;
		ArrayList al = new ArrayList();
		String title = "";
		String year = "";
		String director = "";
		String banner = "";
		String trailer = "";
		String fn = "";
		String ln = "";
		String genres = "";
		String dob= "";
		String photo= "";
		
		try{
			mod=Integer.parseInt(request.getParameter("mod"));	
		}catch(Exception e){
			e.printStackTrace();
		}
		if(mod == 1){
			insertion ist = new insertion();
			fn=request.getParameter("fn");
			ln=request.getParameter("ln");
			dob=request.getParameter("dob");
			photo=request.getParameter("purl");
			if(ln==null||ln.equals("")) 
				ln=" ";
																						
				al=ist.insertion(fn, ln, dob, photo);
			
		}else if(mod == 2){
			insertion ist = new insertion();
			title=request.getParameter("title");
			year=request.getParameter("year");
			director=request.getParameter("dirc");
			banner=request.getParameter("banner");
			trailer=request.getParameter("trailer");
			fn=request.getParameter("fn");
			ln=request.getParameter("ln");
			genres=request.getParameter("genres");
			if(ln==null||ln.equals("")) 
				ln=" ";

				al=ist.insertion(title, year, director, banner, trailer, fn, ln, genres);

		}else if(mod == 3){
			insertion ist = new insertion();
			al = ist.meta();
		}

		request.setAttribute("result", al);

		request.getRequestDispatcher("dashshow.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
