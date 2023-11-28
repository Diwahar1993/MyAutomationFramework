package Learnings;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class restassured {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://example.com/api";

        // Request body as JSON or any other format
        String requestBody = "{\"key1\": \"value1\", \"key2\": \"value2\"}";

        // Perform POST request with headers
        RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer YourAccessToken")
                .body(requestBody)
                .when()
                .post("/endpoint")
                .then()
                .statusCode(200);

    }
}
