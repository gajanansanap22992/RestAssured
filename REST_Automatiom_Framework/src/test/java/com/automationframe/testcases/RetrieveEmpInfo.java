package com.automationframe.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationframe.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class RetrieveEmpInfo extends TestBase {

	@BeforeClass
	public void viewEmployeeInfo() throws InterruptedException
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employee/"+empId);
		Thread.sleep(5000);
	}
	@Test
	public void checkStatuscode()
	{
		int statusCode=response.getStatusCode();
		System.out.println("statusCode--"+statusCode);
		//Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void checkResponseBody()
	{
		logger.info("checking Response boddy-");
		String respBody=response.getBody().asString();
		System.out.println(respBody);
		//logger.info("ResponseBody \n"+respBody);
		//Assert.assertTrue(respBody.contains(empId));
	}
	
}
