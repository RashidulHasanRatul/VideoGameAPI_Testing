package TestAutomationUnversity;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import  static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class T01_ParameterizeTest {


    //Store Data
    @DataProvider
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][] {

                { "us", "90210", "Beverly Hills" },
                { "us", "12345", "Schenectady" },
                { "ca", "B2R", "Waverley"}
        };

    }


    //    feed data from data set

    @Test
    @UseDataProvider("zipCodesAndPlaces")
    public void requestZipCodesFromCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceName(String countryCode, String zipCode, String expectedPlaceName)

    {

        given().
                pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
                when().
                get("http://zippopotam.us/{countryCode}/{zipCode}").
                then().
                assertThat().
                body("places[0].'place name'", equalTo(expectedPlaceName));

    }


}
