import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

//************MAIN CLASS***********//
public class PlaceOrder extends JFrame implements ActionListener { //PlaceOrder inherits from the JFrame class (super class inheritance) and implements the ActionListener interface

    //GLOBAL VARIABLES
    static ArrayList<Order> orders = new ArrayList<>();
    public static ArrayList<Order> getOrders() {
        return orders;
    }

    JMenu booksMenu; //books JMenu
    JMenu customerMenu; //customer JMenu
    JMenu ordersMenu;   //orders JMenu
    static JFrame frame = new JFrame("McCarthy Book Store");
    private static JMenuItem aBooks, eBooks, rBooks, sBooks, aCustomers, eCustomers, rCustomers, sCustomers, pOrder, eOrder, rOrder, sOrder;
    JButton order;
    JTextField namejt, dobjt, titlejt, isbnjt, pricejt, orderIdjt;

    //********MAIN METHOD*********//
    public static void main(String[] args) {

        PlaceOrder frame = new PlaceOrder(); //Creating the window
        frame.setVisible(true); //making it visible
    }

    //******CONTRUCTOR*******//
    public PlaceOrder(){

      /*  //reloading the contents of the orders arraylist
        try {
            File p = new File("allOrders2.dat");
            FileInputStream fis = new FileInputStream(p);
            ObjectInputStream ois = new ObjectInputStream(fis);

            orders = (ArrayList<Order>)ois.readObject();
            ois.close();

            for(Order o: orders)
            {
                JOptionPane.showMessageDialog(null,o);
            }
        }

        catch (Exception ox){
            JOptionPane.showMessageDialog(null,"Exception Occurred");
            System.out.println(ox);
        } */

        Container pane;

        setTitle     ("McCarthys Book Store");
        setSize      (1000,600);
        setResizable (false);                   //window properties
        setLocation  (250,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //CONTAINER PANE
        pane = getContentPane();
        pane.setLayout(null);

        //HEADER
        JLabel header = new JLabel("Enter A Customer");
        Font font = new Font("monospaced",Font.PLAIN,24);

        //CUSTOMER SECTION JLABELS AND JTEXTFIELDS
        JLabel name = new JLabel("Name of Customer");
        JLabel dob = new JLabel("Date of Birth");
        namejt = new JTextField(20);
        dobjt = new JTextField(13);

        //ORDER SECTION JLABELS
        JLabel header2 = new JLabel("Order Book");
        Font font2 = new Font("monospaced",Font.PLAIN,24);
        JLabel isbn = new JLabel("ISBN");
        JLabel title = new JLabel("Title");
        JLabel price = new JLabel("Price");
        JLabel orderId = new JLabel("Order Id");

        //ORDER SECTION JTEXTFIELDS
        titlejt = new JTextField(20);
        isbnjt = new JTextField(13);
        pricejt = new JTextField(5);
        orderIdjt = new JTextField(6);
        order = new JButton("Place Order");
        order.addActionListener(this); //ACTION LISTENER FOR ARRAYLIST BUTTON

        //CALLING JMENUBAR COMPONENTS METHODS
        createBooksMenu(); //calling books, customer and orders methods for to add the JMenubar
        createCustomerMenu();
        createOrdersMenu();

        //JMENUBAR
        JMenuBar menu = new JMenuBar(); //creating the JMenubar
        setJMenuBar(menu);
        menu.add(Box.createHorizontalGlue()); //this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing
        //right aligns menu bar

        //ADDING COMPONENTS TO THE JMENUBAR
        menu.setBackground(Color.lightGray);    //added components to the menu bar and their properties
        menu.add(booksMenu);
        menu.add(customerMenu);
        menu.add(ordersMenu);

        //ADDING JLABELS TO THE CONTENT PANE
        pane.add(header);
        pane.add(name);
        pane.add(dob);
        pane.add(header2);
        pane.add(title);
        pane.add(isbn);
        pane.add(price);
        pane.add(orderId);

        //ADDING JTEXTFIELDS TO THE CONTENT PANE
        pane.add(namejt);
        pane.add(dobjt);
        pane.add(titlejt);
        pane.add(isbnjt);
        pane.add(pricejt);
        pane.add(orderIdjt);
        pane.add(order);

        //APPLYING HEADER FONTS
        header.setFont(font);
        header2.setFont(font2);

        //********BEGINNING OF ABSOLUTE POSITIONING**********
        //CUSTOMER SECTION
        Insets insets = pane.getInsets();
        Dimension size = header.getPreferredSize();
        header.setBounds(200 + insets.left, 40 + insets.top,
                size.width, size.height);

        size = name.getPreferredSize();
        name.setBounds(160 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = dob.getPreferredSize();
        dob.setBounds(540 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = namejt.getPreferredSize();
        namejt.setBounds(290 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = dobjt.getPreferredSize();
        dobjt.setBounds(630 + insets.left, 100 + insets.top,
                size.width, size.height);

        //ORDER SECTION

        size = header2.getPreferredSize();
        header2.setBounds(200 + insets.left, 145 + insets.top,
                size.width, size.height);

        size = orderId.getPreferredSize();
        orderId.setBounds(250 + insets.left, 205 + insets.top,
                size.width, size.height);

        size = orderIdjt.getPreferredSize();
        orderIdjt.setBounds( 360+ insets.left, 205 + insets.top,
                size.width, size.height);


        size = title.getPreferredSize();
        title.setBounds(250 + insets.left, 245 + insets.top,
                size.width, size.height);

        size = titlejt.getPreferredSize();
        titlejt.setBounds(360 + insets.left, 245 + insets.top,
                size.width, size.height);

        size = isbn.getPreferredSize();
        isbn.setBounds(250 + insets.left, 285 + insets.top,
                size.width, size.height);

        size = isbnjt.getPreferredSize();
        isbnjt.setBounds( 360+ insets.left, 285 + insets.top,
                size.width, size.height);

        size = price.getPreferredSize();
        price.setBounds(250 + insets.left, 325 + insets.top,
                size.width, size.height);

        size = pricejt.getPreferredSize();
        pricejt.setBounds( 360+ insets.left, 325 + insets.top,
                size.width, size.height);

        size = order.getPreferredSize();
        order.setBounds( 440+ insets.left, 415 + insets.top,
                size.width, size.height);

        //********END OF ABSOLUTE POSITIONING********
    }

//*********ACTION EVENT HANDLING CODE**********//
    public void actionPerformed (ActionEvent e) { //coded with the help of John Brosnan
        if (e.getSource() == aBooks) { //if 'aBooks' is clicked
            JOptionPane.showMessageDialog(null, "Re-directing you to Add Book Page"); //display this message
            AddBook add = new AddBook(); //create an instance of the AddBook class
            add.setVisible(true); //make the AddBook JFrame visible
            this.setVisible(false); //hide the current window i.e. this/PlaceOrder window
        }

        else if (e.getSource() == eBooks) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Edit Book Page");

            EditBook edit = new EditBook();

            edit.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == rBooks) {
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

        else if (e.getSource() == order) { //if 'order' JButton is clicked

            //******VALIDATION*********//

            if (namejt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Customer Name can't be empty");

            } else if (dobjt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth can't be empty");    //if name, dob and orderId JTextfields are empty display their respective messages
            } else if (orderIdjt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Order Id can't be empty");
            }

            else if(orderIdjt.getText().length()!=6) { //if the String in the orderId JTextfield isn't 6 characters in length
                JOptionPane.showMessageDialog(null,"Order Id must be 6 characters in length");
                orderIdjt.setText("");
            }
            else if(!orderIdjt.getText().startsWith("00")){ //if the String in the orderId JTextfield doesn't start with '00'
                JOptionPane.showMessageDialog(null,"Order Id must be in the form of\n\n00xxxx");
                orderIdjt.setText("");

            } else if (titlejt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Title can't be empty");
            } else if (isbnjt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "ISBN can't be empty");  //if the title, isbn and price JTextfields are empty display their respective messages
            } else if (pricejt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Price can't be empty");
            }

            else if(!isbnjt.getText().equals("")) { //if the isbn JTextfield is not empty

                for (int p = 0; p < isbnjt.getText().length(); p++) { //proceed to scan through the contents of the String in the isbn JTextfield using this for loop

                    if (isbnjt.getText().length() > 17 || isbnjt.getText().length() < 17) { //if the String in the isbn JTextfield isn't 17 characters in length
                        JOptionPane.showMessageDialog(null, "ISBN needs to be 17 characters long. \n\nIn the form of \n\n 978-xx-xxxxx-xx-x \n\n OR \n\n 979-xx-xxxxx-xx-x");

                        isbnjt.setText("");
                    }

                    else if (isbnjt.getText().charAt(3) != '-' && isbnjt.getText().charAt(6) != '-' && isbnjt.getText().charAt(12) != '-' && isbnjt.getText().charAt(15) != '-') { //if the 4th, 7th, 13th or 16th character isn't '-'

                        JOptionPane.showMessageDialog(null, "ISBN must be in the form of \n\n 978-xx-xxxxx-xx-x \n\n OR \n\n 979-xx-xxxxx-xx-x");
                        isbnjt.setText("");

                    }

                    else {

                        //saving a new order object to the orders arraylist
                        String name, dob, orderId, title, isbn, price;

                        name = namejt.getText();
                        dob = dobjt.getText();
                        isbn = isbnjt.getText();
                        title = titlejt.getText();
                        price = pricejt.getText();
                        orderId = orderIdjt.getText();


                        ArrayList<Order> orders = PlaceOrder.getOrders();
                        Order order1 = new Order(name, dob, orderId, title, isbn, price);

                        orders.add(order1);

                        //write a loop now to check if the order has been added

                        for (int i = 0; i < orders.size(); i++) {

                            JOptionPane.showMessageDialog(null, orders.get(i).toString());

                        }


                        namejt.setText("");
                        dobjt.setText("");
                        titlejt.setText("");
                        isbnjt.setText("");
                        pricejt.setText("");
                        orderIdjt.setText("");

                        //saving the new order object to the arraylist
                        try {
                            //**********SAVE AN ORDER TO MY ARRAYLIST************//
                            File f = new File("allOrders2.dat");
                            FileOutputStream fos = new FileOutputStream(f);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);

                            oos.writeObject(orders);
                            oos.close();


                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Exception occurred!!!");
                            System.out.println(ex);
                        }
                    }
                }
            }
        }
    }


    //*******JMENUBAR COMPONENTS METHODS********//
    public void createBooksMenu () {

        booksMenu = new JMenu("Books"); //creating books

        aBooks = new JMenuItem("Add Book");
        aBooks.addActionListener(this);
        booksMenu.add(aBooks); //adding the item to the books option in the menu bar

        eBooks = new JMenuItem("Edit Book");
        eBooks.addActionListener(this);
        booksMenu.add(eBooks);

        rBooks = new JMenuItem("Remove Book");
        rBooks.addActionListener(this);
        booksMenu.add(rBooks);

        sBooks = new JMenuItem("Search Books");
        sBooks.addActionListener(this);
        booksMenu.add(sBooks);
    } // end of books menu option

    private void createCustomerMenu () {

        customerMenu = new JMenu("Customers"); //creating books

        aCustomers = new JMenuItem("Add Customer");
        aCustomers.addActionListener(this);
        customerMenu.add(aCustomers); //adding the item to the books option in the menu bar

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

    private void createOrdersMenu () {

        ordersMenu = new JMenu("Orders"); //creating books

        pOrder = new JMenuItem("Add Order");
        pOrder.addActionListener(this);
        ordersMenu.add(pOrder); //adding the item to the books option in the menu bar

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