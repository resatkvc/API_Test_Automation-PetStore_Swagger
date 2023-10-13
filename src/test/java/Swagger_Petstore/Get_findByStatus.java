package Swagger_Petstore;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get_findByStatus {
    /*
    https://petstore.swagger.io/v2/pet/findByStatus?status=available url bir GET request yollanacak
    status codu 200 olacak,
    content type JSON beklenecek,
    parametrelerden available seçilecek
     */
    @Test
    public void testGetPetByStatus() {
        String status = "available";
        String Url = "https://petstore.swagger.io/v2/pet/findByStatus";

        Response response = given()
                .param("status", status)
                .when()
                .get(Url)
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .response();

        // API'den dönen cevabı kontrol etme
        //String responseBody = response.getBody().asString();
        //System.out.println("Response Body: " + responseBody);

        // Asserts ekleyerek API'den dönen cevabı istediğiniz şekilde doğrulayabilirsiniz
        assertEquals(200, response.getStatusCode());
        //response.prettyPrint();


        //son olarak kontrol sağla ya yukarıdaki kodlama yada bu kodlmala ile kalacak
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json");


        // Diğer assert kontrolleri buraya eklenebilir
    }

}