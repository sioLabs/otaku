package com.siolabs.otaku.model;

import java.util.Date;
import java.util.Set;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


@Entity
public class Task {
	
	public Task(){
		
	}
	
	public Task(String title, String description, Key<User> createdBy) {
		super();
		this.title = title;
		this.description = description;
		this.createdBy = createdBy;
		this.comments = null;
		this.creationDate=new Date();
		this.upvotes = 1;
	
	}
	
	//unique id
	@Id Long id;
	
	
	String title;
	String description;
	@Index
	Key<User> createdBy;
	Date creationDate;
	
	
	Set<Key<Comment>> comments;
	
	int upvotes;
	
	
	/*
	 * getters and setter
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Set<Key<Comment>> getComments() {
		return comments;
	}
	public void setComments(Set<Key<Comment>> comments) {
		this.comments = comments;
	}
	public int getUpvotes() {
		return upvotes;
	}
	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}

	
	
	
	
	
	
}
