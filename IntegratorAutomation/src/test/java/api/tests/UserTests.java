package api.tests;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Req2EndPoints;
import api.payloads.ReqUser;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class UserTests {
	
	Faker faker;
	ReqUser userPayload;
	public Logger logger;

	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userPayload =  new ReqUser();
		
		
		
		userPayload.setJob(faker.job().title());
		userPayload.setName(faker.name().name());
		
		
		//logs
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		Response response = Req2EndPoints.createUser(userPayload);
		MatcherAssert.assertThat(
				response.getBody().asString(),
		JsonSchemaValidator.matchesJsonSchemaInClasspath("createUser.json")
	);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
