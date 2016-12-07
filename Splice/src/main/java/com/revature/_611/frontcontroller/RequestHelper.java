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
import com.revature._611.dao.UserDAOImpl;
import com.revature._611.logic.Commands;

public class RequestHelper {
	private ObjectMapper objectMapper;
	private JSONObject json;

	public String process(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		
		switch(request.getRequestURI()){
		
		case("/Splice/Login.do"):
			json = new JSONObject(request.getReader().readLine());
			Commands.doCommand(json, request.getSession(), response.getWriter());
			if(request.getSession().getAttribute("loggedIn").equals("true")){
				// send 202 Accepted
				System.out.println("202 status!");
				response.setStatus(202);
			}else{
				// send 401 Unauthorized
				response.setStatus(401);
			}
			return "login";
			
		case("/Splice/LogOut.do"):
			json = new JSONObject(request.getReader().readLine());
			Commands.doCommand(json, request.getSession(), response.getWriter());
			response.setStatus(200);
			return "index";
		
		case("/Splice/GetUser.do"):
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