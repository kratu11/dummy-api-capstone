package com.swiggy.tests;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.swiggy.RequestBuilder.RequestBuilder;
import com.swiggy.constants.FrameworkConstants;
import com.swiggy.utils.ApiUtils;
import com.swiggy.utils.JsonReader;
import com.swiggy.utils.RandomUtils;

import io.restassured.response.Response;
public class userTests {
	
	@Test(priority=1)
	public void getListOfUsers() {
		
		Response response = RequestBuilder
				.buildRequestSpecificationForGetCalls()
				.log()
				.all()
				.get();
		response.prettyPrint();
		
   assertThat(response.getStatusCode()).isEqualTo(200);
		
		assertThat(response.jsonPath().getList("data").size())
		         .isPositive()
		          .as("Validating the size of the User array").isEqualTo(10);

			
	}
	@Test(priority=2)
	public void createUser(Method method) {
		
		String resource = ApiUtils
				          .readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath()+"createUserRequest.json")
				          .replace("fname", RandomUtils.getFirstName())
						  .replace("lname", RandomUtils.getLastName())
						  .replace("email_id", RandomUtils.getEmailId());
		
		Response response = RequestBuilder
				.buildRequestSpecificationforPostCalls()
				.body(resource)
				.post("/create");
		
		response.prettyPrint();
		ApiUtils.storeStringAsJsonFile(FrameworkConstants.getResponseJsonFolderPath()+method.getName()+"response.json",response);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
		
				
	}
	@Test(priority=3)
	public void negativeTestCase() {
		
		String resource = ApiUtils
		          .readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath()+"createUserRequest.json")
		          .replace("fname", RandomUtils.getFirstName())
				  .replace("lname", RandomUtils.getLastName())
				  .replace("email_id",JsonReader.returnEmailID());
		
		Response response = RequestBuilder
				.buildRequestSpecificationforPostCalls()
				.body(resource)
				.post("/create");
		response.prettyPrint();
		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
		
				  
	}
	@Test(priority=4)
	public void getListOfUsersCreatedByMe() {
		
		Response response = RequestBuilder
				.buildRequestSpecificationForGetCallsCreatedByMe()
				.log()
				.all()
				.get();
		response.prettyPrint();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
		
	}
	

}
