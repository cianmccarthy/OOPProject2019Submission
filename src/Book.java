import java.io.*;

/*
 * The Book class is an instantiable class which implements the serializable interface so book objects can be saved to a file
 *
 * */
public class Book implements Serializable{

/*
* TRUE ENCAPSULATION
*
* */
    protected String title;
    protected String isbn;
    private String author;
    private String pages;
    protected String price;

/**
 *
 * NO ARGUMENT CONSTRUCTOR
 *
 * */

    public Book() {
        /**/
        this.author="No Author";
        this.pages = "Unknown";
        this.pages = "Unknown";
        this.price="Unknown";
    }

   /**
    * MULTIPLE ARGUMENT CONSTRUCTOR
    * */

    public Book(String title, String isbn, String price) {
        setTitle(title);
        setIsbn(isbn);
        setPrice(price);
    }

/**
 * ACCESSOR AND MUTATOR METHODS
 * */

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {

        return isbn;
    }

    public void setIsbn(String isbn) {

        this.isbn = isbn;
    }

    public String getPages() {

        return pages;
    }

    public void setPages(String pages) {

        this.pages = pages;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }

    /**
     * MULTIPLE ARGUMENT CONSTRUCTOR
     * */

    public Book(String title, String author,  String isbn,String pages, String price) {

        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        setPages(pages);
        setPrice(price);
    }

    /**
     * TO STRING METHOD
     * */

    public String toString() {
        return "Title: " + getTitle() + "\n\nAuthor: " + getAuthor() + "\n\nISBN: " + getIsbn() + "\n\nNo. of Pages: " + getPages() + "\n\nPrice: " + getPrice();
    }

}






