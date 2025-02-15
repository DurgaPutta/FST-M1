package activities;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;

public class Activity2 {
	
	
	private String baseURI;
	
	@Test (priority = 1)
	public void postUser() throws IOException {
		
//		String baseURI = "https://petstore.swagger.io/v2/user";
		
		FileInputStream inputjson = new FileInputStream("C:\\Users\\003PE3744\\eclipse-workspace\\FST_M1_RestAssured\\src\\main\\resources\\userinfo.json");
		
		Response res = given().baseUri("https://petstore.swagger.io/v2/user")
				.header("Content-Type", "application/json")
				.body(inputjson).when().post();
		
		
		inputjson.close();
		res.prettyPrint();
		res.then().statusCode(200);
		res.then().body("code", equalTo(200));
		res.then().body("message", equalTo("243"));
	}
	
	@Test (priority =2)
	public void getUser() {
		
		baseURI = "https://petstore.swagger.io/v2/user/{username}";
		
		Response res = given().contentType(ContentType.JSON)
				.pathParam("username", "Durga")
				.when().get(baseURI);
		
		res.prettyPrint();
		res.then().statusCode(200);			
	}

	@Test (priority =3)
	public void deleteUser() {
		
		baseURI = "https://petstore.swagger.io/v2/user/{username}";
		
		Response res = given().contentType(ContentType.JSON)
				.pathParam("username", "Durga")
				.when().delete(baseURI);
		
		res.prettyPrint();
		res.then().statusCode(200);			
	}
}