package com.proj2.models;

public class movieData {
	private int movieid;
	private String title;
	private int year;
	private String director;
	private String banner_url;
	private String trailer_url;
	
	public int getMovieid() {
		return movieid;
	}
	
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getBanner_url() {
		return banner_url;
	}
	
	public void setBanner_url(String banner_url) {
		this.banner_url = banner_url;
	}
	
	public String getTrailer_url() {
		return trailer_url;
	}
	
	public void setTrailer_url(String trailer_url) {
		this.trailer_url = trailer_url;
	}
}
