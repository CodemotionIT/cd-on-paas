package com.codemotionworld.cdonpaas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloResource {

    @Produces("text/plain")
    @GET
    public String handleGreeting() {
        Hello hello = new Hello();
        return hello.say();
    }
}
