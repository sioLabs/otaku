package com.siolabs.otaku.model;

import java.util.Date;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Comment {
	@Id Long id;
	
	Key<User> createdBy;
	
	Date creationDate;
	String commentText;
	
	

}
