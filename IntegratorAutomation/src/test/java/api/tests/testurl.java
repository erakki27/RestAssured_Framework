package api.tests;

import java.util.Properties;
import java.util.ResourceBundle;

import org.testng.annotations.Test;

import api.endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class testurl {
	
	static ResourceBundle getUrl()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");  // Load Properties file
			return routes;	
	}



	@Test
    public void getData() {
       RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic(Routes.Username, Routes.Password).header("profile_id",Routes.profileId).contentType(ContentType.JSON);
       Response res = httpRequest.get(Routes.get_url);
       ResponseBody body = res.body();
       //Converting the response body to string
       String rbdy = body.asString();
       System.out.println("Data from the GET API- "+rbdy);
    }

}
