package com.automationframe.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationframe.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class UpdateEmployee extends TestBase {
	@BeforeClass
	public void updateEmp()
	{
		
		
	}
	@Test
	void updateEmployee() throws InterruptedException
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/update/";
		httpRequest=RestAssured.given();

		
		JSONObject reqparam=new JSONObject();
		reqparam.put("name", "gaju");
		reqparam.put("salary", "90000");
		reqparam.put("age", "27");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(reqparam.toJSONString());
		response=httpRequest.request(Method.PUT,"11");
		
		Thread.sleep(5000);
		String respbody=response.getBody().asString();
		System.out.println("Responsebody--"+respbody);
	}

}
