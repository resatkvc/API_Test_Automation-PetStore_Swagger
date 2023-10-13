package Swagger_Petstore;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get_FindPetByID {

    @Test
    public void petID() {

        String url = "https://petstore.swagger.io/v2/pet/55";
        JSONObject reqBody = new JSONObject();

        reqBody.put("petId", 55);

        JSONObject expBody = new JSONObject();

        expBody.put("id", 55);
        //expBody.put("id", 0);
        expBody.put("name", "doggie");
        //expBody.put("id", 0);
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
