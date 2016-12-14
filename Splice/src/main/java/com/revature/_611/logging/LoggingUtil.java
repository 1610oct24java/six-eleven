package com.revature._611.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;

public class LoggingUtil {

	private final File file = new File("splice.log");
	
	private static Logger log = Logger.getRootLogger();
	
	public void logTrace(String message){
		log.trace(message);
	}
	
	public void logDebug(String message){
		log.debug(message);
		try{
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(message);
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void logInfo(String message){
		log.info(message);
	}
	
	public void logWarn(String message){
		log.warn(message);
	}
	
	public void logError(String message){
		log.error(message);
	}
	
	public void logFatal(String message){
		log.fatal(message);
	}	
}