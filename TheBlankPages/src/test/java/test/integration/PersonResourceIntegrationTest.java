package test.integration;

import org.junit.Test;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import javax.ws.rs.ext.Provider;
import static org.hamcrest.Matchers.*;
import org.junit.BeforeClass;

@Provider
public class PersonResourceIntegrationTest {
    
    public PersonResourceIntegrationTest() {
    }

    @BeforeClass
    public static void setUpBeforeAll() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8084;
        RestAssured.basePath = "/TheBlankPages";
        RestAssured.defaultParser = Parser.JSON;
    }
    
    @Test
    public void serverIsRunning() {
        given().
                when().get().
                then().
                statusCode(200);
    }
    
    @Test
    public void nonExistingPerson() {
        given().when().get("/api/person/complete/10000").then().statusCode(404);
    }
    
    @Test
    public void existingPerson() {
        given().when().get("/api/person/complete/1").then().statusCode(200);
    }
    
}
