package com.revature._611.game;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.json.JSONObject;

@Aspect
public class ActionHelper {

	
	public static void handleAction(JSONObject json, HttpSession session, PrintWriter out) {
		JSONObject data = json.getJSONObject("Data");
		String action = json.getString("Command");
		
		switch (action) {
			case ("Attack"):
			
			default: 
				System.out.println("Invalid Action");
				break;
		}
		
	}
}
