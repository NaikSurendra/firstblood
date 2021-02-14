import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.apache.tools.ant.taskdefs.condition.Equals;


public class Test01_Get {
	
	@Test
	void test_01() {
	Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getBody());
		System.out.println(response.contentType());
		
		
		int a = response.getStatusCode();
		
		Assert.assertEquals(a, 200);
	}

	@Test
	void test_02() {
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]",equalTo(7))
		;
	}
}
