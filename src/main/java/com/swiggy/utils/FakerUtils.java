package com.swiggy.utils;

import com.github.javafaker.Faker;

public class FakerUtils {
	
	private FakerUtils() {}
	
	private static final Faker faker = new Faker();
	
	public static String getFirstName() {
		return faker.name().firstName();
	}
	public static String getLastName() {
		return faker.name().lastName();
	}
	public static String getEmailId() {
		return faker.internet().emailAddress();
	}
	public static int getNumber(int startValue, int endValue) {
		return faker.number().numberBetween(startValue, endValue);
	}

}
