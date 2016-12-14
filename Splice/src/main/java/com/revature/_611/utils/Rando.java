package com.revature._611.utils;

import java.util.concurrent.ThreadLocalRandom;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Rando {

	public static int randInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min,max+1);
	}
	
}
