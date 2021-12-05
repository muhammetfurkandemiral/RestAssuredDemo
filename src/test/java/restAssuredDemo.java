import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class restAssuredDemo {

    @Test
    public void singleUserTest() {
        when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.email",equalTo("janet.weaver@reqres.in"))
                .time(lessThan(2000L));
    }
    @Test
    public void allUsersTest() {
        when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .time(lessThan(2000L));

    }
    @Test
    public void userDelayedTest() {
        when()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .statusCode(200)
                .body("page",equalTo(1))
                .body("per_page",equalTo(6))
                .time(lessThan(5000L));

    }
    @Test
    public void deleteUserTest() {
        when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .time(lessThan(2000L));

    }

    private static String user = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";
    @Test
    public void createUserTest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .extract().response();

        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals("morpheus", response.jsonPath().getString("name"));
        Assert.assertEquals("leader", response.jsonPath().getString("job"));

    }



}
