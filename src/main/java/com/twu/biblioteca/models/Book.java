package com.twu.biblioteca.models;

public class Book extends LibraryItemBase{
    public Book(String bookName, String bookAuthor, Integer bookYearPublished) {
        super(bookName, bookAuthor, bookYearPublished);
    }


    public String getBookName() {
        return this.getLibraryItemName();
    }

    public String getBookAuthor() {
        return this.getLibraryItemCreator();
    }

    public Integer getBookYearPublished() {
        return this.getLibraryItemRelease();
    }
    protected String getSuccessCheckout() {
        return "Thank you! Enjoy the book.";
    }

    protected String getErrorCheckout() {
        return "That book is not available.";
    }

    protected String getGiveBackSuccess() {
        return "Thank you for returning the book.";
    }

    protected String getGiveBackError() {
        return "That is not a valid book to return.";
    }

    public Book is(Book book){
        if((book.getBookName().equals(this.getBookName())) && (book.getBookAuthor().equals(this.getBookAuthor()))
                && (book.getBookYearPublished().equals(this.getBookYearPublished()))){
            return this;
        }
        return null;
    }
}
