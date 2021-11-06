package TestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_DeleteVideoGame {

    @Test

    public void deleteVideoGame(){

     Response res = (Response) RestAssured.given().
                when()
                .delete("http://localhost:8080/app/videogames/100")
                .then()
                .statusCode(200)
                .log().body().extract().response();


         String jsonString= res.asString();
        Assert.assertTrue(jsonString.contains("Record Deleted Successfully"));
    }

}
