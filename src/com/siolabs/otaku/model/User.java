package com.siolabs.otaku.model;

import java.util.Date;
import java.util.Set;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


@Entity
public class User {
	
	@Id Long id;
	@Index String email;
	String password;
	String name;	
	String profilePic;
	Date dob;
	String country;
	String city;
	int reputationPoints;
	
	//the tasks create by the user
	Set<Key<Task>> tasks = null;
	
	
	public User(){
		
	}
	
	
	public User(String email, String name, String password){
		this.email = email;
		this.name = name;
		this.password = password;
		this.reputationPoints = 1;
		this.country = "";
		this.city = "Delhi";
		this.dob = new Date();
			
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProfiePic() {
		return this.profilePic;
	}


	public void setProfiePic(String profiePic) {
		this.profilePic = profiePic;
	}


	public int getReputationPoints() {
		return reputationPoints;
	}


	public void setReputationPoints(int reputationPoints) {
		this.reputationPoints = reputationPoints;
	}


	public Set<Key<Task>> getTasks() {
		return tasks;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setTasks(Set<Key<Task>> tasks) {
		this.tasks = tasks;
	}

}
