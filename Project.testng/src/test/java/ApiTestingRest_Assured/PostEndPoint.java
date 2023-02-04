package ApiTestingRest_Assured;

import java.io.File;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostEndPoint {
  @Test 
  public void f() {
	  
	 File jsonFiletoPost = new File("C:\\Users\\malih\\git\\repository3\\Project.testng\\reqres.json");
	 
	 Response posting = given().contentType(ContentType.JSON).body(jsonFiletoPost).post("https://reqres.in/api/users");
	 posting.prettyPrint(); 
	  
	 
	int statuscode = posting.statusCode();
	System.out.println(statuscode);
	
	SoftAssert ob = new SoftAssert();
	
	//convert to string
	String body =posting.asString();
	
	//verify shams is updated in server
	ob.assertEquals(body.contains("Shams"),true,"Shams should be in server");
	ob.assertAll();
  }
}
