package com.automationframe.testcases;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationframe.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class CreateEmployee extends TestBase 
{
@BeforeClass
public void setUp()
{
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
	httpRequest=RestAssured.given();
	
	
}
@Test
public void createEmployee()
{
	JSONObject reqparam=new JSONObject();
	reqparam.put("name", "gajanan");
	reqparam.put("salary", "150000");
	reqparam.put("age", "27");
	httpRequest.header("Content-Type","application/json");
	httpRequest.body(reqparam.toJSONString());
	response=httpRequest.request(Method.POST,"create");
	System.out.println("response body--"+response.getBody().asString());
	JsonPath jp=response.jsonPath();
     HashMap<String ,String> hm=jp.get("data");
     System.out.println(hm.get("name"));
	
	
	
}
}
