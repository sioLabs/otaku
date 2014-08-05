package com.siolabs.otaku;

import static com.siolabs.otaku.model.OfyService.ofy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONArray;
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
import com.siolabs.otaku.model.Comment;
import com.siolabs.otaku.model.Task;
import com.siolabs.otaku.model.User;



public class TaskJsonResource extends ServerResource {
	
	//code to create a Task
	@Post
	public Representation submitTask(JsonRepresentation represent) throws JSONException{
		
		JsonRepresentation rep = null;
		
		//get the data from the reques
		JSONObject obj = represent.getJsonObject();
		String title = obj.getString("title");
		String desc = obj.getString("description");
		Key<User> userKey = Key.create(User.class , obj.getString("submittedBy"));
		
		//create a task
		Task task = new Task(title,desc,userKey);
		
		//save the task to the db 
		Key<Task> taskKey = ofy().save().entity(task).now();
		
		//check if saved or not
		if(taskKey != null){
			getResponse().setStatus(Status.SUCCESS_ACCEPTED);
			 
			 JSONStringer jsReply = new JSONStringer();

			 jsReply.object();

			jsReply.key("STATUS").value("SUCCESS 2");

			 jsReply.key("User").value(userKey.toString());
			 jsReply.endObject();

			  rep = new JsonRepresentation(jsReply);
			
		}else
		{
			JSONStringer jsReply = new JSONStringer();
			jsReply.object();
			jsReply.key("STATUS").value("FAILED");
			jsReply.endObject();
			getResponse().setStatus(Status.SERVER_ERROR_INTERNAL);
			
			rep = new JsonRepresentation(jsReply);
		}
		
		
		 //getResponse().setStatus(Status.SUCCESS_OK);
			
		return rep;
	}
	
	
	//code to get all the tasks
	@Get("json")	
	public String getTasks(){
		
		//get the userID from the queryString
		String userId = getQueryValue("userId");
		
		/*now query the database to get all tasks created by this user
		 * this should be in the performed Tasks or the Task Model
		 */
		Key<User> userKey = Key.create(User.class, userId);
		ArrayList<Task> taskList = new ArrayList(ofy().load().type(Task.class).filter("createdBy", userKey).list());
		
		if(taskList == null || taskList.size() <1 )
			return "";

		
		JSONStringer taskArray = new JSONStringer();
		try {
			taskArray.array();
			for(Task t : taskList){
				JSONObject obj = new JSONObject();
				obj.put("id", t.getId());
				obj.put("title", t.getTitle());
				//TODO change here for string and get data from the class
				obj.put("proof", "");
				obj.put("description", t.getDescription());
				obj.put("submissionDate", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(t.getCreationDate()));
				obj.put("upvotecount", t.getUpvotes());
				
				
				
				
				JSONArray commentArray = new JSONArray();				
				//get the comments
				if(t.getComments() == null)
					obj.put("commentcount", 0);
				else{
					obj.put("commentcount", t.getComments().size());
					for(Key<Comment> c : t.getComments()){
						Comment comm  = ofy().load().key(c).now();
						
						//convert the Comment class to JsonObject
						JSONObject commObj = new JSONObject();
						commObj.put("createdBy", ofy().load().key(comm.getCreatedBy()).now().getName());
						commObj.put("commentText", comm.getCommentText());
						commObj.put("creationDate", new SimpleDateFormat("dd-MM-yyyy").format(comm.getCreationDate()));
						commentArray.put(commObj);
					}
			
				}
				
				
				obj.put("comments", commentArray);	
				taskArray.value(obj);
			}
			
			
			taskArray.endArray();
			
			return taskArray.toString();
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
				
		return null;
	}

}
