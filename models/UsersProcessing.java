package com.proj2.models;

import java.sql.*;

public class UsersProcessing {
	
	public static final int NOPASS= 0;
	public static final int LEGALUSER= 11;
	public static final int WRONGPASSWORD= 12;
	public static final int NOSUCHUSER= 13;
	
	private Statement statement = null;
	private ResultSet resultset = null;
	private Connection connection = null;
	
	public int checkLegal (String username,String password){	
		//check if a user is legal user
		int result = NOPASS;
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select password from customers where email=\""+username+"\";");
			if(resultset.next()){
				//user exist, check the password
				if(resultset.getString(1).equals(password)){
					//legal user
					result = LEGALUSER;
				}else{
					//wrong password
					result = WRONGPASSWORD;
				}
			}else{
				//user does not exist
				result = NOSUCHUSER;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeresource();
		}
		return result;
	}
	
	public int checkLegal2 (String username,String password){	
		//check if a user is legal user
		int result = NOPASS;
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select password from employees where email=\""+username+"\";");
			if(resultset.next()){
				//user exist, check the password
				if(resultset.getString(1).equals(password)){
					//legal user
					result = LEGALUSER;
				}else{
					//wrong password
					result = WRONGPASSWORD;
				}
			}else{
				//user does not exist
				result = NOSUCHUSER;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeresource();
		}
		return result;
	}
	
	public int idsearch (String username){
		int id = 0;
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select id from customers where email=\""+username+"\";");
			if(resultset.next()){
				id = resultset.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeresource();
		}
		return id;
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
