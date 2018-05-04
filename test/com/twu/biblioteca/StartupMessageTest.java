package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;



public class StartupMessageTest {

    @Test
    public void TestStartupMessageShouldBeWelcome(){

        String message  = "WELCOME TO BEBLIOTECA";
        StartupMessage startupMessage = new StartupMessage();
        assertEquals(message, startupMessage.getStartupMessage());

    }


}
