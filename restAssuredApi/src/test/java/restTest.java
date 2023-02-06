//import static io.restassured.RestAssured.given;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.hasItems;
//
//import org.testng.annotations.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
//import io.restassured.specification.RequestSpecification;
//
//public class restTest {
//
//	@Test
//	public void test() {
//		// TODO Auto-generated method stub
//Response response  = RestAssured.get("https://www.googleapis.com/pagespeedonline/v5/runPagespeed?key=AIzaSyA0BaRRoglLAmGgPgRaGJWGfyuCqKCBwOk&url=https://tyreshop.ceat.com/ceat-shoppe-a-p-traders-a-p-traders-tyre-manufacturer-sector-52a-gurgaon-56318/Home?utm_source=locator&utm_medium=googleplaces&category=ACCESSIBILITY&category=best-practices&category=PERFORMANCE&category=PWA&category=SEO");
////System.out.println(response.asString());
////System.out.println(response.getBody().asString());
//System.out.println(given().when().get("https://www.googleapis.com/pagespeedonline/v5/runPagespeed?key=AIzaSyA0BaRRoglLAmGgPgRaGJWGfyuCqKCBwOk&url=https://tyreshop.ceat.com/ceat-shoppe-a-p-traders-a-p-traders-tyre-manufacturer-sector-52a-gurgaon-56318/Home?utm_source=locator&utm_medium=googleplaces&category=ACCESSIBILITY&category=best-practices&category=PERFORMANCE&category=PWA&category=SEO").then().extract().path("x.lighthouseResult.categories.performance.score"));
//
//
////		       String responce =  given().
////				header("Accept","application/json").
////                baseUri("https://ipinfo.io/216.244.66.202").get().then().statusCode(200).log().all().toString();
////		        
////		RestAssured.baseURI = "https://ipinfo.io/216.244.66.202?token=deac8b2df2e12a";
////    	RequestSpecification httpRequest = RestAssured.given();
////    	Response response = httpRequest.get("/country");
////    	// Retrieve the body of the Response
////    	ResponseBody body = response.getBody();
////    	// By using the ResponseBody.asString() method, we can convert the  body
////    	// into the string representation.
////    	System.out.println("Response Body is: " + body.asString());
//		       
//		       
////		given().get("https://reqres.in/api/users?page=2").
////        then().
////        statusCode(200).
////        body("data.id[1]", equalTo(2)).
////        body("data.first_name",hasItems("George"));
//        
//		
//	}
//
//}
