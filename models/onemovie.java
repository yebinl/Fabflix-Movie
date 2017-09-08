package com.proj2.models;

import java.sql.*;
import java.util.*;

public class onemovie {
	
	private Statement statement = null;
	private ResultSet resultset = null;
	private Connection connection = null;
	
	public ArrayList getonemovie(int movieid){	

	ArrayList al = new ArrayList();	
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from movies where id=\""+movieid+"\";");
			if(resultset.next()){
				movieData md = new movieData();
				md.setMovieid(resultset.getInt(1));
				md.setTitle(resultset.getString(2));
				md.setYear(resultset.getInt(3));
				md.setDirector(resultset.getString(4));
				md.setBanner_url(resultset.getString(5));
				md.setTrailer_url(resultset.getString(6));
				al.add(md);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeresource();
		}
		return al;
	}
	
	public void closeresource(){
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
