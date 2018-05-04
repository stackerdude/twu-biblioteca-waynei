package com.twu.biblioteca;

abstract public class LibraryItemBase {

   protected abstract String getSuccessCheckout();
   protected abstract String getErrorCheckout();
   protected abstract String getGiveBackSuccess();
   protected abstract String getGiveBackError();




    private String libraryItemName;
    private String libraryItemCreator;
    private Integer libraryItemRelease;
    private boolean checkedOut;



    public LibraryItemBase(String libraryItemName, String libraryItemCreator, Integer libraryItemRelease) {
        this.libraryItemName = libraryItemName;
        this.libraryItemCreator = libraryItemCreator;
        this.libraryItemRelease = libraryItemRelease;
        this.checkedOut = false;

    }

    public String getLibraryItemName() {
        return libraryItemName;
    }

    public String getLibraryItemCreator() {
        return libraryItemCreator;
    }

    public Integer getLibraryItemRelease() {
        return libraryItemRelease;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }


    public String checkout() {
        if (this.isCheckedOut()){
            return getErrorCheckout();
        }

        this.checkedOut = true;
        return getSuccessCheckout();
    }

    public String giveBack() {
        if(!this.isCheckedOut()){
            return getGiveBackError();
        }
        this.checkedOut = false;
        return getGiveBackSuccess();
    }

}
