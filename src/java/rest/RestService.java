/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Person;
import facade.Facade;
import facade.IPersonFacade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import utility.JSONConverter;

/**
 * REST Web Service
 *
 * @author sebastiannielsen
 */
@Path("person")
public class RestService {
    
    IPersonFacade facade = new Facade();
    
    @Context
    private UriInfo context;

    public RestService() {
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getPerson(@PathParam("id") long id) {
        Person p = facade.getPerson(id);
        return Response.ok(JSONConverter.getJSONFromPerson(p)).build();
    }
    
    @GET
    @Produces("application/json")
    public Response getPersons(){
        List<Person> persons = facade.getPersons();
        return Response.ok(JSONConverter.getJSONFromPerson(persons)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addPerson(String person){
        Person newPerson = JSONConverter.getPersonFromJson(person);
        facade.addPerson(newPerson);
        return Response.ok(JSONConverter.getJSONFromPerson(newPerson)).build();
    }
    
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response updatePerson(String person){
        Person p = JSONConverter.getPersonFromJson(person);
        facade.editPerson(p);
        return Response.ok(JSONConverter.getJSONFromPerson(p)).build();
        
    }
}
