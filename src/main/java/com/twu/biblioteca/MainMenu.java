package com.twu.biblioteca;

import com.twu.biblioteca.menuItems.*;
import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private StartupMessage startupMessage;
    private ArrayList <MenuItemBase> menuItems;

    public MainMenu(StartupMessage startupMessage) {
        this.startupMessage = startupMessage;

    }

    private void createMenuItems(){
        menuItems = new ArrayList<MenuItemBase>();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);
        BookManager bookManager = new BookManager(books);


        BookManagerListMenuItem bookManagerListMenuItem = new BookManagerListMenuItem("1 - List All Books", bookManager);
        BookManagerCheckoutMenuItem bookManagerCheckoutMenuItem = new BookManagerCheckoutMenuItem("2 - Checkout A Book", bookManager);
        BookManagerGiveBackMenuItem bookManagerGiveBackMenuItem = new BookManagerGiveBackMenuItem("3 - Return A Book", bookManager);
        ExitMenuItem exitMenuItem = new ExitMenuItem("4 - Exit");
        menuItems.add(bookManagerListMenuItem);
        menuItems.add(bookManagerCheckoutMenuItem);
        menuItems.add(bookManagerGiveBackMenuItem);
        menuItems.add(exitMenuItem);
    }


    public void boot() {
        createMenuItems();
        System.out.println(startupMessage.getStartupMessage());
        outputOptions();
    }

    public void outputOptions() {
        for(MenuItemBase menuItem : menuItems){
            System.out.println(menuItem.getMenuItemName());

        }

    }

    public void optionPressed(int i) {

    }

    public void waitForInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        MenuItemBase menuItemBase = menuItems.get(Integer.parseInt(input) - 1);
        menuItemBase.wasSelected();



    }
}
