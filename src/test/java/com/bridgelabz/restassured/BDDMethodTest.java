package com.bridgelabz.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BDDMethodTest {
    /*
     * given() --> header,body
     * when() --> method(get,post,put,delete,patch), getTime, asPrettyString
     * then() --> statuscode, time
     * and()
     * */
    @Test
    public  void getPetTest(){
    String petBody = given().
         when().get("https://petstore.swagger.io/v2/pet/101").asPrettyString();
        System.out.println(petBody);

    }
    @Test
    public void postPetTest(){
        JSONObject json = new JSONObject();
        json.put("id", 101);
        json.put("name", "Jerry");
        json.put("status", "available");

        given().header("Content-Type", "application/json").body(json.toString()).
                when().post("https://petstore.swagger.io/v2/pet/")
                .then().statusCode(200);
    }

    @Test
    public void putPetTest() {
        JSONObject json = new JSONObject();
        json.put("id", 101);
        json.put("name", "Jerry");
        json.put("status", "pending");

        given().header("Content-Type", "application/json").body(json.toString()).
                when().put("https://petstore.swagger.io/v2/pet/")
                .then().statusCode(200);

    }
    @Test
    public void patchPetTest() {
        JSONObject json = new JSONObject();
        json.put("id", 101);
        json.put("name", "Jerry");
        json.put("status", "busy");

        given().header("Content-Type", "application/json").body(json.toString()).
                when().put("https://petstore.swagger.io/v2/pet/")
                .then().statusCode(200);
    }

    @Test
    public  void deletePetTest(){
        given().when().delete("https://petstore.swagger.io/v2/pet/101").then().statusCode(200);
    }

}
