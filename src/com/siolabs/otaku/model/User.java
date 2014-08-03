package com.siolabs.otaku.model;

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
	
	private User(String email, String name, String password){
		this.email = email;
		this.name = name;
		this.password = password;
		this.reputationPoints = 1;
		
	}

}
