import java.io.*;

/**
*
* @author Cian McCarthy
 * Order is an instantiable class which implements the serializable interface so Order pbjects can be saved to a file
*
* */
public class Order implements Serializable {

    /**
     * Attribute of type String, OrderId
     * Attribute of type Book, book1
     * Attribute of type Customer, customer
     */
    private String orderId;
    private Book book1;
    private Customer cust;

    /**
     * NO ARGUMENT CONSTRUCTOR
     *
     */

    public Order(){
        this.orderId = "Unknown";
        this.book1 = new Book();
        this.cust = new Customer();
    }

/**
 * MULTIPLE ARGUMENT CONSTRUCTOR
 *
 * */

    /**
     * desc
     * @param orderId this is the order id
     * @param book1
     */
    public Order(String orderId, Book book1) {
        this.book1 = new Book();
       this.orderId = orderId;
       this.cust = new Customer();

    }

    /**
     *
     * @param book1
     */
    public Order(Book book1) {
        setBook1(book1);
    }
    /**
     * MULTIPLE ARGUMENT CONSTRUCTOR
     * @param name
     * @param dob
     * @param orderId
     * @param title
     * @param isbn
     * @param price
     */

    public Order(String name, String dob, String orderId, String title, String isbn, String price) {

        this.cust = new Customer(dob, name);
        this.orderId = orderId;
        this.book1 = new Book(title, isbn, price);

    }

/* ACCESSOR METHODS*/

    /**
     * Accessor METHOD
     * @return book1
     */
    public Book getBook1() {
        return book1;
    }


    /**
     * Accessor METHOD
     * @return cust
     */

    public Customer getCust() {
        return cust;
    }


    /**
     * Accessor METHOD
     * @return orderId
     */

    public String getOrderId() {
        return orderId;
    }

    /**
     * MUTATOR METHODS*
     *
     * */

    public void setBook1(Book book1) {
        this.book1 = book1;
    }

    /**
     *
     * @return toString()
     */
    public String toString() {
        return "\n\nCustomer Name: " + getCust().getName() + "\n\nDate of Birth: " + getCust().getDob()+ "\n\nOrder Id: " + getOrderId() + "\n\nTitle: " + getBook1().getTitle()+ "\n\nISBN: " + getBook1().getIsbn() + "\n\nPrice: " + getBook1().getPrice()  ;
    }

}
