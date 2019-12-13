import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

//**************MAIN CLASS**************//
public class AddBook extends JFrame implements ActionListener { //AddBook inherits from the JFrame class (super class inheritance) and implements the ActionListener interface

    //GLOBAL VARIABLES
    static ArrayList<Book> books = new ArrayList<>(); //declares the ArrayList (of type <Book>) books

    public static ArrayList<Book> getBooks() {  //ArrayList Getters
        return books;
    } //gets the ArrayList books

    JMenu booksMenu; //books JMenu global variable
    JMenu customerMenu; //customer JMenu global variable
    JMenu ordersMenu;   //orders JMenu global variable
    static JFrame frame = new JFrame("McCarthy Book Store");
    private static JMenuItem aBooks, eBooks, rBooks, sBooks, aCustomers, eCustomers, rCustomers, sCustomers, pOrder, eOrder, rOrder, sOrder;  //global variables for JMenuItems
    private static JButton add;// view; //global variable for button that triggers that adds book to the arraylist
    JTextField titlejt, authorjt, isbnjt, pagesjt, pricejt; //global variables for textboxes

    //*******************CONSTRUCTOR********************//
    public AddBook() {

        //loading up the data from the arraylist  // coded with the help of John Brosnan
        try {
            File p = new File("allBooks2.dat"); //loads the File allBooks2.dat which the ArrayList is saved to
            FileInputStream fis = new FileInputStream(p); //instances of FileInputStream and ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(fis);

            books = (ArrayList<Book>)ois.readObject(); //reading the objects in the ArrayList
            ois.close();

            for(Book b: books) //for loop used to display the contents of the ArrayList
            {
                JOptionPane.showMessageDialog(null,b);
            }
        }

        catch (Exception ox){ //exception for the try catch. If the try fails...
            JOptionPane.showMessageDialog(null,"Exception Occurred"); //display this message/exception
            System.out.println(ox);
        }



        Container pane;  //creating the local variable for the content pane

        setTitle("McCarthys Book Store");
        setSize(1000, 600);
        setResizable(false);                   //WINDOW PROPERTIES
        setLocation(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //CONTENT PANE AND HEADER LABEL
        pane = getContentPane();  //getting the content pane
        pane.setLayout(null); //setting the layout to null for absolute positioning
        JLabel header = new JLabel("Add A Book"); //header label
        Font font = new Font("monospaced", Font.PLAIN, 24);//header font

        //JLABELS
        JLabel title = new JLabel("Title"); //title label
        JLabel author = new JLabel("Author");
        JLabel isbn = new JLabel("ISBN");
        JLabel pages = new JLabel("Number of Pages");
        JLabel price = new JLabel("Price");

        //JTEXTFIELDS
        titlejt = new JTextField(20); //title JTextField
        authorjt = new JTextField(18);
        isbnjt = new JTextField(14);
        pagesjt = new JTextField(4);
        pricejt = new JTextField(6);

        //JBUTTONS
        add = new JButton("Add Book"); //arraylist button (DECLARED GLOBALLY)
        add.addActionListener(this); //actionlistener for add books button(this)

        //JMENU METHODS
        createBooksMenu(); //calling JMenuBar components methods
        createCustomerMenu();
        createOrdersMenu();

        JMenuBar menu = new JMenuBar(); //creating an instance of the JMenuBar class
        setJMenuBar(menu); //setting the JMenuBar to the variable name 'menu'
        menu.add(Box.createHorizontalGlue()); //right aligning the JMenuBar. this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing


        menu.setBackground(Color.lightGray);    //setting the JMenuBar background color to grey
        menu.add(booksMenu); //adding the JMenu components to the JMenuBar
        menu.add(customerMenu);
        menu.add(ordersMenu);

        header.setFont(font); //applying the font to the header

//********ADDING THE JTEXTFIELDS, JLABELS AND JBUTTONS TO THE CONTENT PANE**********//
        pane.add(titlejt);
        pane.add(authorjt);
        pane.add(isbnjt);
        pane.add(pagesjt);
        pane.add(pricejt);
        pane.add(header);
        pane.add(title);
        pane.add(author);
        pane.add(isbn);
        pane.add(pages);
        pane.add(add);
        pane.add(price);

        //***********BEGINNING OF ABSOLUTE POSITIONING*********************
        Insets insets = pane.getInsets();   //creating an instance of the insets class and applying it to the content pane
        Dimension size = header.getPreferredSize(); //using the getPrefferedSize(pre-written method) to create a suitable size for the visit store button
        header.setBounds(200 + insets.left, 40 + insets.top, //setting the dimensions
                size.width, size.height);

        size = titlejt.getPreferredSize();
        titlejt.setBounds(400 + insets.left, 100 + insets.top,
                size.width, size.height);
        size = title.getPreferredSize();
        title.setBounds(325 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = authorjt.getPreferredSize();
        authorjt.setBounds(400 + insets.left, 150 + insets.top,        // THIS CODE WAS FOUND ON https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/AbsoluteLayoutDemoProject/src/layout/AbsoluteLayoutDemo.java
                                                                        // https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
                size.width, size.height);
        size = author.getPreferredSize();
        author.setBounds(325 + insets.left, 150 + insets.top,
                size.width, size.height);

        size = isbnjt.getPreferredSize();
        isbnjt.setBounds(400 + insets.left, 200 + insets.top,   //insets act as borders
                size.width, size.height);
        size = isbn.getPreferredSize();
        isbn.setBounds(325 + insets.left, 200 + insets.top,
                size.width, size.height);

        size = pagesjt.getPreferredSize();
        pagesjt.setBounds(400 + insets.left, 250 + insets.top,    //getPreferredSize() is a pre written method that gives a suitable size to the components
                size.width, size.height);
        size = pages.getPreferredSize();
        pages.setBounds(256 + insets.left, 250 + insets.top,
                size.width, size.height);

        size = pricejt.getPreferredSize();
        pricejt.setBounds(400 + insets.left, 300 + insets.top,    //getPreferredSize() is a pre written method that gives a suitable size to the components
                size.width, size.height);
        size = price.getPreferredSize();
        price.setBounds(325 + insets.left, 300 + insets.top,
                size.width, size.height);

        size = add.getPreferredSize();
        add.setBounds(400 + insets.left, 375 + insets.top,
                size.width, size.height);

        //*****************END OF ABSOLUTE POSITIONING********************

    }

    public void actionPerformed(ActionEvent e) { //event handler
        if (e.getSource() == aBooks) { //   if 'aBooks' button is clicked
            JOptionPane.showMessageDialog(null, "Re-directing you to Add Book Page"); //display this message

            AddBook add = new AddBook(); //create a new instance of AddBook class

            add.setVisible(true); //set AddBooks JFrame window to visible
            this.setVisible(false); //hide the current page i.e. this page
        }

        else if (e.getSource() == eBooks) { //if 'eBooks' button is clicked
            JOptionPane.showMessageDialog(null, "Re-directing you to Edit Book Page"); //display this message

            EditBook edit = new EditBook(); //create an instance of the EditBook class

            edit.setVisible(true); //set the EditBook JFrame to visible
            this.setVisible(false); //hide the current page i.e. this/AddBook page
        }

        else if (e.getSource() == rBooks) {//and so on......
            JOptionPane.showMessageDialog(null, "Re-directing you to Remove Book Page");

            RemoveBook remove = new RemoveBook();

            remove.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == sBooks) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Search Book Page");

            SearchBook search = new SearchBook();

            search.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == aCustomers) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Add Customer Page");

            AddCustomer addCustomer = new AddCustomer();

            addCustomer.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == eCustomers) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Edit Customer Page");

            EditCustomer editCustomer = new EditCustomer();

            editCustomer.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == rCustomers) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Remove Customer Page");

