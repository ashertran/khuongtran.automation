package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class APISteps {
    String url;
    private Response response;
    private ValidatableResponse json;

    @Given("^The api are up and running for \"([^\"]*)\"$")
    public void the_api_are_up_and_running_for(String url) throws Throwable {
        this.url = url;
        response = given().when().get(url);
        Assert.assertEquals(200, response.statusCode());

    }

    @When("^I perform a get request to \"([^\"]*)\"$")
    public void i_perform_a_get_request_to(String apiurl) throws Throwable {
        this.url = url + apiurl;

    }

    @When("^I perform the request$")
    public void i_perform_the_request() throws Throwable {
        response = given().when().get(url);

    }

    @Then("^The response code should be (\\d+)$")
    public void the_responese_code_should_be_code_is(int code) throws Throwable {
        json = response.then().statusCode(code);
    }

    @Then("^I should see Json response with a pairs on a filters$")
    public void iShouldSeeJsonResponseWithAPairsOnAFilters(Map<String, String> responseFields) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        System.out.println(responseFields);
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            // System.out.println(responseFields.entrySet()+ "check the responseFields");
            // System.out.println(StringUtils.isNumeric(field.getValue()));
            if (StringUtils.isNumeric(field.getValue())) {
                // System.out.println(field.getKey()+"check key");
                //  System.out.println(field.getValue()+ "check value");
                // System.out.println(Integer.parseInt(field.getValue()));


                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            } else {
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }
}
