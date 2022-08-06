package com.swiggy.RequestBuilder;

import static io.restassured.RestAssured.*;

import com.swiggy.enums.PropertiesType;
import com.swiggy.utils.PropertyUtils;

import io.restassured.specification.RequestSpecification;
public final class RequestBuilder {

			private RequestBuilder() {}
			
			public static RequestSpecification buildRequestSpecificationForGetCalls() {
				
				return given()
						.baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
						.queryParam("limit", 10)
						.headers("app-id","62ee45fd7cb1461a872ad070")
						.log()
						.all();
			}
public static RequestSpecification buildRequestSpecificationForGetCallsCreatedByMe() {
				
				return given()
						.baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
						.queryParam("created", 1)
						.headers("app-id","62ee45fd7cb1461a872ad070")
						.log()
						.all();
			}
public static RequestSpecification buildRequestSpecificationForCreatingPost() {
	
	return given()
			.baseUri("https://dummyapi.io/data/v1/post")
			.headers("app-id","62ee45fd7cb1461a872ad070")
			.log()
			.all()
			.contentType("application/json");
}
public static RequestSpecification buildRequestSpecificationForGettingPostDetails() {
	
	return given()
			.baseUri("https://dummyapi.io/data/v1/post")
			.headers("app-id","62ee45fd7cb1461a872ad070")
			.log()
			.all();
		
}

			public static RequestSpecification buildRequestSpecificationforPostCalls() {
				return buildRequestSpecificationForGetCalls()
						.contentType("application/json");
			}
}
