package com.proj2.models;

import java.sql.*;
import java.text.*;
import java.util.Date;

public class checkoutprocess {
	
	public static final int NOPASS= 0;
	public static final int PASS= 11;
	public static final int WRONGINFO= 12;
	
	private Statement statement = null;
	private ResultSet resultset = null;
	private Connection connection = null;
	
	public int checkLegal (String ccid,String firstname,String lastname,String exp){	
		
		int result = NOPASS;
		try{
			connection = new connDB().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select count(*) from creditcards where id='"+ccid+"' and first_name='"+firstname+"' and last_name='"+lastname+"' and expiration='"+exp+"';");
			if(resultset.next()){
				if(resultset.getInt(1)==1){
					result = PASS;
				}else{
					result = WRONGINFO;
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeresource();
		}
		return result;
	}
	
	public void storeinfo(int movieid,int customid){
		
		Date dt=new Date();
	    SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		try{
			connection = new connDB().getConnection2();
			statement = connection.createStatement();
			statement.executeUpdate("insert into sales(customer_id,movie_id,sale_date) values('"+customid+"','"+movieid+"','"+f.format(dt)+"')");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeresource();
		}
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
