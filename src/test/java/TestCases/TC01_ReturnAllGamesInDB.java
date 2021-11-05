package TestCases;


import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class TC01_ReturnAllGamesInDB {

@Test
    public void getAllVideoGames(){

        given()
                .when()

                .get("http://localhost:8080/app/videogames")
                .then()
                .statusCode(200);



}


}