            RemoveCustomer removeCustomer = new RemoveCustomer();

            removeCustomer.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == sCustomers) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Search Customer Page");

            SearchCustomer searchCustomer = new SearchCustomer();

            searchCustomer.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == pOrder) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Place Order Page");

            PlaceOrder placeOrder = new PlaceOrder();

            placeOrder.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == eOrder) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Edit Order Page");

            EditOrder editOrder = new EditOrder();

            editOrder.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == rOrder) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Remove Order Page");

            RemoveOrder removeOrder = new RemoveOrder();

            removeOrder.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == sOrder) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Search Order Page");

            SearchOrder searchOrder = new SearchOrder();

            searchOrder.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == add) { //if 'add book' JButton is clicked

//****************VALIDATION*******************//

            if (titlejt.getText().equals("")) { //if the JTextfield for title is empty
              JOptionPane.showMessageDialog(null, "Title can't be empty"); //display this message
            }

            else if(authorjt.getText().equals("")){ //or else if the JTextfield for author is empty
                JOptionPane.showMessageDialog(null,"Author can't be empty"); //display this message
            }

            else if(isbnjt.getText().equals("")){ //.................
                JOptionPane.showMessageDialog(null,"ISBN can't be empty");//.................
            }

            else if(!isbnjt.getText().equals("")) { //or else if the ISBN is not empty

                for (int p = 0; p < isbnjt.getText().length(); p++) { //scan through the contents of the ISBN JTextfield using a for loop

                    if (isbnjt.getText().length() > 17 || isbnjt.getText().length() < 17) { //if the ISBN isn't 17 characters long
                        JOptionPane.showMessageDialog(null, "ISBN needs to be 17 characters long. \n\nIn the form of \n\n 978-xx-xxxxx-xx-x \n\n OR \n\n 979-xx-xxxxx-xx-x"); //dislplay this message

                        isbnjt.setText(""); //reset the JTextfield
                    }

                    else if (isbnjt.getText().charAt(3) != '-' && isbnjt.getText().charAt(6) != '-' && isbnjt.getText().charAt(12) != '-' && isbnjt.getText().charAt(15) != '-') { //if the 4th, 7th, 13th or 15th characters aren't a '-'

                        JOptionPane.showMessageDialog(null, "ISBN must be in the form of \n\n 978-xx-xxxxx-xx-x \n\n OR \n\n 979-xx-xxxxx-xx-x"); //display this message
                        isbnjt.setText(""); //reset the JTextfield

                    }

                    else {

                        String title, author, isbn; //declaring variables
                        title = titlejt.getText(); //getting the text from their respective JTextfields
                        author = authorjt.getText();
                        isbn = isbnjt.getText();
                        String pages = pagesjt.getText();
                        Integer.parseInt(pages); //converting the String pages to an integer
                        String price = pricejt.getText();
                        Double.parseDouble(price); //converting the String price to a double


                        ArrayList<Book> books = AddBook.getBooks(); //getting the ArrayList, books
                        Book b1 = new Book(title, author, isbn, pages, price); //creating a new book using my instantiable class 'Book' (b1) and adding to them

                        books.add(b1); //adding my new book object to my books arraylist




                        for (int i = 0; i < books.size(); i++) { //for loop used to scan through the arraylist to check if my new book object has been added
                            JOptionPane.showMessageDialog(null, books.get(i).toString());
                        }

                        //resetting all the JTextfields after the new book has been added
                        titlejt.setText("");
                        authorjt.setText("");
                        isbnjt.setText("");
                        pagesjt.setText("");
                        pricejt.setText("");

                        //saving my new book object to the arraylist        //coded with the help of John Brosnan
                        try {
                            //**********TRYING TO SAVE A BOOK TO MY ARRAYLIST************//
                            File f = new File("allBooks2.dat"); //creating the new file to save to
                            FileOutputStream fos = new FileOutputStream(f); //creating the output stream to the file
                            ObjectOutputStream oos = new ObjectOutputStream(fos); //creating the object output stream and connecting it to the file output stream which takes the object to the file

                            oos.writeObject(books); //writing my books array to the object output stream
                            oos.close(); //closing the stream

                        }
                        catch (Exception ex) {//exception code if saving fails
                            System.out.println("Exception occurred");
                            System.out.println(ex);
                        }

                    }
                }
            }
        }
    }

    public void createBooksMenu() { //coded with the help of John Brosnan

        booksMenu = new JMenu("Books"); //creating 'books' in the JMenuBar

        aBooks = new JMenuItem("Add Book");//adding 'aBooks' (Add Book) JMenuItem to the 'books' JMenu dropdown list
        aBooks.addActionListener(this); //adding an action listener to 'aBooks' (Add Book)
        booksMenu.add(aBooks); //adding the JMenuItem to the books option in the menu bar

        eBooks = new JMenuItem("Edit Book");
        eBooks.addActionListener(this);
        booksMenu.add(eBooks);

        rBooks = new JMenuItem("Remove Book");
        rBooks.addActionListener(this);
        booksMenu.add(rBooks);

        sBooks = new JMenuItem("Search Books");
        sBooks.addActionListener(this);
        booksMenu.add(sBooks);
    }                                        //Same process for 'Customers' and 'Orders'

    private void createCustomerMenu() {

        customerMenu = new JMenu("Customers"); //creating customers

        aCustomers = new JMenuItem("Add Customer");
        aCustomers.addActionListener(this);
        customerMenu.add(aCustomers);

        eCustomers = new JMenuItem("Edit Customer");
        eCustomers.addActionListener(this);
        customerMenu.add(eCustomers);

        rCustomers = new JMenuItem("Remove Customer");
        rCustomers.addActionListener(this);
        customerMenu.add(rCustomers);

        sCustomers = new JMenuItem("Search Customers");
        sCustomers.addActionListener(this);
        customerMenu.add(sCustomers);
    }

    private void createOrdersMenu() {

        ordersMenu = new JMenu("Orders"); //creating orders

        pOrder = new JMenuItem("Add Order");
        pOrder.addActionListener(this);
        ordersMenu.add(pOrder);

        eOrder = new JMenuItem("Edit Order");
        eOrder.addActionListener(this);
        ordersMenu.add(eOrder);

        rOrder = new JMenuItem("Remove Order");
        rOrder.addActionListener(this);
        ordersMenu.add(rOrder);

        sOrder = new JMenuItem("Search Orders");
        sOrder.addActionListener(this);
        ordersMenu.add(sOrder);
    }
}


