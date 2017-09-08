package com.proj2.models;

import java.sql.*;
import java.util.*;
import java.text.DateFormat;

public class onestar {
	private Statement statement = null;
	private ResultSet resultset = null;
	private Connection connection = null;
	
	public ArrayList getonestar(int starid){	

		ArrayList al = new ArrayList();	
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from stars where id=\""+starid+"\";");
			if(resultset.next()){
				starData sd = new starData();
				sd.setStarid(resultset.getInt(1));
				sd.setFirstname(resultset.getString(2));
				sd.setLastname(resultset.getString(3));
				sd.setDob(resultset.getDate(4));
				sd.setPhotourl(resultset.getString(5));
				al.add(sd);
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
