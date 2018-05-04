package com.twu.biblioteca;

public class Book {
    private String bookName;
    private String bookAuthor;
    private Integer bookYearPublished;
    private boolean checkedout;

    private final String SUCCESS_CHECKOUT = "Thank you! Enjoy the book.";
    private final String ERROR_CHECKOUT = "That book is not available.";
    private final String SUCCESS_RETURN = "Thank you for returning the book.";
    private final String ERROR_RETURN = "That is not a valid book to return.";


    public Book(String bookName, String bookAuthor, Integer bookYearPublished) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYearPublished = bookYearPublished;
        this.checkedout = false;

    }

    public String checkout() {
        if (this.isCheckedout() == true){
            return ERROR_CHECKOUT;
        }

        this.checkedout = true;
        return SUCCESS_CHECKOUT;
    }

    public String giveBack() {
        if(this.isCheckedout() == false){
            return ERROR_RETURN;
        }
        this.checkedout = false;
        return SUCCESS_RETURN;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Integer getBookYearPublished() {
        return bookYearPublished;
    }

    public boolean isCheckedout() {
        return checkedout;
    }

    public Book is(Book book){
        if((book.getBookName().equals(this.getBookName())) && (book.getBookAuthor().equals(this.getBookAuthor()))
                && (book.getBookYearPublished().equals(this.getBookYearPublished()))){
            return this;
        }
        return null;
    }
}
