package RestAssuredPractice.RestAssuredMain;

import RestAssuredPractice.POJO.UserDetailsResponse.UpdatedResponseRoot;
import RestAssuredPractice.POJO.UserDetailsResponse.UpdatedResponseRootItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RestAssuredProcessJson {
    public static void main(String[] args) throws JsonProcessingException {
        //https://jsonplaceholder.typicode.com/posts
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        Response response = RestAssured.given()
                .when().log().all().get("/posts");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(response.asString());

        UpdatedResponseRootItem[] updatedResponseRootItem = mapper.readValue(response.asString(), UpdatedResponseRootItem[].class);

for(UpdatedResponseRootItem individualDetails: updatedResponseRootItem){
    System.out.println("title is -->"+individualDetails.getTitle());
}

//process only data whose id is odd number
        List<String> nameWhoseIdareOdd = Arrays.stream(updatedResponseRootItem).toList().stream().filter(a -> a.getId()==3
        ).map(a ->a.getTitle()).collect(Collectors.toList());
        System.out.println("id 3 names");
        for(String a : nameWhoseIdareOdd){
            System.out.println(a);
        }
    }

}
