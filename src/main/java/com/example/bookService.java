package com.example;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;


@Path("book")
public class bookService {

    private book testBook;
    private List<book> list = new ArrayList<book>();

    public bookService(){
        testBook = new book("War and peace","Tolstoy L.N.", 1820);
    }

    @GET
    @Produces("application/json")
    public String getBookJson()
    {
        Gson gson = new Gson();
        return  gson.toJson(testBook);
    }

    @POST
    @Produces("application/json")
    public String postBookJson(@FormParam("name") String name)
    {
       // Gson gson = new Gson();
        return  "{Name:"+ name + "}"; //,Author:POST,CreateYear:1820POST}";
    }

    @GET
    @Path("add")
    @Produces("application/json")
    public String getBookJson(@QueryParam("name") String name, @QueryParam("author") String author, @QueryParam("year") int year )
    {
        JSONObject response = new JSONObject();
        response.put("year", year);
        response.put("author", author);
        response.put("name", name);

        return  response.toJSONString();
    }

    @GET
    @Path("json")
    @Produces("application/json")
    public book getJson() {
 //       return  this.getBookJson();
        return  testBook;
    }

    @GET
    @Produces("application/json")
    @Path("/json/{firstName}")
    public String getJSON(@PathParam("firstName") String firstName) {
        //Contact contact = contactService.findByFirstName(firstName);
        return "Param firstName - " + firstName;
    }

    @GET
    @Path("xml")
    @Produces("application/xml")
    public book getXml() {
        return  testBook;
    }


    @GET
    @Path("jsonxml")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public book getJasonXml() {
        return  testBook;
    }

}


