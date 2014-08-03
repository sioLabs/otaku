package com.siolabs.otaku.model;

import java.util.Date;
import java.util.Set;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Task {
	
	public Task(String title, String description, Key<User> createdBy) {
		super();
		this.title = title;
		this.description = description;
		this.createdBy = createdBy;
		this.comments = null;
		this.creationDate=new Date();
		this.upvotes = 0;
		this.downvotes = 0;
	}
	
	//unique id
	@Id Long id;
	
	
	String title;
	String description;
	Key<User> createdBy;
	Date creationDate;
	
	Set<Key<Comment>> comments;
	
	int upvotes;
	int downvotes;
	
	
	
	
	
	
}
