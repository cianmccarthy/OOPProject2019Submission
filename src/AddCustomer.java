import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

//**************MAIN CLASS**************//
public class AddCustomer extends JFrame implements ActionListener { //AddCustomer inherits from the JFrame class (super class inheritance) and implements the ActionListener interface

    static ArrayList<Customer> customers = new ArrayList<>(); //declares the ArrayList (of type <Customer>) customers
    public static ArrayList<Customer> getCustomers() {
        return customers;
    } //gets the ArrayList customers

  //GLOBAL VARIABLES
    JMenu booksMenu;
    JMenu customerMenu;
    JMenu ordersMenu;
    static JFrame frame = new JFrame("McCarthy Book Store");
    private static JMenuItem aBooks, eBooks, rBooks, sBooks, aCustomers, eCustomers, rCustomers, sCustomers, pOrder, eOrder, rOrder, sOrder;
    JTextField namejt, dobjt, addressLine1jt, addressLine2jt, townjt, countyjt, phonejt;
    private static JButton add;

    //********CONSTRUCTOR*********//
    public AddCustomer() {

        //reloading the contents of the customers arraylist //coded with the help of John Brosnan
        try {
            File p = new File("allCustomers2.dat");
            FileInputStream fis = new FileInputStream(p);
            ObjectInputStream ois = new ObjectInputStream(fis);

            customers = (ArrayList<Customer>)ois.readObject();
            ois.close();

            for(Customer c: customers)
            {
                JOptionPane.showMessageDialog(null,c);
            }
        }

        catch (Exception ox){
            JOptionPane.showMessageDialog(null,"Exception Occurred");
        }

        Container pane;

        setTitle("McCarthys Book Store");
        setSize(1000, 525);
        setResizable(false);                   //window properties
        setLocation(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //CONTENT PANE
        pane = getContentPane();
        pane.setLayout(null);
        JLabel header = new JLabel("Add A Customer");
        Font font = new Font("monospaced", Font.PLAIN, 24);

        //JLABELS
        JLabel name = new JLabel("Name");
        JLabel dob = new JLabel("Date of Birth");
        JLabel address1 = new JLabel("Address Line 1");
        JLabel address2 = new JLabel("Address Line 2");
        JLabel town = new JLabel("Town");
        JLabel county = new JLabel("County");
        JLabel phone = new JLabel("Mobile Phone No.");

        //JTEXTFIELDS
        namejt = new JTextField(20);
        dobjt = new JTextField(10);
        addressLine1jt = new JTextField(20);
        addressLine2jt = new JTextField(20);
        townjt = new JTextField(15);
        countyjt = new JTextField(15);
        phonejt = new JTextField(10);

        //JBUTTON
        add = new JButton("Add Customer");
        add.addActionListener(this); //adding action listener to the button

        //JMENUBAR COMPONENTS
        createBooksMenu(); //calling books, customer and orders components methods for the JMenubar
        createCustomerMenu();
        createOrdersMenu();

        //JMENUBAR
        JMenuBar menu = new JMenuBar(); //creating the JMenubar
        setJMenuBar(menu);
        menu.add(Box.createHorizontalGlue()); //this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing
        //right aligns menu bar

        //ADDING TO THE JMENUBAR
        menu.setBackground(Color.lightGray);    //added components to the menu bar and their properties
        menu.add(booksMenu);
        menu.add(customerMenu);
        menu.add(ordersMenu);

        header.setFont(font); //applying the font to the header

        //ADDING THE JTEXTFIELDS TO THE CONTENT PANE
        pane.add(namejt);
        pane.add(dobjt);
        pane.add(addressLine1jt);
        pane.add(addressLine2jt);
        pane.add(townjt);
        pane.add(countyjt);
        pane.add(phonejt);

        //ADDING THE JLABELS TO THE CONTENT PANE
        pane.add(header);
        pane.add(name);
        pane.add(dob);
        pane.add(address1);
        pane.add(address2);
        pane.add(town);
        pane.add(county);
        pane.add(phone);

        //ADDING THE JBUTTON TO THE CONTENT PANE
        pane.add(add);


        //********BEGINNING OF ABSOLUTE POSITIONING************
        Insets insets = pane.getInsets();
        Dimension size = header.getPreferredSize();
        header.setBounds(200 + insets.left, 20 + insets.top,
                size.width, size.height);


        size = namejt.getPreferredSize();
        namejt.setBounds(400 + insets.left, 70 + insets.top,
                size.width, size.height);
        size = name.getPreferredSize();
        name.setBounds(325 + insets.left, 70 + insets.top,
                size.width, size.height);

        size = dobjt.getPreferredSize();
        dobjt.setBounds(400 + insets.left, 110 + insets.top,        //https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/AbsoluteLayoutDemoProject/src/layout/AbsoluteLayoutDemo.java
                //https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
                size.width, size.height);
        size = dob.getPreferredSize();
        dob.setBounds(288 + insets.left, 110 + insets.top,
                size.width, size.height);

        size = addressLine1jt.getPreferredSize();
        addressLine1jt.setBounds(400 + insets.left, 145 + insets.top,   //insets act as borders
                size.width, size.height);
        size = address1.getPreferredSize();
        address1.setBounds(274 + insets.left, 145 + insets.top,
                size.width, size.height);

        size = addressLine2jt.getPreferredSize();
        addressLine2jt.setBounds(400 + insets.left, 185 + insets.top,   //insets act as borders
                size.width, size.height);
        size = address2.getPreferredSize();
        address2.setBounds(274 + insets.left, 185 + insets.top,
                size.width, size.height);

        size = townjt.getPreferredSize();
        townjt.setBounds(400 + insets.left, 225 + insets.top,   //insets act as borders
                size.width, size.height);
        size = town.getPreferredSize();
        town.setBounds(326 + insets.left, 225 + insets.top,
                size.width, size.height);

        size = countyjt.getPreferredSize();
        countyjt.setBounds(400 + insets.left, 265 + insets.top,   //insets act as borders
                size.width, size.height);
        size = county.getPreferredSize();
        county.setBounds(320 + insets.left, 265 + insets.top,
                size.width, size.height);

        size = phonejt.getPreferredSize();
        phonejt.setBounds(400 + insets.left, 305 + insets.top,    //getPreferredSize() is a pre written method that gives a suitable size to the components
                size.width, size.height);
        size = phone.getPreferredSize();
        phone.setBounds(265 + insets.left, 305 + insets.top,
                size.width, size.height);

        size = add.getPreferredSize();
        add.setBounds(400 + insets.left, 375 + insets.top,
                size.width, size.height);

        //END OF ABSOLUTE POSITIONING END

    }

    //******ACTION EVENT HANDLING CODE*******//
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aBooks) { //if aBooks is clicked
            JOptionPane.showMessageDialog(null, "Re-directing you to Add Book Page"); //display this message
            AddBook add = new AddBook(); //create an instance of the AddBook class
            add.setVisible(true); //set the AddBook Jframe to visible
            this.setVisible(false); //hide this window                     //SAME FOR THE REST
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

        else if (e.getSource() == add) { //if 'add' JButton is clicked

            //**************VALIDATION**************//
            if (namejt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Name can't be empty");

            } else if (dobjt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth can't be empty");
            } else if (addressLine1jt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Address Line 1 can't be empty");
            } else if (addressLine2jt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Address Line 2 can't be empty"); //if JTextfields are empty display these messages
            } else if (townjt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Town can't be empty");
            } else if (countyjt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "County can't be empty");
            } else if (phonejt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Phone can't be empty");
            }

            else if (!dobjt.getText().equals("")) { //if dob JTextfield is not empty

                for (int p = 0; p < dobjt.getText().length(); p++) { //scan through the String in the dob JTextfield

                    if (dobjt.getText().length() > 10 || dobjt.getText().length() < 10) { //if its less than 10 characters
                        JOptionPane.showMessageDialog(null, "Date of Birth needs to be 10 characters long. \n\nIn the form of \n\n DD-MM-YYYY");
                        dobjt.setText("");
                    } else if (dobjt.getText().charAt(2) != '-' && dobjt.getText().charAt(5) != '-') { //if the 3rd and 6th characters aren't '-'

                        JOptionPane.showMessageDialog(null, "Date of Birth must be in the form of \n\n DD-MM-YYYY");

                        dobjt.setText("");

                    } else if (dobjt.getText().charAt(p) >= 'a' && dobjt.getText().charAt(p) <= 'z' || dobjt.getText().charAt(p) >= 'A' && dobjt.getText().charAt(p) <= 'Z') { //if the dob JTextfield contains a letter
                        JOptionPane.showMessageDialog(null, "Date of Birth can't contain a letter");

                        dobjt.setText("");
                    }

                    else {

                        //adding a new customer object to the customers arraylist
                        String name, dob, address1, address2, town, county, phone;
                        name = namejt.getText();
                        dob = dobjt.getText();
                        address1 = addressLine1jt.getText();
                        address2 = addressLine2jt.getText();
                        town = townjt.getText();
                        county = countyjt.getText();
                        phone = phonejt.getText();


                        ArrayList<Customer> customers = AddCustomer.getCustomers();
                        Customer c1 = new Customer(name, dob, address1, address2, town, county, phone);

                        customers.add(c1);


                        //write a loop now to check if the Book has been added

                        for (int i = 0; i < customers.size(); i++) {
                            JOptionPane.showMessageDialog(null, customers.get(i).toString());
                        }


                        namejt.setText("");
                        dobjt.setText("");
                        addressLine1jt.setText("");
                        addressLine2jt.setText("");
                        townjt.setText("");
                        countyjt.setText("");
                        phonejt.setText("");


                        //saving the new customer object to the arraylist  //coded with the help of John Brosnan
                        try {
                            //**********TRYING TO SAVE A BOOK TO MY ARRAYLIST************//
                            File f = new File("allCustomers2.dat");
                            FileOutputStream fos = new FileOutputStream(f);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);

                            oos.writeObject(customers);
                            oos.close();


                        } catch (Exception ex) {
                            System.out.println("Exception occurred!!!");
                            System.out.println(ex);
                        }
                    }
                }
            }
        }
    }

    //***********JMENU COMPONENTS METHODS/CODE**********//  //coded with the help of John Brosnan
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