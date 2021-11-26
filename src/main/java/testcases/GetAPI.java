package testcases;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.*;


import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAPI {

    @Test
    public void test(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts/1/comments";


        Response response = RestAssured.given().log().all()
                .when().get().then().extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> name = jsonPath.getList("name");
        ResponseBody body = response.body();
        String s = response.asString();
        long time = response.time();
        System.out.println("response times are-->"+time);
        response.toString();

        RestAssured.given().log().all()
                .when().get().then().body("token", Matchers.notNullValue());
        ObjectMapper mapper=new ObjectMapper();

        //   System.out.println(body.asString());
        // List<String> email = jsonPath.getList("email");
     //   List<String> list = jsonPath.getList("$..body");
        assertThat(name, hasSize(5));
       // assertThat(list,hasSize("gvc"));
        assertThat(name,hasItem(not(blankString())));

        System.out.println(name);
     //   System.out.println(list);
        response.prettyPrint();
    }
}
