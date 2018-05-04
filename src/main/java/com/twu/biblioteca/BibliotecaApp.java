package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
//        System.out.println("Hello, world!");
        StartupMessage startupMessage = new StartupMessage();
        MainMenu mainMenu = new MainMenu(startupMessage);
        mainMenu.boot();
        mainMenu.waitForInput();

        while (true){
            mainMenu.outputOptions();
            mainMenu.waitForInput();
        }
    }
}
