package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


import java.io.ByteArrayInputStream;

public class MainMenuTest {
    private MainMenu mainMenu;
    private StartupMessage startupMessage;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();



    @Before
    public void onBefore(){
        startupMessage = new StartupMessage();
        mainMenu = new MainMenu(startupMessage);


    }

    @Test
    public void TestShouldPrintWelcomeMessage(){

        mainMenu.boot();
        assertTrue(systemOutRule.getLog().contains("WELCOME TO BEBLIOTECA"));


    }

    @Test
    public void TestShouldPrintOptionsWhenNotLoggedIn(){

        mainMenu.boot();
        assertTrue(systemOutRule.getLog().contains("1 - List All Books"));
        assertTrue(systemOutRule.getLog().contains("4 - List All Movies"));
        assertTrue(systemOutRule.getLog().contains("7 - Login"));
        assertTrue(systemOutRule.getLog().contains("10 - Exit"));

    }





}
