import io.restassured.RestAssured;
//import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.tools.ant.taskdefs.condition.Equals;


public class Demo_Get {

	@Test
	void Demo() {
		RestAssured.baseURI = "https://reqres.in/";
		String FN = "Byron";

		String getresp = given().log().all()
		.queryParam("page", "2")
		.when().get("api/users?page=2")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=new JsonPath(getresp);
		String ActFN = js.getString("data.first_name[3]");
				//System.out.println(ActFN.toString());
				Assert.assertEquals(FN, ActFN);
		}
	


}
