package TestCases;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Tc02_AddNewVideoGameToTheDB {

    @Test

    public void addVideoGameToDB(){

        HashMap<String, String> data = new HashMap<>();

        // Adding elements to the Map
        // using standard add() method
        data.put("id","100");
        data.put("name","Spider-Man");
        data.put("releaseDate","2021");
        data.put("reviewScore","5");
        data.put("category","Adventure");
        data.put("rating","Universal");

        given().contentType("Application/json")
                .body(data)
                .when()
                .post()
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response();









    }
}
