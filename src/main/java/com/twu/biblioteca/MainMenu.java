package com.twu.biblioteca;

import com.twu.biblioteca.menuItems.*;
import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.modelManagers.MovieManager;
import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private StartupMessage startupMessage;
    private ArrayList <MenuItemBase> menuItems;

    public MainMenu(StartupMessage startupMessage) {
        this.startupMessage = startupMessage;

    }

    private void createMenuItems(){
        BookManager bookManager = this.bookManagerBuilder();
        MovieManager movieManager = this.movieManagerBuilder();
        UserManager userManager = this.userManagerBuilder();


        ManagerListMenuItem bookManagerListMenuItem = new ManagerListMenuItem("1 - List All Books", bookManager,userManager);
        ManagerCheckoutMenuItem bookManagerCheckoutMenuItem = new ManagerCheckoutMenuItem("2 - Checkout A Book", bookManager,userManager);
        ManagerGiveBackMenuItem bookManagerGiveBackMenuItem = new ManagerGiveBackMenuItem("3 - Return A Book", bookManager,userManager);
        ManagerListMenuItem movieManagerListMenuItem = new ManagerListMenuItem("4 - List All Movies",movieManager,userManager);
        ManagerCheckoutMenuItem movieManagerCheckoutMenuItem = new ManagerCheckoutMenuItem("5 - Checkout A Movie", movieManager,userManager);
        ManagerGiveBackMenuItem movieManagerGiveBackMenuItem = new ManagerGiveBackMenuItem("6 - Return A Movie", movieManager,userManager);
        UserManagerLoginMenuItem userManagerLoginMenuItem = new UserManagerLoginMenuItem("7 - Login", userManager);
        UserManagerLogoutMenuItem userManagerLogoutMenuItem = new UserManagerLogoutMenuItem("8 - Logout", userManager);
        UserMangerUserDetailMenuItem userMangerUserDetailMenuItem = new UserMangerUserDetailMenuItem("9 - User Details", userManager);
        ExitMenuItem exitMenuItem = new ExitMenuItem("10 - Exit",userManager);


        menuItems.add(bookManagerListMenuItem);
        menuItems.add(bookManagerCheckoutMenuItem);
        menuItems.add(bookManagerGiveBackMenuItem);
        menuItems.add(movieManagerListMenuItem);
        menuItems.add(movieManagerCheckoutMenuItem);
        menuItems.add(movieManagerGiveBackMenuItem);
        menuItems.add(userManagerLoginMenuItem);
        menuItems.add(userManagerLogoutMenuItem);
        menuItems.add(userMangerUserDetailMenuItem);
        menuItems.add(exitMenuItem);
    }


    public void boot() {
        createMenuItems();
        System.out.println(startupMessage.getStartupMessage());
        outputOptions();
    }

    public void outputOptions() {
        for(MenuItemBase menuItem : menuItems){
            if((menuItem.shouldDisplay())){
                System.out.println(menuItem.getMenuItemName());
            }
        }

    }

    public void waitForInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        this.handleInput(input);

    }

    public void handleInput(String input){
        try{
            Integer intInput = Integer.parseInt(input);
            if(intInput > menuItems.size() + 1){
                System.out.println("Select A Valid Option");
                return;
            }
            MenuItemBase menuItemBase = menuItems.get(Integer.parseInt(input) - 1);
            menuItemBase.wasSelected();

        }
        catch (NumberFormatException exception){
            System.out.println("Select A Valid Option");
        }
    }



    private BookManager bookManagerBuilder(){
        menuItems = new ArrayList<MenuItemBase>();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);
        return new BookManager(books);
    }

    private MovieManager movieManagerBuilder(){
        Movie movie = new Movie("The Magnificent Seven", "John Sturges", 1960, 7);
        ArrayList <Movie> movies = new ArrayList<Movie>();
        movies.add(movie);
        return new MovieManager(movies);

    }

    private UserManager userManagerBuilder(){
        User user1 = new User("123-4567","Wayne Irwin", "wayne@gmail.com", "99999999", "hunter42");
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        return new UserManager(users);

    }


}
