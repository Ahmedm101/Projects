package ApiTestingRest_Assured;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteEndPoints {
  @Test
  public void f() {
	  
	  Response DeleteByApi  = delete("https://reqres.in/api/users/2");
	  
	int DeleteStatusCode =  DeleteByApi.statusCode();
	System.out.println(DeleteStatusCode);
	
	//verify the status code
	
	SoftAssert ob = new SoftAssert();
	ob.assertEquals(DeleteStatusCode,204,"Delete status code should be 204" );
	  
	  ob.assertAll();
	  
	  
	  
	  
	  
	  
  }
}
