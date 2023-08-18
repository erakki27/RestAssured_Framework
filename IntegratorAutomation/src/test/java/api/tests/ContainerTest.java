package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.ContainerEndPoints;
import api.payloads.Container;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class ContainerTest {
	int containerId;
	
	public Logger logger;

	@Test(priority=1, dataProvider ="Data",dataProviderClass = DataProviders.class)
	public void testCreateContainer(String containerName, String containerDescription, String containerType)
	{
		Container containerPayload = new Container();
		containerPayload.setContainer_name(containerName);
		containerPayload.setContainer_description(containerDescription);
		containerPayload.setContainer_type(containerType);
		//logs
		
		
		Response response = ContainerEndPoints.createContainer(containerPayload);
		response.then().log().all();
		this.containerId = response.path("container_id");
		 
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(containerId);
	}
	
	@Test(dependsOnMethods = {"testCreateContainer"})
	public void testGetContainerById() 
	{
		Response response = ContainerEndPoints.getContainerById(this.containerId);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
@Test(priority=3, dataProvider ="Data",dataProviderClass = DataProviders.class)
	public void testUpdateContainer(String containerName, String containerDescription, String containerType) 
	{
	Container containerPayload = new Container();
	containerPayload.setContainer_name(containerName);
	containerPayload.setContainer_description(containerDescription);
	containerPayload.setContainer_type(containerType);
		Response response = ContainerEndPoints.updateContainer(this.containerId, containerPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testDeleteContainer() 
	{
		Response response = ContainerEndPoints.deleteUser(this.containerId);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=5)
	public void testGetContainers() 
	{
		Response response = ContainerEndPoints.getContainers();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
