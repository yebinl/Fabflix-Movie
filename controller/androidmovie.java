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
 * Servlet implementation class androidmovie
 */
@WebServlet("/androidmovie")
public class androidmovie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = "";
		int pagenow = 1;
		int pagenum = 1;
		ArrayList al = new ArrayList();
		String result = "";
		
		try{
			key=request.getParameter("keyword");	
			pagenow=Integer.parseInt(request.getParameter("pagenow")); 
			if(pagenow<=0)
				pagenow=1;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ajaxsearch as = new ajaxsearch();
		if(!key.equals("")){
			result = Integer.toString(as.androidpage(key.replace("\\", "\\\\").replace("\'","\\\'")))+"<1/>";
			al = as.android(key.replace("\\", "\\\\").replace("\'","\\\'"),pagenow);
			for(int i = 0;i < al.size();i++){
				androidData ad = new androidData();
				ad=(androidData)al.get(i);
				result = result+ad.getMovieid()+","+ad.getTitle()+","+ad.getBanner_url()+"<1/>";
			}
		}else{
			al = null;
			result="";
		}
		if(result.length()>=1)
			result = result.substring(0,(result.length()-4));
		response.getOutputStream().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
