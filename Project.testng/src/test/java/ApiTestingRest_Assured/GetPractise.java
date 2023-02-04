package ApiTestingRest_Assured;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class GetPractise {
  @Test
  public void f() {
	  
	  Response ResponseOfTheApi = get("https://reqres.in/api/users?page=2");
	  
	  ResponseOfTheApi.prettyPrint(); // gives all the data from this api 
	  
	  int statuscode = ResponseOfTheApi.statusCode();
	  System.out.println(statuscode);
	  
	String bodyoftheResponse =  ResponseOfTheApi.asString();
	
	
	
	
	
	
  }
}
