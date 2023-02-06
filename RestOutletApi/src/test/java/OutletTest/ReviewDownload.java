package OutletTest;

import static io.restassured.RestAssured.given;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReviewDownload {
	public String message = "";
	public int failcount=0;
	public int Reviewfailcount=0;

//	public static ReviewDbConnection obj = new ReviewDbConnection();
    public static StringBuffer outletapibuffer=new StringBuffer();
public int status_code = 0;
public String text = "";


//@Test(priority = 1)
	public void Outlet_Review() throws ClassNotFoundException {
		String api1 = "https://location-data-api.singleinterface.com/v1/Reviews/OutletReviews";
		try {		
		RestAssured.baseURI = "https://location-data-api.singleinterface.com/v1/Reviews/OutletReviews";
		Response response = given()
		.header("auth", "5719966ab21c7f5659fe263f5b0c4261be76cdc8")
		.get()
		.then()
        .extract().response();
		status_code = response.statusCode();
		System.out.println(response.statusCode());
		text = response.jsonPath().getString("message");
		System.out.println("****"+text);

		JsonPath jsonpath= response.jsonPath();
		message = jsonpath.getString("data.reviews[0].name_found_from_page");
		System.out.println(message);
				
		if(message.contains("Singleinterface Channel Partner")) {
			System.out.println("Pass");
//        	obj.database(api1, status_code, message,"Pass");  //db code
		}else {
			System.out.println("Fail");
			failcount++;
//        	obj.database(api1, status_code, message,"Fail");  //db code
        	outletapibuffer.append(("Outlet Review API - "+api1 + "\n"+"Status Code - " +status_code+"\n"+"Message - " +text));
			//db code 
			//whats app code
		}
	}catch(Exception e) {
		System.out.println("Fail");
		failcount++;
//		obj.database(api1, status_code, text,"Fail");
		outletapibuffer.append(("Outlet Review API - "+api1 + "\n"+"Status Code - " +status_code+"\n"+"Message - " +text));
		//db code
	}
	}

@Test(priority = 1)
public void Review_Download() throws ClassNotFoundException {
	String api2 = "https://testing.singleinterface.com/v1/Reviews/ReviewDownload";
	try {		
	RestAssured.baseURI = api2;
	Response response = given()
	.header("auth", "b7ed3c52b731fbf242737e3d11fbe39436488774")
	.get()
	.then()
    .extract().response();
	status_code = response.statusCode();
	System.out.println(response.statusCode());
	text = response.jsonPath().getString("message");
	System.out.println("****"+text);

	JsonPath jsonpath= response.jsonPath();
	message = jsonpath.getString("data");
	System.out.println(message);
			
	if(message.contains("reviews") && message.contains("total_reviews") && status_code==200 && text.contains("OK")) {
		System.out.println("Pass");
////	obj.database(api2, status_code, message,"Pass");  //db code
	}
	
	else {
		System.out.println("Fail");
		Reviewfailcount++;
////    	obj.database(api1, status_code, message,"Fail");  //db code
    	outletapibuffer.append(("Review Download API - "+api2 + "\n"+"Status Code - " +status_code+"\n"+"Message - " +text));
//		//db code 
//		//whats app code
	}
}catch(Exception e) {
	System.out.println("Fail");
	Reviewfailcount++;
//	obj.database(api1, status_code, text,"Fail");
	outletapibuffer.append(("Outlet Review API - "+api2 + "\n"+"Status Code - " +status_code+"\n"+"Message - " +text));
	//db code
}
}


	@AfterTest
	public void Aftercases() {
		if (failcount>0) {
//	        ReviewMail.mail("Demo Mail : Urgent - IOCL Review API EndPoint is not working.", outletapibuffer.toString());

			//mail code
		}
	
	}

}
