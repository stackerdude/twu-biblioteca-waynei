package com.twu.biblioteca.modelManagers;

import com.twu.biblioteca.models.LibraryItemBase;

import java.util.ArrayList;

abstract public class ManagerBase {


    abstract LibraryItemBase getItemDetails();
    abstract void listItems();
    abstract ArrayList<String> getItemsInColumnFormat();


}
