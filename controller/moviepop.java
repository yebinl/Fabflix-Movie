package com.proj2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj2.models.*;

/**
 * Servlet implementation class moviepop
 */
@WebServlet("/moviepop")
public class moviepop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String result = "";
		
		ArrayList al = new ArrayList();
		ArrayList al2 = new ArrayList();
		ArrayList al3 = new ArrayList();
		onemovie om = new onemovie();
		starsgenres sg = new starsgenres();
		al = om.getonemovie(id);
		al2 = sg.getGenres(id);
		al3 = sg.getStars(id);
		movieData md = (movieData)al.get(0);
		result = result+Integer.toString(md.getMovieid())+","+md.getTitle()+","+Integer.toString(md.getYear())+","+md.getDirector()+",";
		for(int i = 0;i < al2.size();i++){
			genrename gn = (genrename)al2.get(i);
			result = result+gn.getGenre()+"`";
		}
		result = result.substring(0,(result.length()-1));
		result = result+",";
		for(int i = 0;i < al3.size();i++){
			starname sn = (starname)al3.get(i);
			result = result+sn.getFirst()+" "+sn.getLast()+"`";
		}
		result = result.substring(0,(result.length()-1));
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
