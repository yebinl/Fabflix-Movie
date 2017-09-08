package com.proj2.models;

import java.sql.*;

public class starData {
	private int starid;
	private String firstname;
	private String lastname;
	private Date dob;
	private String photourl;
	
	public int getStarid() {
		return starid;
	}
	public void setStarid(int starid) {
		this.starid = starid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
}
