package utils;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import pojo.Pojo;
import pojo.Search;

import static io.restassured.RestAssured.given;


public class HTTPMethods {


    public static Response get(String urlPath){
        return Authorization.loginToJira()
                .header("Content-Type",ContentType.JSON)
                .when()
                .get(urlPath)
                .then().extract().response();
    }

    public static Response post(String urlPath, Pojo body) {

        return Authorization.loginToJira().
                header("Content-Type", ContentType.JSON)
                .body(body)
                .when()
                .post(urlPath)
                .then().extract().response();
    }

    public static Response put(String urlPath, Pojo body){
        return Authorization.loginToJira()
                .header("Content-Type", ContentType.JSON)
                .body(body)
                .when()
                .put(urlPath)
                .then().extract().response();
    }

    public static Response delete(String urlPath) {
        return Authorization.loginToJira().
                header("Content-Type", ContentType.JSON).
                when().
                delete(urlPath).
                then().extract().response();

    }


}
