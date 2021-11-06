package TestCases;

import static io.restassured.RestAssured.given;

import com.google.gson.JsonParseException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class Tc02_AddNewVideoGameToTheDB {

    @Test
    public void addVideoGameToDB()  throws JsonParseException, IOException {

        HashMap<String, String> data = new HashMap<>();

        // Adding elements to the Map
        // using standard add() method
        data.put("id","100");
        data.put("name","Spider-Man");
        data.put("releaseDate","2021");
        data.put("reviewScore","5");
        data.put("category","Adventure");
        data.put("rating","Universal");

       Response res =  given().contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:8080/app/videogames")
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response();


      String jsonString =  res.asString();

        Assert.assertTrue(jsonString.contains("Record Added Successfully"));









    }
}
