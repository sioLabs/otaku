package com.siolabs.otaku;

import static com.siolabs.otaku.model.OfyService.ofy;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.googlecode.objectify.Key;
import com.siolabs.otaku.model.User;


public class UserJsonResource  extends ServerResource{
	
	@Post
	public Representation handleUser(JsonRepresentation represent) throws JSONException
	{
		JsonRepresentation rep = null;
		
		JSONObject jsonObj = represent.getJsonObject();
		
		
		String name = jsonObj.getString("name");
		String email = jsonObj.getString("email");
		String password = jsonObj.getString("password");
		
		//create the user Entity
		User user = new User(email, name, password);
		
		//save the user Entity
		Key<User> userKey = ofy().save().entity(user).now();
		
		if(userKey != null){
		
			getResponse().setStatus(Status.SUCCESS_ACCEPTED);
			 
			 JSONStringer jsReply = new JSONStringer();

			 jsReply.object();

			jsReply.key("STATUS").value("SUCCESS");

			 jsReply.key("User").value(userKey.toString());
			 jsReply.endObject();

			  rep = new JsonRepresentation(jsReply);

			
		}else{
			
			
			JSONStringer jsReply = new JSONStringer();
			jsReply.object();
			jsReply.key("STATUS").value("FAILED");
			jsReply.endObject();
			getResponse().setStatus(Status.SERVER_ERROR_INTERNAL);
			
			rep = new JsonRepresentation(jsReply);
		}
		
		
		
		 
		 getResponse().setStatus(Status.SUCCESS_OK);
		
		return rep;
	}
	
	@Get("json")
	public String getUsers() throws JSONException{
		
		ArrayList<User> users = new ArrayList(ofy().load().type(User.class).list());
		
		if(null == users || users.size() <1){
			return null;
		}
		
		JSONStringer userArray = new JSONStringer();
		
		userArray.array();
		for(User u : users){
				JSONObject obj = new JSONObject();
				obj.put("name", u.getName());
				obj.put("id", u.getId());
				obj.put("repo", u.getReputationPoints());
				userArray.value(obj);		
			
		}
		userArray.endArray();
		
		
		
		return userArray.toString();
	}
	

}
