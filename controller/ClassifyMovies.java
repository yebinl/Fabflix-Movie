package com.proj2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.ResponseAPDU;

import com.proj2.models.*;
import java.util.*;

@WebServlet("/ClassifyMovies")
public class ClassifyMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int model = 1;
		String key = "a";
		int pagesize = 5;
		int pagenow = 1;
		int pagenum = 1;
		String aod = "tasc";
		
		try{
			key=request.getParameter("keyword");	
			model=Integer.parseInt(request.getParameter("model"));
			pagesize=Integer.parseInt(request.getParameter("pagesize"));
			pagenow=Integer.parseInt(request.getParameter("pagenow")); 
			if(pagenow<=0)
				pagenow=1;
			aod = request.getParameter("aod");
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("main.jsp");
		}
																												
		if(model==13 || model==12 || model==11 || model == 10 || model == 9){
			ArrayList al = new ArrayList();
			movies m = new movies();
			try{
				al = m.getmovies(pagenow, pagesize, model, key, aod);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(al.size()==1){
				movieData md = (movieData)al.get(0);
				response.sendRedirect("ShowOneMovie?movieid="+md.getMovieid());
			}else{
				pagenum = m.getpagenum(pagesize, model, key);
				request.setAttribute("resultset", al);
				request.setAttribute("pagenum", Integer.toString(pagenum));
				request.setAttribute("pagenow", Integer.toString(pagenow));
				request.setAttribute("model", Integer.toString(model));
				request.setAttribute("keyword", key);
				request.setAttribute("aod", aod);
				request.setAttribute("pagesize", Integer.toString(pagesize));
				request.getRequestDispatcher("movielist.jsp").forward(request, response);
			}
		}
		
		else if(model==15||model==16){				
		String command="";	
		if(key.equals("search")){
				String title = request.getParameter("title");
				String director = request.getParameter("director");
				String year = request.getParameter("year");
				String starname = request.getParameter("starname");
				int i = 0;
				
				String subcom ="";
				if(!(title==null || "".equals(title)))
				{
					command="movies.title like '%"+title+"%'";
					i = 1;
				}
				if(!(director==null || "".equals(director)))
				{
					if(i==0)
						command="movies.director like '%"+director+"%'";
					else
						command=command+" and movies.director like '%"+director+"%'";
				}
				if(!(year==null || "".equals(year)))
				{
					if(i==0)
						command="movies.year="+year;
					else
						command=command+" and movies.year="+year;
				}
				if(!(starname==null || "".equals(starname)))
				{
					String name[]=starname.split(" ");
					int num=name.length;
					if(num==1){
						subcom = "stars.id=stars_in_movies.star_id and movies.id=stars_in_movies.movie_id and (stars.first_name like '%"+name[0]+"%' or stars.last_name like '%"+name[0]+"%')";
					}else if (num ==2){
						subcom = "stars.id=stars_in_movies.star_id and movies.id=stars_in_movies.movie_id and (stars.first_name like '%"+name[0]+"%' and stars.last_name like '%"+name[1]+"%')"+"or (stars.first_name like '%"+name[1]+"%' and stars.last_name like '%"+name[0]+"%')";
					}else if (num>2){
						subcom = "stars.id=stars_in_movies.star_id and movies.id=stars_in_movies.movie_id and (stars.first_name like '%"+name[0]+"%' and stars.last_name like '%"+name[num-1]+"%')"+"or (stars.first_name like '%"+name[num-1]+"%' and stars.last_name like '%"+name[0]+"%')";
					}
					if(i==0)
						command=subcom;
					else
						command=command+" and "+subcom;
					model = 16;
				}
				request.getSession().setAttribute("search", command);
				key = "find";
			}
		else{
			command=(String)request.getSession().getAttribute("search");
		}
																										
			ArrayList al = new ArrayList();
			movies m = new movies();
			try{
				al = m.getmovies(pagenow, pagesize, model, command, aod);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			pagenum = m.getpagenum(pagesize, model, command);
			
			request.setAttribute("resultset", al);
			request.setAttribute("pagenum", Integer.toString(pagenum));
			request.setAttribute("pagenow", Integer.toString(pagenow));
			request.setAttribute("model", Integer.toString(model));
			request.setAttribute("keyword", key);
			request.setAttribute("aod", aod);
			request.setAttribute("pagesize", Integer.toString(pagesize));
			request.getRequestDispatcher("movielist.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
