package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.annotations.Test;

public class TwitterApiTest {
    @Test
    public void postTweetTest() {

        //user "id": 1651071486206115840,

        Response response = RestAssured.given().auth().oauth(
                        "BAAaFlhLMPhgDs15xvyL86d6h",
                        "WgD6L7RLlnoMZFidGWk7pEhoiEUEawbRQr9VHDfbMaAtjY4ihg",
                        "1651071486206115840-81mOHMFq6aim5x9qffLdrzeadAtvHi",
                        "6kR3QhucIKtrEuzfkC03gXPKxO28UOnaujcXlwGDkZDdv").
                post("https://api.twitter.com/1.1/statuses/update.json?status=This is my second tweet using rest Assured");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }

    @Test
    public void reTweetTest() {
        // user_id = 4003503614
        JSONObject json = new JSONObject();
        json.put("id", "1651071486206115840");
        json.put("tweet_id", "1651506246959104001");
        Response response = RestAssured.given().auth().oauth(
                        "BAAaFlhLMPhgDs15xvyL86d6h",
                        "WgD6L7RLlnoMZFidGWk7pEhoiEUEawbRQr9VHDfbMaAtjY4ihg",
                        "1651071486206115840-81mOHMFq6aim5x9qffLdrzeadAtvHi",
                        "6kR3QhucIKtrEuzfkC03gXPKxO28UOnaujcXlwGDkZDdv").
                post("https://api.twitter.com/1.1/statuses/retweet/1652260726738948096.json");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }

    @Test
    public void reTweet() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("tweet_id", "1651870379256823808");
        RequestSpecification request = RestAssured.given().auth().oauth(
                        "BAAaFlhLMPhgDs15xvyL86d6h",
                        "WgD6L7RLlnoMZFidGWk7pEhoiEUEawbRQr9VHDfbMaAtjY4ihg",
                        "1651071486206115840-81mOHMFq6aim5x9qffLdrzeadAtvHi",
                        "6kR3QhucIKtrEuzfkC03gXPKxO28UOnaujcXlwGDkZDdv");
        request.body(jsonBody.toString());
        Response response = request.post("https://api.twitter.com/1.1/statuses/retweet/1651872692553875456.json");
        System.out.println("Response Body: " + response.asPrettyString());

        System.out.println("Response Code: " + response.statusCode());
    }

    @Test
    public void undoRetweetTest() {
        Response response = RestAssured.given().auth().oauth(
                        "BAAaFlhLMPhgDs15xvyL86d6h",
                        "WgD6L7RLlnoMZFidGWk7pEhoiEUEawbRQr9VHDfbMaAtjY4ihg",
                        "1651071486206115840-81mOHMFq6aim5x9qffLdrzeadAtvHi",
                        "6kR3QhucIKtrEuzfkC03gXPKxO28UOnaujcXlwGDkZDdv").
                post("https://api.twitter.com/1.1/statuses/destroy/1652261133489942530.json");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }

    @Test
    public void deleteTweetTest() {
        Response response = RestAssured.given().auth().oauth(
                        "BAAaFlhLMPhgDs15xvyL86d6h",
                        "WgD6L7RLlnoMZFidGWk7pEhoiEUEawbRQr9VHDfbMaAtjY4ihg",
                        "1651071486206115840-81mOHMFq6aim5x9qffLdrzeadAtvHi",
                        "6kR3QhucIKtrEuzfkC03gXPKxO28UOnaujcXlwGDkZDdv").
                post("https://api.twitter.com/1.1/statuses/destroy/1651506246959104001.json");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }
}
