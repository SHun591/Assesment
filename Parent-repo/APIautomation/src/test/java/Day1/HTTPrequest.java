package Day1;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class HTTPrequest {

    @Test
    public void validateCoinDeskApiResponse() {
       
        RestAssured.baseURI = "https://api.coindesk.com/v1/bpi/currentprice.json";

        Response response = RestAssured.get();

           Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");

         Map<String, Object> jsonResponse = response.jsonPath().getMap("");

         Assert.assertTrue(jsonResponse.containsKey("bpi"), "Response does not contain 'bpi' key!");

          Map<String, Object> bpi = (Map<String, Object>) jsonResponse.get("bpi");
        Assert.assertEquals(bpi.size(), 3, "Number of BPIs mismatch!");
        Assert.assertTrue(bpi.containsKey("USD"), "BPI does not contain 'USD'!");
        Assert.assertTrue(bpi.containsKey("GBP"), "BPI does not contain 'GBP'!");
        Assert.assertTrue(bpi.containsKey("EUR"), "BPI does not contain 'EUR'!");
       
        Map<String, Object> gbpDetails = (Map<String, Object>) bpi.get("GBP");
        Assert.assertEquals(gbpDetails.get("description"), "British Pound Sterling", "GBP description mismatch!");
    }
}
