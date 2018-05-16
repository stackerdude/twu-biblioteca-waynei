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

    /**
     * Called when the item in this manager wants to be borrowed
     */

    public void checkoutItemPressed();

    /**
     * Called when the item is this manager wants to be given back
     */

    public void returnItemPressed();




}
