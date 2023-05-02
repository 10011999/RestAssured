package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCallTest {
    @Test
    public void getTest(){
       Response response = RestAssured.get("http://localhost:3000/posts");
        System.out.println("Sttus code: "+response.statusCode());
        System.out.println("Time: "+response.getTime());
        System.out.println("Json Body: "+response.asPrettyString());
        //System.out.println("Json Body: "+response.asString());
        Assert.assertEquals(response.statusCode(),200);
    }

    public void petPostTest(){
        Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/102");
        System.out.println("Sttus code: "+response.statusCode());
        System.out.println("Time: "+response.getTime());
        System.out.println("Json Body: "+response.asPrettyString());
        //System.out.println("Json Body: "+response.asString());
        Assert.assertEquals(response.statusCode(),200);
    }

}
