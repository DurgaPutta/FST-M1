import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class GitHub {
	
	
	RequestSpecification resspec;
	String ssh;
	int id;
	
	@BeforeClass
	public void setUp() {
		
		resspec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri("https://api.github.com")
				.addHeader("Authorization", "token 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")
				.build();
	}
	
	@Test (priority =1)
	public void postSSH() {
		ssh = """
				{
				    "title": "SSH Key 2",
				    "key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIEeazD9Mm8Xwr0enGYP7oxRVWcXRupZ2iE6Z57baIHEC"
				}
				
				""";
		
		Response res = given().spec(resspec).body(ssh).when().post("/user/keys");
		
		Reporter.log("Post Response" +res.prettyPrint(), true);
		id = res.jsonPath().getInt("id");
		Assert.assertEquals(res.getStatusCode(), 201, "Expected status code 201 for POST request");
		Assert.assertTrue(id > 0, "The extracted ID should be greater than 0");
		
	}
	
	@Test  (priority =2, dependsOnMethods = "postSSH")
	public void getUserDetails() {
		Response res = given().spec(resspec)
				.pathParam("keyId", id).when().get("/user/keys/{keyId}");
		Reporter.log("GET Response: " + res.prettyPrint(), true);
		Assert.assertEquals(res.getStatusCode(), 200, "Expected status code 200 for Get request");
	}
	
	@Test  (priority =3)
	public void deleteUserDetails() {
		Response res = given().spec(resspec)
				.pathParam("keyId", id).when().delete("/user/keys/{keyId}");
		Reporter.log("Delete Response: " + res.prettyPrint(), true);
		Assert.assertEquals(res.getStatusCode(), 204, "Expected status code 204 for Delete request");
		
	}
	

}