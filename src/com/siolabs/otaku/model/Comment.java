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
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Key<User> getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Key<User> createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public String getCommentText() {
		return commentText;
	}


	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	String commentText;
	
	

}
