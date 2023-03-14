package com.simpletest;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
//import org.hamcrest.Matchers
import org.testng.annotations.Test;

import com.pojos.Pojoaddemployee;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FistApitest {
	@BeforeClass
	public void init() {
	RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";	
	}

@Test
public void Getemployeeinfo() {
Response res=RestAssured
         .given()
         .when()
         .get("/employees");
         res.then()
         .statusCode(200);
         res.then().body("status", is("success"));
         res.prettyPrint();
         res.body().jsonPath().get("data.length");
 		System.out.println(res.body().jsonPath().get("data.length"));}
       @Test  
 		public void createdata() {
 			Pojoaddemployee ob=new Pojoaddemployee();
 			ob.setName1("Sathya");
 			ob.setAge1("16");
 			ob.setSalary1("20,000");
 			Response res=RestAssured.given()
 					.contentType(ContentType.JSON)
 					.body(ob)
 					.when().post("/create");
 			        res.then().statusCode(200);
 			         res.then().body("status", is("success"));
 			         res.prettyPrint();
 			         int id=res.body().jsonPath().get("data.id");
 			         System.out.println(id);
 			         res.then().body("data.name", is("Sathya"));
 			        res.then().body("data.salary", is("20,000"));  
 			       res.then().body("data.age", is("16"));
	}
       @Test
       public void deletedata() {
    	   
           Response res=RestAssured.given().contentType(ContentType.TEXT).pathParam("id", "6790")
					
					.body("{\"id\":\"6790\"}")
					.when().delete("/delete/{id}");
           
   		res.prettyPrint();
   		res.then().statusCode(200);
   		res.then().body("status", is("success"));
   		res.then().body("data", is("6790"));  }
   		
   	 @Test
     public void negativeTest() {
  	   
         Response res=RestAssured.given().contentType(ContentType.TEXT).pathParam("id", "0")
					
					.body("{\"id\":\"0\"}")
					.when().delete("/delete/{id}");
         
 		res.prettyPrint();
 		res.then().statusCode(400);
 		res.then().body("status", is("error"));
 		
    	         }   
   	 
   	@Test
    public void getID2() {
 	   
        Response res=RestAssured.given().contentType(ContentType.JSON).pathParam("id", "2")
					
					.body("{\"id\":\"2\"}")
					.when().get("/employee/{id}");
        
		res.prettyPrint();
		res.then().statusCode(200);
		res.then().body("status", is("success"));
		res.then().body("data.employee_name", is("Garrett Winters"));
		res.then().body("data.employee_salary", is(170750));
		res.then().body("data.employee_age", is(63));
		String contentType=res.contentType();
		System.out.println("content type="+contentType);
   	         }    

       
       
}
