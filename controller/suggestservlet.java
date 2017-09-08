package com.proj2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj2.models.*;
import java.util.*;

/**
 * Servlet implementation class suggestservlet
 */
@WebServlet("/suggestservlet")
public class suggestservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suggestservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		ArrayList al = new ArrayList();
		String result = "";
		
		ajaxsearch as = new ajaxsearch();
		if(!key.equals("")){
			
			al = as.ajax(key.replace("\\", "\\\\").replace("\'","\\\'"));
			for(int i = 0;i < al.size();i++){
				result = result+al.get(i).toString()+",";
			}
		}else{
			al = null;
			result="";
		}
		
		
		if(result.length()>=1)
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
