package com.siolabs.otaku.model;

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
	String profiePic;
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
		return profiePic;
	}


	public void setProfiePic(String profiePic) {
		this.profiePic = profiePic;
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


	public void setTasks(Set<Key<Task>> tasks) {
		this.tasks = tasks;
	}

}
