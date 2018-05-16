package com.twu.biblioteca.modelManagers;


import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manganges all access and displaying of books
 */
public class BookManager implements LibraryItemManagerInterface {
    public ArrayList<Book> books;

    public BookManager(ArrayList<Book> books) {
        this.books = books;
    }


    public ArrayList<String> getItemsInColumnFormat() {

        ArrayList<String> books = new ArrayList<String>();
        for(Book book : this.books){
            if(!book.isCheckedOut()){
                books.add(book.getBookName() + "     " + book.getBookAuthor()+ "     "+book.getBookYearPublished());
            }
        }
        return books;
    }

    /**
     * List all the avaiable books in the library to System.out
     */
    public void listItems() {
        ArrayList<String> formattedBooks = getItemsInColumnFormat();
        for (String bookString : formattedBooks){
            System.out.println(bookString);
        }
    }

    /**
     * Returns a book from the library if it exists
     * @param inputBook The book that was requested
     * @return LibraryBook Book that matches the request
     */
    public Book getBookFromLibrary(Book inputBook){
        for(Book book : books){
            if(book.is(inputBook) != null){
                return book;
            }
        }
        return null;
    }

    /**
     * Capture the information needed to query a book
     * @return Captured Infomation parsed into a book
     */
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

    public void checkoutItemPressed() {
        Book userBook = this.getBookDetails();
        Book libraryBook = this.getBookFromLibrary(userBook);
        if(libraryBook != null){
            System.out.println(libraryBook.checkout());
        }
        else{
            System.out.println("That book is not available.");

        }
    }

    public void returnItemPressed() {
        Book userBook = this.getBookDetails();
        Book libraryBook = this.getBookFromLibrary(userBook);
        if(libraryBook != null){
            System.out.println(libraryBook.giveBack());
        }
        else{
            System.out.println("That is not a valid book to return.");

        }
    }
}
