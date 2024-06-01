package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.ReqUser;


//created for CRUD operation

public class UserEndPoints2 {
	
	static ResourceBundle getUrl()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");  // Load Properties file
			return routes;	
	}
	
	public static Response createUser(ReqUser payload)
	{
		String post_url = getUrl().getString("post_url");
		String username = getUrl().getString("username");
		String password = getUrl().getString("password");
		Response response=given().auth().basic(username, password)
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		.post(post_url);
		return response;
	}
	
	public static Response readUser()
	{
		String get_url = getUrl().getString("get_url");
		String profileId = getUrl().getString("profileId");
		String token = getUrl().getString("token");
		String username = getUrl().getString("username");
		String password = getUrl().getString("password");
		
		
		Response response=given().auth().preemptive().basic(username, password).header("profile_id",profileId).contentType(ContentType.JSON)
		.when()
		.get("http://127.0.0.1:8021/v1/containers");
		return response;
	}
	
	public static Response updateUser(String userName, ReqUser payload)
	{
		String update_url = getUrl().getString("update_url");
		String username = getUrl().getString("username");
		String password = getUrl().getString("password");
		Response response=given().auth().basic(username, password)
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		   .pathParam("username", userName)
		.when()
		.put(update_url);
		return response;
	}

	public static Response deleteUser(String userName)
	{
		String delete_url = getUrl().getString("delete_url");
		String username = getUrl().getString("username");
		String password = getUrl().getString("password");
		Response response=given().auth().basic(username, password)
		   .pathParam("username", userName)
		.when()
		.delete(delete_url);
		return response;
	}
}
