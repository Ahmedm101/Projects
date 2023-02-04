package ApiTestingRest_Assured;

import java.io.File;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PutEndPoints {
  @Test
  public void f() {
	  
	  File put = new File("C:\\Users\\malih\\git\\repository3\\Project.testng\\put.json");
	  
	  Response Put = given().contentType(ContentType.JSON).body(put).put("https://reqres.in/api/users/2");
	  Put.prettyPrint();
	  
	  // verify the status code
	  
	int statuscode =  Put.statusCode();
	 SoftAssert ob = new SoftAssert();
	 ob.assertEquals(statuscode,200,"the status should be 200" );
	 
   String body =	 Put.asString();
	 //verify the text 
	 ob.assertEquals(body.contains("QA Lead"),true,"the job should be updated to QA Lead");
	 
	 ob.assertAll();
  }
}
