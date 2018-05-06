package com.twu.biblioteca.modelManagers;


import java.util.ArrayList;

/**
 *Interface that all LibraryItem managers need to inplement
 */
public interface LibraryItemManagerInterface {
    /**
     * Format the library into an array of string, each string is a serialisation of one LibraryItem
     * @return ArrayList
     */
    public ArrayList<String> getItemsInColumnFormat();
    /**
     * List all the avaiable libraryItems in the library to System.out
     */
    public void listItems();
}
