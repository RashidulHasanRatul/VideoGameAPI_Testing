package TestCases;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class TC005_UpdateExistingGame {
    @Test

    public void getSingleVideoGamebyID(){


        HashMap<String, String> data = new HashMap<>();

        // Adding elements to the Map
        // using standard add() method
        data.put("id","100");
        data.put("name","Rashidul-Man");



        RestAssured.given()
                .contentType("application/json")
                .body(data)

                .when()
                .put("http://localhost:8080/app/videogames/100")

                .then()
                .statusCode(200)
                .log().body();






    }
}
