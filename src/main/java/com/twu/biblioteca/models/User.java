package com.twu.biblioteca.models;

public class User {
    private String libraryNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

    public User(String libraryNumber, String name, String email, String phoneNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public Boolean authenticate(String libraryNumber, String password) {
        return(this.getLibraryNumber().equals(libraryNumber)) && (this.getPassword().equals(password));


    }

    public void printDetails() {
        System.out.println(this.getName() + "     " + this.getEmail()+ "     " + this.getPhoneNumber());
    }
}
