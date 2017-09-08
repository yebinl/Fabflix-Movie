package com.proj2.models;

import java.util.*;
import java.sql.*;

public class starsmovie {
	
	private Statement statement = null;
	private ResultSet resultset = null;
	private Connection connection = null;
	
	public ArrayList getStarsmoive	(int starid){
		ArrayList al = new ArrayList();
		String command = "select movies.title,movies.year,movies.id,movies.banner_url from movies,stars_in_movies where movies.id=stars_in_movies.movie_id and stars_in_movies.star_id='"+starid+"';";
		try{
			connection=new connDB().getConnection();
			statement=connection.createStatement();
			resultset = statement.executeQuery(command);
			while(resultset.next()){
				moviety mty = new moviety(); 
				mty.setMovietitle(resultset.getString(1));
				mty.setMovieyear(resultset.getInt(2));
				mty.setMovieid(resultset.getInt(3));
				mty.setBanner(resultset.getString(4));
				al.add(mty);
			}
		}catch(Exception e){
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
