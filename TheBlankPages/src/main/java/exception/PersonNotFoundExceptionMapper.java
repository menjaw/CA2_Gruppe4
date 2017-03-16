package exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException> {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context 
    ServletContext context;
    
    @Override
    public Response toResponse(PersonNotFoundException ex) {
        String msg = ex.getMessage();
        ErrorMessage err = new ErrorMessage(msg,400);
        return Response.status(404)
				.entity(gson.toJson(err))
				.type(MediaType.APPLICATION_JSON)
				.build();
    }
}