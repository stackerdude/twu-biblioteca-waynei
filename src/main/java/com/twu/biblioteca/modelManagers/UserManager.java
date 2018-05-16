package com.twu.biblioteca.modelManagers;

import com.twu.biblioteca.models.User;

import java.util.ArrayList;
import java.util.Scanner;


public class UserManager {

    public ArrayList<User> users;
    private Boolean loggedIn;
    private User loggedInUser;

    public UserManager(ArrayList<User> users) {
        this.users = users;
        loggedIn = false;
    }


    /**
     * Capture the information needed to login a user
     */
    public User getUserDetailsAndLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Library Number: ");
        String libraryNumber = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        return  authenticateDetails(libraryNumber, password);
    }

    /**
     * Attempts to login a user
     * @param libraryNumber
     * @param password
     * @return
     */
    public User authenticateDetails(String libraryNumber, String password) {
        for (User user : this.users) {
            if (user.authenticate(libraryNumber, password)) {

                return user;
            }
        }
        return null;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
        if(!loggedIn){
            this.loggedInUser  = null;
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
