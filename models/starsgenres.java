package com.proj2.models;

import java.util.*;
import java.sql.*;

public class starsgenres {
	
	private Statement statement = null;
	private ResultSet resultset = null;
	private Connection connection = null;
	
	public ArrayList getStars(int movieid){
		ArrayList al = new ArrayList();
		String command = "select stars.first_name,stars.last_name,stars.id,stars.photo_url from stars,stars_in_movies where stars.id=stars_in_movies.star_id and stars_in_movies.movie_id='"+movieid+"';";
		try{
			connection=new connDB().getConnection();
			statement=connection.createStatement();
			resultset = statement.executeQuery(command);
			while(resultset.next()){
				starname sn = new starname(); 
				sn.setFirst(resultset.getString(1));
				sn.setLast(resultset.getString(2));
				sn.setStarid(resultset.getInt(3));
				sn.setPhoto(resultset.getString(4));
				al.add(sn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closers();
		}
		return al;
	}
	
	public ArrayList getGenres(int movieid){
		ArrayList al = new ArrayList();
		String command = "select genres.name from genres,genres_in_movies where genres.id=genres_in_movies.genre_id and genres_in_movies.movie_id='"+movieid+"';";
		try{
			connection=new connDB().getConnection();
			statement=connection.createStatement();
			resultset = statement.executeQuery(command);
			while(resultset.next()){
				genrename gn = new genrename();
				gn.setGenre(resultset.getString(1));	
				al.add(gn);
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
