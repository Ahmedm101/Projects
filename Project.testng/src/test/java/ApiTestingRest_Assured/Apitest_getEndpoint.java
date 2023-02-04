package ApiTestingRest_Assured;

import org.testng.annotations.Test;



import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Apitest_getEndpoint {
  @Test
  public void f() {
	  // will print the data
	  Response TheResponseofTheApi= get("https://reqres.in/api/users?page=2");
	//  TheResponseofTheApi.prettyPrint();
	  
	  // will print the response
	int statuscode=  TheResponseofTheApi.getStatusCode();
	System.out.println(statuscode);
	
	// hard assert: the script won't run, it will run till the hard assert the console will show failure
//Assert.assertEquals(statuscode,201,"get endpoints status should be 200");

System.out.println("kiki");
 
  //soft assert: the script will run even it failed but report will show fail report
	SoftAssert ob = new SoftAssert();
	
   ob.assertEquals(statuscode, 200,"get endpoints status shold be 200");
   
   System.out.println("kiki");
   
   // convert response body to string
  String bodyinString= TheResponseofTheApi.asString();
   
   //assert lindsay is present in the reponse body
  ob.assertEquals(bodyinString.toLowerCase().contains("lindsay"),true,"Verfity lindsay is present");
   
   
   
   
   
   
   
   
   ob.assertAll();
  } 
}
