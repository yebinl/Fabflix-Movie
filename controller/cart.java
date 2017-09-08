package com.proj2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.proj2.models.*;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = (String)request.getParameter("title");					System.out.println(id+" "+title);
		int flag = -1;
		cart ca = new cart();
		cartData cd = new cartData();
		cd.setMovieid(id);
		cd.setMovie(title);
		cd.setNumber(1);
		
		ArrayList al = null;
		al = (ArrayList)request.getSession().getAttribute("cart");
		if(al==null){
			al = new ArrayList();
			al.add(cd);
		}else{
			for(int i=0;i<al.size();i++){
				cartData cd2 = new cartData();
				cd2 = (cartData)al.get(i);
				if(cd2.getMovieid()==cd.getMovieid()){
					cd.setNumber(cd2.getNumber()+1);
					flag = i;
					break;
				}
			}
			if(flag == -1)
				al.add(cd);	
			else{
				al.remove(flag);
				al.add(cd);
			}
		}
		request.getSession().setAttribute("cart", al);
		response.sendRedirect("shopcart.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
