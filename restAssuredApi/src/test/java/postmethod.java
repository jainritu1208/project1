import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class postmethod {

	@Test
	public void testpost() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Name", "Deepika");
		map.put("job", "QA");
		System.out.println(map);
		
		JSONObject request= new JSONObject(map);
		System.out.println(request.toJSONString());
		
		given().
		     header("Content-Type","application/json").
		     body(request.toJSONString()).
		
		when().
		     post("https://reqres.in/api/users").
		
		then().
		     statusCode(201).log().all();
	}
}
