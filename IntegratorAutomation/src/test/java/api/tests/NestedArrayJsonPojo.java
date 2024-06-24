package api.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Req2;
import api.endpoints.Routes;
import api.payloads.Category;
import api.payloads.Pet;
import api.payloads.Tag;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NestedArrayJsonPojo {
	
public static String base_url = "https://petstore.swagger.io/v2";
	
	//pet store module
	
	public static String postupdate_url = base_url+"/pet/{pet_id}";
	public static String post_url = base_url+"/pet";
	public static String postimage_url = base_url+"/pet/{pet_id}/uploadImage";
	public static String get_url = base_url+"/pet/findByStatus";
	public static String update_url = base_url+"/pet";
	public static String delete_url = base_url+"/pet/{pet_id}";
	public static String get_user = base_url+"/pet/{pet_id}";
	
	public static String status1 ="available";
	public static String status2 ="pending";
	public static String status3 ="sold";
	



	@Test(priority=1)
    
	public void getData() {
		/*
		 * RequestSpecification httpRequest =
		 * RestAssured.given().contentType(ContentType.JSON).queryParams("status",
		 * status1); Response res = httpRequest.get(get_url); ResponseBody body =
		 * res.getBody(); //Converting the response body to string
		 * System.out.println("Response Body Is : " +body.asString());
		 * Assert.assertEquals(body.asString().contains("doggie"), true);
		 * Assert.assertEquals(res.getStatusCode(), 200);
		 */
       
       
       Response response=RestAssured.given().contentType(ContentType.JSON).queryParam("status", status1).get(get_url);
       Assert.assertEquals(response.getStatusCode(),200);
       
       String body = response.getBody().asString();
       System.out.println("Response body is : " +body);
       
       Assert.assertEquals(body.contains("doggie"), true);
    }
	
	@Test(priority=2)
	public void createPet() {
		Tag tagpayload = new Tag();
		tagpayload.setId(1);
		tagpayload.setName("cat");
		
		
		Category catpayload = new Category();
		catpayload.setId(100);
		catpayload.setName("pet");
		
		Pet petpayload = new Pet();
		petpayload.setName("kitty");
		petpayload.setStatus("available");
		List<Tag> tags = new ArrayList<Tag>();
		tags.add(tagpayload);
		petpayload.setTags(tags);
		petpayload.setCategory(catpayload); 
		
		Response response=RestAssured.given().contentType(ContentType.JSON).body(petpayload).when().post(post_url);
		Assert.assertEquals(response.getStatusCode(),200);
	       
	       String body = response.getBody().asString();
	       System.out.println("Response body is : " +body);
	     List<String> tagname= response.jsonPath().getList("tags.name");
	     for(String name : tagname) {
	    	 System.out.println("name :" +name);
	    	Assert.assertEquals(name, "cat"); 
	     }
	     
	   
	       long id = response.path("id");
	       System.out.println(id);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
