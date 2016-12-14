package com.revature._611.controllers;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature._611.beans.Game;

@Aspect
@Controller
public class GameController {

	@RequestMapping(value="/getGameState", method = RequestMethod.POST)	
	public @ResponseBody String getGameState(@RequestBody Game game)  
	{	
		//--------------------------------------------^ make a Game bean
		//do logic
		
		return "string of json or whatever"; 
	}

}