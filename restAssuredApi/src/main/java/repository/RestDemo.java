package repository;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.*;

public class RestDemo {
	
	@Test
	public void get_request() {
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		given()
			.when()
				.get("https://ipinfo.io/216.244.66.202?token=deac8b2df2e12a")
			.then()
				.statusCode(200)
				.log().all();
	}
}










//	public static void main(String[] args) throws IOException, ClassNotFoundException
//	{
//		Test t1 = new Test();
//		
//		//Serialization:
//		FileOutputStream fos = new FileOutputStream("test.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);		
//		oos.writeObject(t1);
//	
//		//Deseralization process:
//		
//		FileInputStream fis = new FileInputStream("test.txt");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		Test t2 = (Test) ois.readObject();
//		System.out.println(t2.i +" "+t2.j);
//	}
//}
//
//class Test implements Serializable{
//	int i=10, j=20;
//}


//public void call1() {

//Response response =  get("https://ipinfo.io/216.244.66.202?token=deac8b2df2e12a");
//System.out.println(response.getTime());
//System.out.println(response.getStatusCode());
//System.out.println(response.getStatusLine());
//System.out.println(response.getBody().asString());
//}

//	@Test
//	public  void call2() {
//		baseURI = "https://ipinfo.io/216.244.66.202?token=deac8b2df2e12a";
//		System.out.println(given().when().get().then().extract().path("country"));
//		
//	}
//	@Test
//	public void get_request() {
//		given()
//			.when()
//				.get("https://ipinfo.io/216.244.66.202?token=deac8b2df2e12a")
//			.then()
//				.statusCode(200)
//				.assertThat().body("ip", equalTo("216.244.66.202"))
//				.header("content-type", "application/json; charset=utf-8");
//	}

//	public static HashMap map = new HashMap();
//	
//	@BeforeClass
//	public void postdata() {
//		map.put("FirstName", RestUtils.getFirstName());
//		map.put("LastName", RestUtils.getLastName());
//		map.put("UserName", RestUtils.getUserName());
//		map.put("Password", RestUtils.getPassword());
//		map.put("Email", RestUtils.getEmail());
//		
//		
//		
//		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
//		RestAssured.basePath = "/register";
//	}
//	
//	@Test
//	public void testpost()
//{
//		given()
//			.contentType("application/json")
//			.body(map)
//		.when()
//			.post()
//		.then()
//			.statusCode(201);
//}
//	public static HashMap map = new HashMap();
//	
//	@BeforeClass
//	public void putData() {
//		
//	}