package com.siolabs.otaku;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class TestappServlet extends Application {
	
	
	
	
	@Override
	public Restlet createInboundRoot() {
		// Create a router Restlet that routes each call to a new Resource
		
		System.out.print("Reached router");
		Router router = new Router(getContext());
		router.attach("/user", UserJsonResource.class);
		router.attach("/task", TaskJsonResource.class);
		router.attachDefault(TestJsonResource.class);
		
		return router;

	}
	
	
	
}
