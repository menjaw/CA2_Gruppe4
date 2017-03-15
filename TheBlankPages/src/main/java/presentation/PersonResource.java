package presentation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static com.jayway.restassured.parsing.Parser.JSON;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import service.entity.Person;
import service.logic.Facade;

/**
 * REST Web Service
 *
 * @author Group 4
 */
@Path("person")
public class PersonResource {
    Facade facade = new Facade();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of presentation.PersonResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        List<Person> persons = facade.getPersons();
        //System.out.println(persons.size());
        String jsonPersons = service.logic.JSONConverter.getJSONFromPersons(persons);//convert list to JSON
        //System.out.println(jsonPersons[0]);
       // System.out.println(gson.fromJson(jsonPersons.toString()));
        //System.out.println(jsonPersons);
        return jsonPersons;
       //return ""; 
    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
