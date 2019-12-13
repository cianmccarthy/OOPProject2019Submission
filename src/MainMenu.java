//import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//**************MAIN CLASS**************//
public class MainMenu extends JFrame implements ActionListener //MainMenu inherits from JFrame and implements the Action Listener interface
{
    JMenu booksMenu; //books global variable
    JMenu customerMenu; //customer global variable
    JMenu ordersMenu; //orders global variable
    private static JMenuItem aBooks, eBooks, rBooks, sBooks, aCustomers, eCustomers, rCustomers, sCustomers, pOrder, eOrder, rOrder, sOrder; //JMenuItem global variables

//***************CONSTRUCTOR**************//
    public MainMenu() {
            Container pane; //content pane variable

            setTitle("McCarthys Main Menu");
            setSize(600, 200);
            setResizable(false);                   //window properties
            setLocation(250, 200);

            setDefaultCloseOperation(EXIT_ON_CLOSE);

            pane = getContentPane(); //calling the content pane
            pane.setLayout(new FlowLayout()); //setting the layout of the JFrame to FlowLayout

            createBooksMenu(); //calling books customer and orders methods
            createCustomerMenu();
            createOrdersMenu();

            JMenuBar menu = new JMenuBar(); //creating an instance of the JMenuBar class
            setJMenuBar(menu); //setting the JMenuBar up
            menu.add(Box.createHorizontalGlue()); //this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing
            //right aligns menu bar

            menu.setBackground(Color.lightGray);    //added components to the JMenu bar
            menu.add(booksMenu);
            menu.add(customerMenu);
            menu.add(ordersMenu);

            JLabel label = new JLabel("Welcome to Cian Mc's Book Store"); //main header
            Font font = new Font("monospaced", Font.PLAIN, 28); //font for the header
            label.setFont(font); //applying the font to the header
            pane.add(label); //adding label to the JFrame
        }

//**************Action Event Code (Buttons)**************//
        public void actionPerformed (ActionEvent e) //coded with the help of John Brosnan
        {
            if (e.getSource() == aBooks) { //if aBooks (Add Book) is clicked
                JOptionPane.showMessageDialog(null, "Re-directing you to Add Book Page"); //display this message
                AddBook add = new AddBook(); //create an instance of the AddBook class
                add.setVisible(true); //make the AddBook JFrame visible
                this.setVisible(false);//hide the current MainMenu JFrame window
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
        }
//****************JMENUBAR COMPONENTS******************//
        public void createBooksMenu () { //coded with the help of John Brosnan

            booksMenu = new JMenu("Books"); //creating 'books' in the JMenuBar

            aBooks = new JMenuItem("Add Book");
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
        } // end of 'books' JMenu option                    //Same process for 'Customers' and 'Orders'

        private void createCustomerMenu () {

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

        private void createOrdersMenu () {

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
