package nl.quintor.jeerestdemo;

import jakarta.ws.rs.*;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Path("/result")
    @Produces("application/json")
    public String hello() {
        return "{\n" +
                "  \"name\": \"Super Mario Odyssey\",\n" +
                "  \"price\": \"blugh\",\n" +
                "  \"platform\": \"Switch\"\n" +
                "}";
    }

}
