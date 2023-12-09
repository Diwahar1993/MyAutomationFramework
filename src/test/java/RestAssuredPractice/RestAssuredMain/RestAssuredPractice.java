package RestAssuredPractice.RestAssuredMain;

import RestAssuredPractice.POJO.UserDetailsRequestRoot;
import RestAssuredPractice.POJO.UserDetailsResponseRoot;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredPractice {

    public static void main(String[] args) throws JsonProcessingException {
       // 1) java code to hit the get call "https://jsonplaceholder.typicode.com/posts" and validate the response code and Responsevalue

        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        String endpointpath ="/posts/2";
        //given code
        String response = RestAssured.given()
                .header("headername","headerValue")
                .when().get(endpointpath).asString();
        System.out.println(response);

        // process the output
        ObjectMapper mapper = new ObjectMapper();
        UserDetailsResponseRoot userDetailsResponse = mapper.readValue(response,UserDetailsResponseRoot.class);
        System.out.println(" id is -->"+userDetailsResponse.getId());

        //2) set a body using pojo, feed values and pass the details
        UserDetailsRequestRoot userDetailsRequestRoot = new UserDetailsRequestRoot();
        userDetailsRequestRoot.setBody("diwahar");
        userDetailsRequestRoot.setUserId(10);
        userDetailsRequestRoot.setTitle("Diwahar Title");

        Response requestSpecification= RestAssured.given()
                .header("headername","headerValue").log().all()
                .body(userDetailsRequestRoot).log().all()
                .contentType(ContentType.JSON)
                .when().post("/posts");

        System.out.println(requestSpecification.asString());
        System.out.println(requestSpecification.getContentType());
        System.out.println("Body is "+requestSpecification.getBody().asString());
        System.out.println(requestSpecification.getStatusCode());
        System.out.println(requestSpecification.getSessionId());


        //3 process the output using streams

    }
}
