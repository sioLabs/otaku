package com.siolabs.testApp;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ContactJsonResource  extends ServerResource{
	
	@Get
	public String represent(){
		try {
			JSONObject json = new JSONObject();
			json.put("firstname","Ashutosh");
			json.put("lastname","Singh");
			json.put("age", 24);
			json.put("url", getReference());
			json.put("param", getReference().getQuery());

			JsonRepresentation jsonRep = new JsonRepresentation(json);

			return jsonRep.getText();
			} catch (JSONException e) {
			e.printStackTrace();
			} catch (IOException e)
			{
			e.printStackTrace();
			}
		
		
		return null;
	}

}
