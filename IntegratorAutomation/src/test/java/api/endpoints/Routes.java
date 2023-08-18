package api.endpoints;

public class Routes {
	/*public static String base_url = "https://petstore.swagger.io/v2";*/
	
	public static String base_url = "http://127.0.0.1:8021";
	
	//container module
	
	public static String post_url = base_url+"/v1/containers";
	public static String get_url = base_url+"/v1/containers";
	public static String update_url = base_url+"/v1/containers/{container_id}";
	public static String delete_url = base_url+"/v1/containers/{container_id}";
	public static String get_container_url = base_url+"/v1/containers/{container_id}";
	
	public static String profileId = "2723950";
	public static String Username = "integrator-dev";
	public static String Password = "integrator-dev";
	
	//store module
	
	//pet module

}
