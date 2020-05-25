package tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetCatFactTest {

	@Test
	public void getRandomCatFact() {

		RestAssured.baseURI = "https://cat-fact.herokuapp.com";
		String response = given().queryParam("animal_type", "cat").queryParam("amount", "1").when().get("/facts/random")
				.then().assertThat().log().all().statusCode(200).extract().response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);
		String actualtext = js.getString("text");
		System.out.println("the returned text is " + actualtext);

		assertNotEquals(actualtext, null);

	}

}
