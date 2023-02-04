package ApiTestingRest_Assured;

import java.io.File;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Aitestinrandomway {
  @Test
  public void f() {
	 // server address 
	 RestAssured.baseURI = "https://reqres.in/";
	 
	 // we are stroing it for further use
	RequestSpecification g =  RestAssured.given();
	
	Response getApi = g.get("/api/users?page=2");
	  
	  getApi.prettyPrint();
	  
	String body =  getApi.asString();
	 
	 SoftAssert ob = new SoftAssert();
	  ob.assertEquals(body.contains("michael.lawson@reqres.in"),true,"the email is michael.lawson@reqres.in" );
	  
	  File f = new File("C:\\Users\\malih\\git\\repository3\\Project.testng\\reqres.json");
	  Response posting = g.contentType(ContentType.JSON).body(f).post("/api/users");
	  posting.prettyPrint();
	String body1 =  posting.asString();
	
	  
	  
	  
  }
}
