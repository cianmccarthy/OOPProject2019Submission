import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//**************MAIN CLASS**************//
public class SearchCustomer extends JFrame implements ActionListener { //AddCustomer inherits from the JFrame class (super class inheritance) and implements the ActionListener interface

    //GLOBAL VARIABLES
    JMenu booksMenu; //books JMenu
    JMenu customerMenu; //customer JMenu
    JMenu ordersMenu;   //orders JMenu
    private static JMenuItem aBooks, eBooks, rBooks, sBooks, aCustomers, eCustomers, rCustomers, sCustomers, pOrder, eOrder, rOrder, sOrder;
    JTextField namejt, dobjt;
    JButton search;

    //********MAIN METHOD**********//
    public static void main(String[] args) {
        SearchCustomer frame = new SearchCustomer(); //Creating the window
        frame.setVisible(true); //making it visible
    }

    //**********CONSTRUCTOR*********//
    public SearchCustomer(){
        Container pane;

        setTitle     ("McCarthys Book Store");
        setSize      (1000,600);
        setResizable (false);                   //window properties
        setLocation  (250,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //CONTENT PANE
        pane = getContentPane();
        pane.setLayout(null);

        //HEADER
        JLabel header = new JLabel("Search for A Customer");
        Font font = new Font("monospaced",Font.PLAIN,24);

        //JLABELS
        JLabel name = new JLabel("Name of Customer");
        JLabel dob = new JLabel("Date of Birth");

        //JTEXTFIELDS
        namejt = new JTextField(20);
        dobjt = new JTextField(13);

        //JBUTTON
        search = new JButton("Show Details");
        search.addActionListener(this);

        //CALLING METHODS FOR COMPONENTS IN THE JMENUBAR
        createBooksMenu();
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

        //ADDING JTEXTFIELDS TO THE CONTENT PANE
        pane.add(namejt);
        pane.add(dobjt);
        pane.add(search);

        //APPLYING THE FONT TO THE HEADER
        header.setFont(font);

        //*************BEGINNING OF ABSOLUTE POSITIONING**************//
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

        size = search.getPreferredSize();
        search.setBounds(450 + insets.left, 135 + insets.top,
                size.width, size.height);

        //**********END OF ABSOLUTE POSITIONING*************//
    }

    //******ACTION EVENT HANDLING************//
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == aBooks) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Add Book Page");
            AddBook add = new AddBook();
            add.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == eBooks) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Edit Book Page");

            EditBook edit = new EditBook();

            edit.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == rBooks) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Remove Book Page");

            RemoveBook remove = new RemoveBook();

            remove.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == sBooks) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Search Book Page");

            SearchBook search = new SearchBook();

            search.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == aCustomers) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Add Customer Page");

            AddCustomer addCustomer = new AddCustomer();

            addCustomer.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == eCustomers) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Edit Customer Page");

            EditCustomer editCustomer = new EditCustomer();

            editCustomer.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == rCustomers) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Remove Customer Page");

            RemoveCustomer removeCustomer = new RemoveCustomer();

            removeCustomer.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == sCustomers) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Search Customer Page");

            SearchCustomer searchCustomer = new SearchCustomer();

            searchCustomer.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == pOrder) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Place Order Page");

            PlaceOrder placeOrder = new PlaceOrder();

            placeOrder.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == eOrder) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Edit Order Page");

            EditOrder editOrder = new EditOrder();

            editOrder.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == rOrder) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Remove Order Page");

            RemoveOrder removeOrder = new RemoveOrder();

            removeOrder.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == sOrder) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Search Order Page");

            SearchOrder searchOrder = new SearchOrder();

            searchOrder.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource() == search) { //SEARCHING THE ARRAYLIST FOR A CUSTOMER
            ArrayList<Customer> customers = AddCustomer.getCustomers(); //get the customer arraylist

            for (int i = 0; i < customers.size(); i++) { //scan through the objects in the arraylist
                if (namejt.getText().equals(customers.get(i).getName()) && dobjt.getText().equals(customers.get(i).getDob())) { //if the name and dob JTextfields equal a name and dob in the arraylist
                    JOptionPane.showMessageDialog(null, "Customer \n\n" + customers.get(i)); //display this message and show the corresponding records
                }
            }


        }
    }

    //**********METHODS FOR COMPONENTS IN THE JMENUBAR************//
    public void createBooksMenu(){

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