package com.revature._611.playground;

import java.util.concurrent.ThreadLocalRandom;

public class TestDriver {

	public static int randInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min,max+1);
	}
	
	public static void main(String[] args) {

	}

}
