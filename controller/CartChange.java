package com.proj2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj2.models.cartData;

/**
 * Servlet implementation class CartChange
 */
@WebServlet("/CartChange")
public class CartChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod=request.getParameter("cod");
		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList al = (ArrayList)request.getSession().getAttribute("cart");
		if(cod.equals("c")){
			int num =Integer.parseInt(request.getParameter("num"));
			for(int i=0;i<al.size();i++){
				cartData cd = new cartData();
				cd = (cartData)al.get(i);
				if(cd.getMovieid()==id){
					cd.setNumber(num);
					al.remove(i);
					al.add(cd);
					break;
				}
			}
		}else if(cod.equals("d")){
			for(int i=0;i<al.size();i++){
				cartData cd = new cartData();
				cd = (cartData)al.get(i);
				if(cd.getMovieid()==id){
					al.remove(i);
					break;
				}
			}
		}

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
