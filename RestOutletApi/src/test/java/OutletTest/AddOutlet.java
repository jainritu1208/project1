package OutletTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddOutlet {

    private static String requestBody = "{\r\n"
    		+ "\"enterprise_actual_client_store_id\": \"10026\",\r\n"
    		+ "\"phone\": \"+62987654211\",\r\n"
    		+ "\"contact_person_name\":\"Ritu\",\r\n"
    		+ "\"contact_person_number\": \"+62987654210\",\r\n"
    		+ "\"contact_person_email\": \"support@abc.com\",\r\n"
    		+ "\"address\": \"L 22 B\",\r\n"
    		+ "\"business_hours\": \"2:10:00:18:00,3:10:00:18:00,4:10:00:18:00,5:10:00:18:00,6:10:00:18:00\",\r\n"
    		+ "\"zip\": \"14240\",\r\n"
    		+ "\"short_description\": \"SingleInterface helps your business establish a digital footprint across the web to leverage the power of local search drive in-store shoppers and acquire customers locally.\",\r\n"
    		+ "\"business_name\": \"\",\r\n"
    		+ "\"address_2\":\"Opposite Oriental Bank\",\r\n"
    		+ "\"location\": \"Malviya Nagar\",\r\n"
    		+ "\"landmark\": \"\",\r\n"
    		+ "\"is_active_on_dealer\": \"1\",\r\n"
    		+ "\"latitude\":\"3.1768503\",\r\n"
    		+ "\"longitude\": \"101.7499255\",\r\n"
    		+ "\"category_order_types\": \"sales, service\"\r\n"
    		+ "}\r\n"
    		+ "";

    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "https://location-data-api.singleinterface.com/v1/Outlets/Add";
    }

    @Test
    public void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and().header("auth","5719966ab21c7f5659fe263f5b0c4261be76cdc8").and()
                .body(requestBody)
                .when()
                .post()
                .then()
                .extract().response();
        System.out.println(response.statusCode());
        System.out.println(response.getContentType());
        
//        Assertions.assertEquals(201, response.statusCode());
//        Assertions.assertEquals("foo", response.jsonPath().getString("title"));
//        Assertions.assertEquals("bar", response.jsonPath().getString("body"));
//        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
//        Assertions.assertEquals("101", response.jsonPath().getString("id"));
    }
}
