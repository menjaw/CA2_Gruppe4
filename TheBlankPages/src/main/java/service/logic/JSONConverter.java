package service.logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import service.entity.Person;

public class JSONConverter {
private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    public Person getPersonFromJson(String js){
        return GSON.fromJson(js, Person.class);
    }
    
    public String getJSONFromPerson(Person p) {
        return GSON.toJson(p);
    }

    public String getJSONFromPersons(List<Person> persons) {
        return GSON.toJson(persons);
    }
    
}