package com.proj2.models;

import java.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.sql.DataSource;


public class connDB {
	private Connection connection = null;

	public Connection getConnection() throws NamingException{
	
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/moviedb");
			connection = ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return connection;
		
	}
	public Connection getConnection2() throws NamingException{
		
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/moviedb2");
			connection = ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return connection;
		
	}
}
