package com.swiggy.utils;



public class RandomUtils {
	
	private RandomUtils() {}
	
	public static String getFirstName() {
		return FakerUtils.getFirstName().toLowerCase();
	}
	public static String getLastName() {
		return FakerUtils.getLastName().toLowerCase();
	}
	public static String getEmailId() {
		return FakerUtils.getEmailId();
	}
	public static int getLikes() {
		return FakerUtils.getNumber(1,1000);
	}

}
