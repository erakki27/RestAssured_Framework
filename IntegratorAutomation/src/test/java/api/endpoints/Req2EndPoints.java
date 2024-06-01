package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payloads.ReqUser;

//created for CRUD operation

public class Req2EndPoints {
	
	public static Response createUser(ReqUser payload)
	{
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		.post(Req2.post_url);
		return response;
	}
	
	public static Response getUserById(String userid)
	{
		Response response=given()
		   .pathParam("userid", userid)
		.when()
		.get(Req2.get_user);
		return response;
	}
	
	public static Response updateUser(String userName, ReqUser payload)
	{
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		   .pathParam("username", userName)
		.when()
		.put(Req2.update_url);
		return response;
	}

	public static Response deleteUser(String userid)
	{
		Response response=given()
		   .pathParam("userid", userid)
		.when()
		.delete(Req2.delete_url);
		return response;
	}
	
	public static Response getUser()
	{
		Response response=given()
				.contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
		.when()
		.get(Req2.get_url);
		return response;
	}
}
