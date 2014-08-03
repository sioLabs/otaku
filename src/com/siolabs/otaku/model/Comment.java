package com.siolabs.otaku.model;

import java.util.Date;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Comment {
	@Id Long id;
	
	public Comment(){}
	
	
	public Comment(Key<User> createdBy, String commentText) {
		super();
		this.createdBy = createdBy;
		this.commentText = commentText;
		this.creationDate = new Date();
	}
	Key<User> createdBy;
	
	Date creationDate;
	String commentText;
	
	

}
