package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {
    private static  Utils instance;
    private Utils(){
        if(allbooks==null){
            allbooks = new ArrayList<>();
            intiData();
        }
        if(currentlyReadingBooks==null){
            currentlyReadingBooks = new ArrayList<>();
        }
        if(AlreadyReadBooks==null){
            AlreadyReadBooks=new ArrayList<>();
        }
        if(favouriteBooks==null){
            favouriteBooks = new ArrayList<>();
        }

    }
    public static  Utils getInstance(){
        if(instance==null){
            instance = new Utils();
        }
        return instance;
    }
    private static ArrayList<Book> allbooks;
    private static ArrayList<Book> currentlyReadingBooks,AlreadyReadBooks,favouriteBooks;

    private void intiData(){
        //todo: init the intial data
        allbooks.add(new Book(1,"Rich Dad Poor Dad","Robert Kiyosaki",2000,R.drawable.img,"Rich Dad Poor Dad is a 1997 ","Rich Dad Poor Dad is a 1997 book written by Robert T. Kiyosaki "));
        allbooks.add(new Book(2,"Harry Potter","J. K. Rowling",3000,R.drawable.harry_potter,"Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling.","Long Description"));

    }

    public static ArrayList<Book> getAllbooks() {
        return allbooks;
    }


    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return AlreadyReadBooks;
    }

    public static ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public Book getBookById(int id){
        for(Book book : allbooks){
            if(book.getId()==id){
                return book;
            }
        }
        return null;
    }

    public Boolean addInAlreadyReadBooks(Book book){
        return AlreadyReadBooks.add(book);
    }
    public Boolean swap_AlreadyRead_to_CurrentlyReading(Book incomingBook){
        for(Book book : AlreadyReadBooks){
            if(book.getId()==incomingBook.getId()){
                AlreadyReadBooks.remove(book);
            }
        }
        return currentlyReadingBooks.add(incomingBook);
    }
    public Boolean swap_CurrentlyReading_to_AlreadyRead(Book incomingBook){
        for(Book book : currentlyReadingBooks){
            if(book.getId()==incomingBook.getId()){
                currentlyReadingBooks.remove(book);
            }
        }
        return AlreadyReadBooks.add(incomingBook);
    }
    public Boolean addInCurrentlyReadingBooks(Book book){
        return currentlyReadingBooks.add(book);
    }
    public Boolean removeFromAlreadyReadBook(Book book){
        return AlreadyReadBooks.remove(book);
    }


}
