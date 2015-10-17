package com.example;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("MyJaxbBean")
public class MyJaxbBeanService {

        @Path("json")
        @GET @Produces("application/json")
        public MyJaxbBean getMyBook() {
            return new MyJaxbBean("Agamemnon", 32);
        }

        @Path("xml")
        @GET @Produces("application/xml")
        public MyJaxbBean getMyBean() {
            return new MyJaxbBean("Agamemnon", 32);
        }
    }

