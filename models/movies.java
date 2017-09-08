package com.proj2.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class movies {
	
	private Statement statement = null;
	private ResultSet resultset = null;
	private Connection connection = null;
	
	int rownum = 0;
	int pagenum = 0;
	
	public ArrayList getmovies(int pagenow,int pagesize,int model,String keyword,String aod){
		
		ArrayList al = new ArrayList();
		String command=" ";
		
		if(model==11){		
			if(aod.equals("asc"))
				command="select movies.* from movies,genres,genres_in_movies where movies.id=genres_in_movies.movie_id and genres.id=genres_in_movies.genre_id and genres.name='"+keyword+"' order by movies.year asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("desc"))
				command="select movies.* from movies,genres,genres_in_movies where movies.id=genres_in_movies.movie_id and genres.id=genres_in_movies.genre_id and genres.name='"+keyword+"' order by movies.year desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("tdesc"))
				command="select movies.* from movies,genres,genres_in_movies where movies.id=genres_in_movies.movie_id and genres.id=genres_in_movies.genre_id and genres.name='"+keyword+"' order by movies.title desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else
				command="select movies.* from movies,genres,genres_in_movies where movies.id=genres_in_movies.movie_id and genres.id=genres_in_movies.genre_id and genres.name='"+keyword+"' order by movies.title asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
		}
		else if(model==12){
			if(aod.equals("asc"))
				command="select movies.* from movies where movies.title like '"+keyword+"%'  order by movies.year asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("desc"))
				command="select movies.* from movies where movies.title like '"+keyword+"%'  order by movies.year desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("tdesc"))
				command="select movies.* from movies where movies.title like '"+keyword+"%' order by movies.title desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else
				command="select movies.* from movies where movies.title like '"+keyword+"%' order by movies.title asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
		}
		else if(model==10){
			if(aod.equals("asc"))
				command="select movies.* from movies where movies.year='"+keyword+"'  order by movies.year asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("desc"))
				command="select movies.* from movies where movies.year='"+keyword+"'  order by movies.year desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("tdesc"))
				command="select movies.* from movies where movies.year='"+keyword+"' order by movies.title desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else
				command="select movies.* from movies where movies.year='"+keyword+"' order by movies.title asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
		}
		else if(model==9){
			if(aod.equals("asc"))
				command="select movies.* from movies where movies.director='"+keyword+"'  order by movies.year asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("desc"))
				command="select movies.* from movies where movies.director='"+keyword+"'  order by movies.year desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("tdesc"))
				command="select movies.* from movies where movies.director='"+keyword+"' order by movies.title desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else
				command="select movies.* from movies where movies.director='"+keyword+"' order by movies.title asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
		}
		else if(model==13){
			if(aod.equals("asc"))
				command="select movies.* from movies where movies.title like '%"+keyword+"%'  order by movies.year asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("desc"))
				command="select movies.* from movies where movies.title like '%"+keyword+"%'  order by movies.year desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("tdesc"))
				command="select movies.* from movies where movies.title like '%"+keyword+"%' order by movies.title desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else
				command="select movies.* from movies where movies.title like '%"+keyword+"%' order by movies.title asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
		}
		else if(model==15){
				if(aod.equals("asc"))
					command = "select * from movies where "+keyword+" order by movies.year asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
				else if(aod.equals("desc"))
					command = "select * from movies where "+keyword+" order by movies.year desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
				else if(aod.equals("tdesc"))
					command = "select * from movies where "+keyword+" order by movies.title desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
				else
					command = "select * from movies where "+keyword+" order by movies.title asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
				
		}else if(model==16){
			if(aod.equals("asc"))
				command = "select movies.* from movies,stars,stars_in_movies where "+keyword+" order by movies.year asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("desc"))
				command = "select movies.* from movies,stars,stars_in_movies where "+keyword+" order by movies.year desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else if(aod.equals("tdesc"))
				command = "select movies.* from movies,stars,stars_in_movies where "+keyword+" order by movies.title desc limit "+pagesize*(pagenow-1)+","+pagesize+";";
			else
				command = "select movies.* from movies,stars,stars_in_movies where "+keyword+" order by movies.title asc limit "+pagesize*(pagenow-1)+","+pagesize+";";
		}
		
		try{
			connection=new connDB().getConnection();
			statement=connection.createStatement();
			resultset = statement.executeQuery(command);
			while(resultset.next()){
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
			this.closers();
		}
		return al;
	}

	
	public int getpagenum(int pagesize,int model,String keyword){
		try{
			connection=new connDB().getConnection();
			statement=connection.createStatement();
			String command=" ";
			if(model==11)
				command="select count(*) from movies,genres,genres_in_movies where movies.id=genres_in_movies.movie_id and genres.id=genres_in_movies.genre_id and genres.name='"+keyword+"';";
			else if(model==12)
				command="select count(*) from movies where movies.title like '"+keyword+"%';";
			else if(model==13)
				command="select count(*) from movies where movies.title like '%"+keyword+"%';";
			else if(model==10)
				command="select count(*) from movies where movies.year='"+keyword+"';";
			else if(model==9)
				command="select count(*) from movies where movies.director='"+keyword+"';";
			else if(model==15)
				command="select count(*) from movies where "+keyword;
			else if (model == 16)
				command="select count(*) from movies,stars,stars_in_movies where "+keyword;
			
			
			resultset = statement.executeQuery(command);
			if(resultset.next()){
				rownum=resultset.getInt(1);
			}
			if((rownum%pagesize)==0){
				pagenum=rownum/pagesize;
			}else{
				pagenum=rownum/pagesize+1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closers();
		}
		return pagenum;
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
