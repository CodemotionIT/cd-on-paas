package com.codemotionworld.cdonpaas;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

public class HelloAcceptanceTest {

    @Test
    public void testGetReturnsHello() {
        String baseUrl = System.getProperty("baseUrl", "http://localhost:8080/cd-on-paas/");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUrl);

        String message = target.path("hello").request().get(String.class);

        assertEquals("Hello World!", message);
    }
}
