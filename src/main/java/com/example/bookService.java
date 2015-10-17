package com.example;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

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
    public String getBookJson() {
        Gson gson = new Gson();
        return  gson.toJson(testBook);
    }

    @GET
    @Path("json")
    @Produces("application/json")
    public String getJson() {
        return  this.getBookJson();
    }

    @GET
    @Path("xml")
    @Produces("application/xml")
    public book getXml() {
        return  testBook;
    }

}


