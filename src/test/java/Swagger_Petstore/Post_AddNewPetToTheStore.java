package Swagger_Petstore;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post_AddNewPetToTheStore {

    @Test
    public void addPetStore(){

        String url = "https://petstore.swagger.io/v2/pet";

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 190545);
        reqBody.put("name", "test");
        reqBody.put("status", "available");


        JSONObject expBody = new JSONObject();
        expBody.put("id", 190545);
        expBody.put("name", "test");
        expBody.put("status", "available");

        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                get(url);


        JsonPath actBody = response.jsonPath();

        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);

        Assert.assertEquals(expBody.get("id"), actBody.get("id"));
        Assert.assertEquals(expBody.get("name"), actBody.get("name"));
        Assert.assertEquals(expBody.get("status"), actBody.get("status"));

    }
}
