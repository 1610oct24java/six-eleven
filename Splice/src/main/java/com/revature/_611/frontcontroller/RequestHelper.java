package com.revature._611.frontcontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature._611.beans.User;

public class RequestHelper {
	private ObjectMapper objectMapper;

	public String process(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		
		switch(request.getRequestURI()){
		
		case("/Splice/Login.do"):
			objectMapper = new ObjectMapper();
			System.out.println("We made it into the DOOOO");
			JSONObject json = new JSONObject(request.getReader().readLine());
			System.out.println("JSON: " + json.toString());
			User user = new User(-1, "ric", "Password8");;
			System.out.println("USER: " + user.toString());
			
			
			try {
				User jUser = objectMapper.readValue(json.toString(), User.class);
				System.out.println("did it work?:" +jUser.toString());
				
			} catch (JsonParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return json.toString();
			
		case("/Splice/AuthenticateUser.do"):
			
			objectMapper = new ObjectMapper();
			//User user;
			
			try {
				
				user = objectMapper.readValue(request.getParameter("user"), User.class);
				System.out.println(user.toString());
				
			} catch (JsonParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			return "some string of data or something like  game.html";
		
		case("/Splice/GetUsers.do"):
			User testUser = new User();
			testUser.setUsername("testUsername");
			testUser.setPassword("testPassword");
			
			objectMapper = new ObjectMapper();
			String strUser = "";
			
			try { 
				strUser = objectMapper.writeValueAsString(testUser);
				System.out.println(strUser);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return strUser;
		
		default:
			return "error404.html";
		}
	}
}
