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
public class postTests {
	
	@Test(priority=1)
	public void createPost(Method method) {
		String resource = ApiUtils
		          .readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath()+"createPostrequest.json")
		          .replace("number", String.valueOf(RandomUtils.getLikes()))
				  .replace("userId", JsonReader.returnOwnerId());
				 
		
		Response response = RequestBuilder
				.buildRequestSpecificationForCreatingPost()
				.body(resource)
				.post("/create");
		response.prettyPrint();
		ApiUtils.storeStringAsJsonFile(FrameworkConstants.getResponseJsonFolderPath()+method.getName()+"response.json",response);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
		
	}
	
	@Test(priority=2)
	public void  getPostsDetails() {
		
		
		Response response = RequestBuilder
				.buildRequestSpecificationForGettingPostDetails()
				.get("/"+JsonReader.returnPostId()+"");
		response.prettyPrint();
		
   assertThat(response.getStatusCode()).isEqualTo(200);
		
		
		
	}
	
	@Test(priority=3)
 public void  deletePostDetails() {
		
		
		Response response = RequestBuilder
				.buildRequestSpecificationForGettingPostDetails()
				.delete("/"+JsonReader.returnPostId()+"");
		response.prettyPrint();
		
   assertThat(response.getStatusCode()).isEqualTo(200);
		
		
		
	}

}
