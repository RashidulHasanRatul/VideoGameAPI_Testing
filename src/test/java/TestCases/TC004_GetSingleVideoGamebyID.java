package TestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class TC004_GetSingleVideoGamebyID {

    @Test

    public void getSingleVideoGamebyID(){

        RestAssured.given()
                .contentType("application/json")
                .when()
                .get("http://localhost:8080/app/videogames/100")
                .then()
               .statusCode(200)
               .assertThat()
                       .body("videoGame.id",equalTo("100"))
                               .body("videoGame.name",equalTo("Spider-Man"));





    }

}
