package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;


public class BookManager  {
    public ArrayList<Book> books;

    public BookManager(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<String> getBooksInColumnFormat() {
        ArrayList<String> books = new ArrayList<String>();
        for(Book book : this.books){
            if(!book.isCheckedOut()){
                books.add(book.getBookName() + "     " + book.getBookAuthor()+ "     "+book.getBookYearPublished());
            }
        }
        return books;
    }

    public void listBooks() {
        ArrayList<String> formattedBooks = getBooksInColumnFormat();
        for (String bookString : formattedBooks){
            System.out.println(bookString);
        }
    }

    public String getBookDetailsAndCheckout() {
        Book inputBook = getBookDetails();
        Book libraryBook = getBookFromLibrary(inputBook);
        if(libraryBook != null){
            return libraryBook.checkout();

        }
        return "That book is not available.";

    }

    public String getBookDetailsAndGiveBack() {
        Book inputBook = getBookDetails();
        Book libraryBook = getBookFromLibrary(inputBook);
        if(libraryBook != null){
            return libraryBook.giveBack();

        }
        return "That is not a valid book to return.1";    }

    public Book getBookFromLibrary(Book inputBook){
        for(Book book : books){
            if(book.is(inputBook) != null){
                return book;
            }
        }
        return null;
    }

    public Book getBookDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Book Name: ");
        String bookName = scanner.nextLine();
        System.out.print("Author's Name: ");
        String authorName = scanner.nextLine();
        System.out.print("Publiction Year: ");
        Integer publicationYear = Integer.parseInt(scanner.nextLine());
        return new Book(bookName, authorName, publicationYear);
    }
}
