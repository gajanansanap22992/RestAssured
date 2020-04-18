package com.automationframe.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import com.automationframe.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class DeleteEmployee extends TestBase
{
	@Test
	public void deleteData() throws InterruptedException {
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	httpRequest=RestAssured.given();

	response=httpRequest.request(Method.GET,"/employees");
	JsonPath jp=response.jsonPath();
	ArrayList<Map<String, String>> al=jp.get("data");
	HashMap<String, String>hm=new HashMap<String, String>();
	hm.putAll(al.get(0));
	String empId=hm.get("id");
	System.out.println(empId);
	response=httpRequest.request(Method.DELETE,"/delete/"+empId);
	
	
	Thread.sleep(5000);
	String respbody=response.getBody().asString();
	System.out.println("Responsebody--"+respbody);
	}
}
