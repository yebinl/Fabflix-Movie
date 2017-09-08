package com.proj2.models;

import java.sql.*;
import java.util.*;

public class ajaxsearch {
	private Statement statement = null;
	private ResultSet resultset = null;
	private Connection connection = null;
		
	
	public ArrayList ajax (String key){	
		String command=" ";
		int c = 0;
		ArrayList al = new ArrayList();
		command = "SELECT title FROM moviesft WHERE MATCH (title) AGAINST ('"; 
		int count = 0;
		String keys[]=key.split(" ");
		for(int i=0;i<keys.length;i++){
			if(!keys[i].equals("")){
				if(i == (keys.length - 1))
					command = command+" +"+keys[i]+"*";
				else
					command = command+" +"+keys[i]+"*";
			}
		}
		command = command+"' IN BOOLEAN MODE)";
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(command);
			while(resultset.next()){
				String k = resultset.getString(1);
				al.add(k);
				c++;
			}
			if(c == 0)
				al.add("No Such Film");
		}catch(Exception e){
			e.printStackTrace();
		}
		return al;

	}

	public ArrayList android (String key,int pagenow){	
		String command=" ";
		ArrayList al = new ArrayList();
		command = "SELECT id,title,banner_url FROM moviesft WHERE MATCH (title) AGAINST ('"; 
		String keys[]=key.split(" ");
		for(int i=0;i<keys.length;i++){
			if(!keys[i].equals("")){
				if(i == (keys.length - 1))
					command = command+" +"+keys[i]+"*";
				else
					command = command+" +"+keys[i]+"*";
			}
		}
		command = command+"' IN BOOLEAN MODE) limit "+8*(pagenow-1)+",8;";
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(command);
			while(resultset.next()){
				androidData ad = new androidData();
				ad.setMovieid(resultset.getInt(1));
				ad.setTitle(resultset.getString(2));
				ad.setBanner_url(resultset.getString(3));
				al.add(ad);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return al;
	}
	public int androidpage (String key){	
		String command=" ";
		int pagenum = 0;
		int rownum = 0;
		command = "SELECT count(*) FROM moviesft WHERE MATCH (title) AGAINST ('"; 
		String keys[]=key.split(" ");
		for(int i=0;i<keys.length;i++){
			if(!keys[i].equals("")){
				if(i == (keys.length - 1))
					command = command+" +"+keys[i]+"*";
				else
					command = command+" +"+keys[i]+"*";
			}
		}
		command = command+"' IN BOOLEAN MODE);";
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(command);
			while(resultset.next()){
				rownum=resultset.getInt(1);
			}
			if((rownum%8)==0){
				pagenum=rownum/8;
			}else{
				pagenum=rownum/8+1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pagenum;
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
