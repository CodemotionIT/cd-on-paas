package com.codemotionworld.cdonpaas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.codemotionworld.cdonpaas.Hello;

public class HelloTest {

    @Test
    public void testSayReturnsHello() {
        Hello hello = new Hello();

        assertEquals("Hello World!", hello.say());
    }
}
