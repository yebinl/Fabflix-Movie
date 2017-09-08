package com.proj2.models;

import java.util.*;
import java.sql.*;

public class insertion {
	private Statement statement = null;
	private ResultSet resultset = null;
	private Connection connection = null;
	
	
	public ArrayList insertion(String title, String year, String director, String banner, String trailer, String fn, String ln, String genres){
		ArrayList al = new ArrayList();
		String command = "";
			command = "call add_movie('"+title+"',"+year+",'"+director+"','"+banner+"','"+trailer+"','"+fn+"','"+ln+"','"+genres+"');";	
		try{
			connection=new connDB().getConnection2();
			statement=connection.createStatement();
			statement.execute(command);							
			do{
				resultset = statement.getResultSet();
				while(resultset.next()){
					String a = resultset.getString(1);					
					al.add(a);
				}
			}while(statement.getMoreResults() == true);
		}catch(Exception e){
			al.add(e.toString());
			e.printStackTrace();
		}finally{
			this.closers();
		}
		return al;
	}
	
	public ArrayList insertion(String fn, String ln, String dob, String photo){
		ArrayList al = new ArrayList();
		String command = "";
		command = "call add_star('"+fn+"','"+ln+"','"+dob+"','"+photo+"');";								
		try{
			connection=new connDB().getConnection2();
			statement=connection.createStatement();
			resultset = statement.executeQuery(command);
			resultset.next();
			String a = resultset.getString(1);
			al.add(a);
		}catch(Exception e){
			al.add(e.toString());
			e.printStackTrace();
		}finally{
			this.closers();
		}
		return al;
	}
	
	public ArrayList meta(){
		ArrayList al = new ArrayList();
		ArrayList table = new ArrayList();
		String command1 = "show tables;";
		String command2 = "show columns from ";
		try{
			connection=new connDB().getConnection();
			statement=connection.createStatement();
			resultset = statement.executeQuery(command1);
			while(resultset.next()){
				String a = resultset.getString(1);
				table.add(a);
			}
			for(int i = 0;i < table.size();i++){
				String col = (String)table.get(i);
				al.add("Table Name: "+col);
				resultset = statement.executeQuery(command2+col+";");
				while(resultset.next()){
					String b = resultset.getString(1);
					String c = resultset.getString(2);
					al.add("Column: "+b+", Type: "+c);
				}
				al.add("<---->");
			}
		}catch(Exception e){
			al.add(e.toString());
			e.printStackTrace();
		}finally{
			this.closers();
		}
		return al;
	}
	
	public void closers(){
		try{
			if(resultset != null){
				resultset.close();
				resultset = null;
			}
			if(statement != null){
				statement.close();
				statement = null;
			}
			if(connection != null){
				connection.close();
				connection = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
