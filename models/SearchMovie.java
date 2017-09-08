package com.proj2.models;

import java.sql.*;

public class SearchMovie {
	private Statement statement = null;
	private ResultSet resultset = null;
	private Connection connection = null;
	
	public ResultSet SearchByStarf (String u){	
		String command=" ";
		command="select movies.* from movies,stars,stars_in_movies where stars.id=stars_in_movies.star_id and stars_in_movies.movie_id=movies.id and stars.first_name like \"%"+u+"%\";";
		
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(command);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultset;
	}
	
	public ResultSet SearchByStarl (String u){	
		String command=" ";
		command="select movies.* from movies,stars,stars_in_movies where stars.id=stars_in_movies.star_id and stars_in_movies.movie_id=movies.id and stars.last_name like \"%"+u+"%\";";
		
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(command);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultset;
	}
	
	public ResultSet SearchByMovie (String u){	
		String command=" ";
		command="select movies.* from movies,stars,stars_in_movies where stars.id=stars_in_movies.star_id and stars_in_movies.movie_id=movies.id and movies.title like \"%"+u+"%\";";
		
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(command);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultset;
	}
	
	public ResultSet SearchByDirector (String u){	
		String command=" ";
		command="select movies.* from movies,stars,stars_in_movies where stars.id=stars_in_movies.star_id and stars_in_movies.movie_id=movies.id and movies.director like \"%"+u+"%\";";
		
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(command);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultset;
	}
	
	public ResultSet SearchByYear (String u){	
		String command=" ";
		command="select movies.* from movies,stars,stars_in_movies where stars.id=stars_in_movies.star_id and stars_in_movies.movie_id=movies.id and movies.year like \"%"+u+"%\";";
		
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(command);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultset;
	}
	
	public ResultSet SearchBy2 (String u1,String u2){	
		String command=" ";
		command="select movies.* from movies,stars,stars_in_movies where stars.id=stars_in_movies.star_id and stars_in_movies.movie_id=movies.id and stars.first_name like \"%"+u1+"%\" and and stars.last_name like \"%"+u2+"%\";";
		
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(command);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultset;
	}
	
	
	
	
	public ResultSet SearchStars (String u){	
		String command=" ";
		command="select stars.first_name,stars.last_name from movies,stars,stars_in_movies where stars.id=stars_in_movies.star_id and stars_in_movies.movie_id=movies.id and movies.id = \""+u+"\"";
		
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(command);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultset;
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
