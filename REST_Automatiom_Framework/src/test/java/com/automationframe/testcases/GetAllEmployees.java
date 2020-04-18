package com.automationframe.testcases;

import org.apache.log4j.pattern.LogEvent;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationframe.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;

public class GetAllEmployees extends TestBase  
{
@BeforeClass
public void getAllEmployees() throws InterruptedException
{
	logger.info("setting uri for all employeeApi--");
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	httpRequest=RestAssured.given();
	response=httpRequest.request(Method.GET,"/employees");
	
	
	Thread.sleep(3000);
}
@Test
public void testResponsebody()
{    
	logger.info("test Responsebody--");
	String RespBody=response.getBody().asString();
	System.out.println("Responsebody-->"+RespBody);
	Assert.assertEquals(RespBody.contains("success"), true);
}

@Test
public void checkStatusCode()
{
	logger.info("checking status code--");
	int statusCode=response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
}
@Test
public void checkStatusLine()
{
	logger.info("checking status line--");
	String statusCode=response.getStatusLine();
	Assert.assertEquals(statusCode, "HTTP/1.1 200 OK");
}
@Test
public void checkResponseTime()
{
	logger.info("checking status time--");
	long rtime=response.getTime();
	
	if(rtime>2000)
		logger.info("warn response time is greater than 2 seconds");
	
	Assert.assertTrue(rtime<2000);
}

@Test
public void checkContentType()
{
	logger.info("checking content type--");
	String contentType=response.header("Content-Type");
	logger.info("ContentType--"+contentType);
	Assert.assertEquals(contentType, "application/json;charset=utf-8");
}
@Test
public void checkServerType()
{
	logger.info("checking server type--");
	String serverType=response.header("server");
	logger.info("serverType is--"+serverType);
	Assert.assertEquals(serverType, "nginx/1.16.0");
}
@Test
public void checkContentEncoding()
{
	logger.info("checking Content Encoding--");
	String encoding=response.header("Content-Encoding");
	logger.info("Encoding --"+encoding);
	Assert.assertEquals(encoding, "gzip");
	

}
@Test
public void checkContentLength()
{
	logger.info("checking Content Length--");
	 String lengths=response.header("Content-Length");
	 int l=Integer.parseInt(lengths);
	 if(l>800) {
	logger.info("Content length is--"+lengths);
	Assert.assertTrue(l<800);
	

        }

}

@Test
public void tearDown()
{
	logger.info("#####");
}






}




