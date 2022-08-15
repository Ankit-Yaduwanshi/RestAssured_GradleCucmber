package stepDef;

import baseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.testng.Reporter;
//import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

public class restAssuredStepDef extends BaseClass {

    @Given("launch the targeted endpoint")
    public void launchTheTargetedEndpoint() {
        System.out.println("In Rest assured");
        RestAssured.baseURI = "https://reqres.in";
        given().log().all().header("Content-Type", "application/json")
                .when().get("/api/users?page=2")
                .then().log().all().assertThat().statusCode(200);
    }

    @Given("launch the targeted baseurl {string} and endpoint {string}")
    public void launchTheTargetedBaseurlAndEndpoint(String baseurl, String endpoint) {
        System.out.println("In Rest assured");
        RestAssured.baseURI = baseurl;
        given().log().all().header("Content-Type", "application/json")
                .when().get(endpoint)
                .then().log().all().assertThat()
                //to validate Schema just use matchesJsonSchemaInClasspath(filepath) in body
                .body(matchesJsonSchemaInClasspath("Input/SchemaUser.json"))
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                .header("server", "cloudflare");
    }

    @Given("launch the GET request with baseurl {string} and endpoint {string}")
    public void launch_the_get_request_with_baseurl_and_endpoint(String baseurl, String endpoint) {
        Reporter.log("********************reporter logger********************");
        System.out.println("********************Launch GET Request********************");
        RestAssured.baseURI = baseurl;
        Request = given().header("Content-Type", "application/json");
        Response = Request.when().get(endpoint);
    }

    @Then("validate the status code {int} firstName {string}")
    public void validate_the_status_code_first_name(int statusCode, String firstName) {
        System.out.println("********************Validating Response********************");
        int statusCode1 = Response.statusCode();
        String firstName1 = Response.jsonPath().get("data.first_name");
        Assert.assertEquals(statusCode1, statusCode);
        Assert.assertEquals(firstName1, firstName);
    }

    @Then("validate server {string} in the header response")
    public void validate_server_in_the_header_response(String server) {
        System.out.println("********************Validating header in response********************");
        String server1 = Response.header("server");
        Assert.assertEquals(server1, server);
    }

    @Then("validate the Schema {string} of the response")
    public void validate_the_schema_of_the_response(String schemaPtah) {
        System.out.println("********************Schema Validation********************");
        System.out.println(Response.asPrettyString());
        Response.then().assertThat().body(matchesJsonSchemaInClasspath(schemaPtah));
    }
}


//*****************NOTES*****************
// 1- when JsonSchemaValidator is added then we dont use static in import
// 2- else use in .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("src/main/resources/Input/SchemaUser.json"))
// 3-