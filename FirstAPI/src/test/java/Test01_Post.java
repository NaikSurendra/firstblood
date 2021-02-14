import java.util.HashMap;
import java.util.Map;

import javax.swing.text.AbstractDocument.Content;

import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test01_Post {
	@Test
	public void test_01_Post() {
		
		Map <String, Object> map = new HashMap<String, Object>();
		
		map.put("name","Raghav");
		map.put("job", "Teacher");
		
		System.out.println(map);
		JSONObject request= new JSONObject();
		request.put("name","Raghav");
		request.put("job", "Teacher");
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().header("Content-type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201);
		
	
		
	}
}
