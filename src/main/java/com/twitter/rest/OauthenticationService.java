package com.twitter.rest;

import com.twitter.service.TwitterService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/service")
public class OauthenticationService {	
	static TwitterService obj=new TwitterService();
	@GET
	@Path("/signin")
	public Response Signin() {
		return Response.temporaryRedirect(obj.uri).build();
	}
	@GET
	@Path("/callback")
	public Response Callback(@QueryParam("oauth_verifier") String oauth_verifier) {
		String screenName=null;
		System.out.println("oauthVerifier is"+oauth_verifier);
		screenName=obj.getAccessToken(oauth_verifier);
		
		return Response.status(200).entity(screenName).build();
		
		
	}
	
}