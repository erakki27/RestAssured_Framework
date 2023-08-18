package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority=1, dataProvider ="Data",dataProviderClass = DataProviders.class)
	public  void testPostuser(String userID, String userName, String fname, String lname, String useremail, String password, String ph)
	{
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));;
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(password);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userPayload);
		int id = response.jsonPath().get("id");
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(id);
	}
}
