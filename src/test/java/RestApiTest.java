import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestApiTest {
    String baseUri = "https://petstore.swagger.io/v2";
    String status = "/pet/findByStatus";
    String status1 = "/pet/";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    RequestSpecification rs = new RequestSpecBuilder()
            .setBaseUri(baseUri)
            .setContentType(ContentType.JSON)
            .build();

    @Order(1)
    @Test

    public void testGetLection() {
        Response responce = given()
                .spec(rs)
                .when()
                .get(status + "?status=sold");

        String responseBody = responce.getBody().asString();
        JsonParser parser = new JsonParser();
        Long id = parser.parse(responseBody).getAsJsonArray().get(3).getAsJsonObject().get("id").getAsLong();

        Assertions.assertEquals(123456, id,
                "Values are not equal. Current id: " + id + ", expected: " + 12);
    }
    @Order(3)

    @Test

    public void testGetMyId() {
        Response responce = given()
                .spec(rs)
                .when()
                .get(status1 + "123456");

        responce.prettyPrint();

        String responseBody = responce.getBody().asString();

        JsonParser parser = new JsonParser();
        Long id = parser.parse(responseBody).getAsJsonObject().get("id").getAsLong();



        Assertions.assertEquals(123456, id,
                "Values are not equal. Current id: " + id + ", expected: " + 123456);

    }

    @Order(4)

    @Test

    public void testGetMyName() {
        Response responce = given()
                .spec(rs)
                .when()
                .get(status1 + "123456");

        responce.prettyPrint();

        String responseBody = responce.getBody().asString();

        JsonParser parser = new JsonParser();
        Long id = parser.parse(responseBody).getAsJsonObject().get("id").getAsLong();
        String name = parser.parse(responseBody).getAsJsonObject().get("name").getAsString();
        String status = parser.parse(responseBody).getAsJsonObject().get("status").getAsString();




            Assertions.assertEquals("Vasia", name.substring(1,6),
                    "Values are not equal. Current name: " + name + ", expected: " + "Vasia");

    }

    @Order(5)

    @Test

    public void testGetMyStatus() {
        Response responce = given()
                .spec(rs)
                .when()
                .get(status1 + "123456");

        responce.prettyPrint();

        String responseBody = responce.getBody().asString();

        JsonParser parser = new JsonParser();

        String status = parser.parse(responseBody).getAsJsonObject().get("status").getAsString();




        Assertions.assertEquals("SOLD", status.substring(1,5),
                "Values are not equal. Current name: " + status + ", expected: " + "SOLD");
    }


    @Order(2)
    @Test

    public void testPost() {
        Pet pet = new Pet(123456,"Vasia", "Sold" );
        String jsonBody = "";

        try {
            jsonBody = OBJECT_MAPPER.writeValueAsString(pet);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        given()
                .spec(rs)
                .when()
                .body(jsonBody)
                .post(status1 + "123456");

        try {
            Thread.sleep(10000);
        } catch(InterruptedException ex) {
                  }

        Response responce = given()
                .spec(rs)
                .when()
                .get(status1 + "123456");



            String responseBody = responce.getBody().asString();

            JsonParser parser = new JsonParser();

            String status = parser.parse(responseBody).getAsJsonObject().get("status").getAsString();


            Assertions.assertEquals("SOLD", status.substring(1, 8),
                    "Values are not equal. Current name: " + status + ", expected: " + "Avilable");

    }

    @Order(6)
    @Test
    public void testDeleteMy() {
        Response responce = given()
                .spec(rs)
                .when()
                .delete(status1 + "123456");

        responce.prettyPrint();

        String responseBody = responce.getBody().asString();


        Assertions.assertEquals("", responseBody,
              "Values are not equal. Current id: " + responseBody + ", expected: " + "");


    }
    @Disabled
    @Order(2)
    @Test

    public void testPut() {
        Pet pet = new Pet(123456,"Kostian", "Avilable" );
        String jsonBody = "";

        try {
            jsonBody = OBJECT_MAPPER.writeValueAsString(pet);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        testGetMyStatus();
//        given()
//                .spec(rs)
//                .when()
//                .body(jsonBody)
//                .put(status1 + "123456");
//        try {
//            Thread.sleep(10000);
//        } catch(InterruptedException ex) {
//        }
//
//        Response responce = given()
//                .spec(rs)
//                .when()
//                .get(status1 + "123456");
//
//        try {
//
//            String responseBody = responce.getBody().asString();
//
//            JsonParser parser = new JsonParser();
//
//            String status = parser.parse(responseBody).getAsJsonObject().get("status").getAsString();
//
//
//            Assertions.assertEquals("SOLD", status.substring(1, 8),
//                    "Values are not equal. Current name: " + status + ", expected: " + "Avilable");}
//            catch (JsonSyntaxException e) {
//            System.out.println(e.getMessage());
//        }
//        finally {
//            System.out.println("Объект не найден");
        }
    }



