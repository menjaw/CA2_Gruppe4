package presentation;

//import static com.jayway.restassured.parsing.Parser.JSON;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import service.entity.Person;
import service.logic.Facade;
import service.logic.JSONConverter;

/**
 * REST Web Service
 *
 * @author Group 4
 */
@Path("person")
public class PersonResource {
    Facade facade;
    JSONConverter jsonconverter = new JSONConverter();
    @Context
    private UriInfo context;

    public PersonResource() {
        facade = new Facade();
    }

    @GET
    @Path("/complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") int id) {
        Person p = facade.getPerson(id);
        return jsonconverter.getJSONFromPerson(p);
    }
    
    @GET
    @Path("/complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        List<Person> ps = facade.getPersons();
        return jsonconverter.getJSONFromPersons(ps);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addPerson(String inputtedPerson) {
        Person personToAdd = jsonconverter.getPersonFromJson(inputtedPerson);//convert Person object from JSON to Java
        Person personAdded = facade.addPerson(personToAdd);
        return jsonconverter.getJSONFromPerson(personAdded);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String jsonPerson) {
        Person personToModify = jsonconverter.getPersonFromJson(jsonPerson);
        Person personModified = facade.updatePerson(personToModify);
        return jsonconverter.getJSONFromPerson(personModified);
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteText(@PathParam("id") int id) {
        Person deletedPerson = facade.deletePerson(id);
        return jsonconverter.getJSONFromPerson(deletedPerson);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
        //String jsonPersons = service.logic.JSONConverter.getJSONFromPerson(p);//convert list to JSON
     * Retrieves representation of an instance of presentation.PersonResource
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Path("/all")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getPersons() {
//        List<Person> persons = facade.getPersons();
//        String jsonPersons = service.logic.JSONConverter.getJSONFromPersons(persons);//convert list to JSON
//        return jsonPersons;
//    }
    
    
    
//    @GET
//    @Path("/{firstname}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getPersons(@PathParam("firstname") String firstname) {
//        List<Person> persons = facade.getPersons(firstname);
//        String jsonPersons = service.logic.JSONConverter.getJSONFromPersons(persons);//convert list to JSON
//        return jsonPersons;
//    }

    
    
    
    
    
    
    
}
