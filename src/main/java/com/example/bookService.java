package com.example;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.glassfish.jersey.server.JSONP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.logging.*;


@Path("book")
public class bookService {

    private static Book testBook;
    private static boolean isInit = false;
   // private static List<Book> list = new ArrayList<Book>();
    private static Map<Integer, Book> listBooks = new HashMap<Integer, Book>();
    private static Logger logger = Logger.getLogger("com.wombat.nose");

    public bookService(){
        logger.log(Level.INFO, "bookService()");
        if(isInit == false){
            testBook = new Book("War and peace","Tolstoy L.N.", 1820);
 //           list.add( new Book("War and peace","Tolstoy L.N.", 1820));
//            list.add( new Book("Monday start in Saturday","Strugatskiy brothers", 1960));
//            list.add( new Book("HarryPotter","Unknown", 1990));

        //  listBooks.put(1, new Book("War and peace","Tolstoy L.N.", 1820);
            addBook(new Book("War and peace","Tolstoy L.N.", 1820));
            addBook(new Book("Monday start in Saturday","Strugatskiy brothers", 1960));
            addBook(new Book("HarryPotter","Unknown", 1990));

            isInit = true;
            }
    }

    @GET
    @Produces("application/json")
    public String getAllBookJson()
    {
        Gson gson = new Gson();
        //return  gson.toJson(list);
        return  gson.toJson(listBooks.values());
    }
    @GET
    @Path("{ID}")
    @Produces("application/json")
    public String getBookJson(@PathParam("ID") int ID)
    {
        String response;
        Gson gson = new Gson();
        try{
//            response = gson.toJson(list.get(ID));
            Book book = listBooks.get(ID);
            response = gson.toJson(book);

        }catch (Exception ex){
            response = getResponce(false, ex.getMessage()).toString();
        }
        return response;
    }

    @POST
    @Produces("application/json")
    public String postBookJson(@FormParam("ID") Integer ID, @FormParam("name") String name, @FormParam("author") String author, @FormParam("year") int year)
    {
        String response;
        logger.log(Level.INFO, "postBookJson()" + "ID : "+ ID + " name : " + name + " author : " + author + " year : " + year );

        //JSONP

        try{
            //list.add(new Book(name, author, year));
            if(listBooks.containsKey(ID)){
 //               listBooks.replace(ID,new Book(name, author, year) );
                listBooks.replace(ID,new Book(ID,name, author, year) );
            }else{
                addBook(new Book(name, author, year));
            }
            response = getResponce(true).toString();
        }catch (Exception ex){
            response = getResponce(false, ex.getMessage()).toString();
        }
        return  response;
    }

    @PUT
    @Produces("application/json")
    public String putBookJson(@QueryParam("name") String name)
    {
         return  "{PUT name:"+ name + "}"; //,Author:POST,CreateYear:1820POST}";
    }

    @Path("{ID}")
    @DELETE
    @Produces("application/json")
    public String deleteBookJson(@PathParam("ID") int ID)
    {

        String response;
        Gson gson = new Gson();
        try{
          //  list.remove(ID);
            listBooks.remove(ID);
            response = getResponce(true).toString();
        }catch (Exception ex){
            response = getResponce(false, ex.getMessage()).toString();
        }
        return response;
    }

    //-------------------------------------------------------------------------------------

    @GET
    @Path("add")
    @Produces("application/json")
    public String getBookJson(@QueryParam("data") String data )
    {
        // [{"Name":"Mickey","Author":"Mouse","CreateYear":1233},{"Name":"222","Author":"Mouse33","CreateYear":12332}]

           Gson gson = new Gson();
           Book book_temp = gson.fromJson(data, new TypeToken<Book>(){}.getType());
     //   List<book> tmpList = new ArrayList<book>();
     //   tmpList = gsonTmp.fromJson(gson.toJson(list), new TypeToken<List<book>>(){}.getType());

        //list.add(book_temp);
        return "OK!"; // response.toJSONString();
    }

    @GET
    @Path("json")
    @Produces("application/json")
    public Book getJson() {
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
    public Book getXml() {
        return  testBook;
    }


    @GET
    @Path("jsonxml")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Book getJasonXml() {
        return  testBook;
    }


    private JsonObject getResponce(boolean result){
        return getResponce(result, result ? "No error" : "Unknown error" );
    }
    private JsonObject getResponce(boolean result, String ErrorText){
        JsonObject json = new JsonObject();
        json.addProperty("Error",ErrorText);

        return json;
    }


    private void addBook(Book newBook){
        int maxId=0;
        for(Book book : listBooks.values()){
             if(book.id >maxId){
                 maxId = book.id;
             }
        }

        maxId++;
        newBook.id = maxId;
        listBooks.put(maxId, newBook);
    }
}


