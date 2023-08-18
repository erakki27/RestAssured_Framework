package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payloads.Container;

//created for CRUD operation

public class ContainerEndPoints {
	
	public static Response createContainer(Container payload)
	{
		Response response=given().auth().preemptive().basic(Routes.Username, Routes.Password).header("profile_id",Routes.profileId).contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		.post(Routes.post_url);
		return response;
	}
	
	public static Response getContainerById(int containerId)
	{
		Response response=given().auth().preemptive().basic(Routes.Username, Routes.Password).header("profile_id",Routes.profileId).contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
		   .pathParam("container_id", containerId)
		.when()
		.get(Routes.get_container_url);
		return response;
	}
	
	public static Response getContainers()
	{
		Response response=given().auth().preemptive().basic(Routes.Username, Routes.Password).header("profile_id",Routes.profileId).contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
		           .when()
		.get(Routes.get_url);
		return response;
	}
	
	public static Response updateContainer(int containerId, Container payload)
	{
		Response response=given().auth().preemptive().basic(Routes.Username, Routes.Password).header("profile_id",Routes.profileId).contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
		   .body(payload)
		   .pathParam("container_id", containerId)
		.when()
		.put(Routes.update_url);
		return response;
	}

	public static Response deleteUser(int containerId)
	{
		Response response=given().auth().preemptive().basic(Routes.Username, Routes.Password).header("profile_id",Routes.profileId).contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
		   .pathParam("container_id", containerId)
		.when()
		.delete(Routes.delete_url);
		return response;
	}
}
