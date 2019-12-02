import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//****************MAIN CLASS + GLOBAL VARIABLES ******************//
public class EditBook extends JFrame implements ActionListener {
    JMenu booksMenu; //books JMenu global variable
    JMenu customerMenu; //customer JMenu global variable
    JMenu ordersMenu;   //orders JMenu global variable
    private static JMenuItem aBooks, eBooks, rBooks, sBooks, aCustomers, eCustomers, rCustomers, sCustomers, pOrder, eOrder, rOrder, sOrder; //JMenuItem global variables


    //**************MAIN METHOD: IMPLEMENTING EDITBOOK JFRAME WINDOW************//
    public static void main(String[] args) { //Main Method
        EditBook frame = new EditBook(); //creating the EditBook JFrame window
        frame.setVisible(true); //making the frame visible
    }


    //******************SETTING UP EDITBOOK JFRAME ******************//
    public EditBook(){
        Container pane; //creating the content pane

        setTitle     ("McCarthys Book Store");
        setSize      (1000,600);
        setResizable (false);                   //window properties
        setLocation  (250,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = getContentPane(); //calling the content pane to be display
        pane.setLayout(null); //setting the layout to null for absolute positioning

        //LABELS
        JLabel header = new JLabel("Edit A Book"); //HEADER & FONT
        Font font = new Font("monospaced",Font.PLAIN,24);
        JLabel name = new JLabel("Name of Book"); //NAME OF BOOK
        JLabel isbn = new JLabel("ISBN");           //ISBN OF BOOK

        //TEXTFIELDS
        JTextField namejt  = new JTextField(20); //JTEXTFIELDS
        JTextField isbnjt = new JTextField(13);
        JButton search = new JButton("Search Books"); //SEARCH BUTTON

        //JMENUBAR METHODS
        createBooksMenu(); //CALLING BOOKS, CUSTOMER AND ORDERS METHODS FOR JMENUBAR
        createCustomerMenu();       //JOHN WALSHES NOTES WERE USED WHEN MAKING THESE
        createOrdersMenu();

        //SETTING UP JMENUBAR
        JMenuBar menu = new JMenuBar(); //CREATING THE JMENUBAR
        setJMenuBar(menu);              //APPLYING THE JMENUBAR
        menu.add(Box.createHorizontalGlue());     //RIGHT ALIGNS THE JMENUBAR    //THIS LINE OF CODE WAS GOT FROM https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing

        menu.setBackground(Color.lightGray);    //ADDING COMPONENTS TO THE JMENUBAR
        menu.add(booksMenu);
        menu.add(customerMenu);
        menu.add(ordersMenu);

        //ADDING COMPONENTS TO THE PANE
        pane.add(header);
        pane.add(name);
        pane.add(isbn);
        pane.add(namejt);
        pane.add(isbnjt);
        pane.add(search);

        header.setFont(font); //APPLYING THE FONT TO THE HEADER

        //DIMENSIONS FOR ABSOLUTE POSITIONING START
        Insets insets = pane.getInsets(); //creates an instance of the insets and adds it to the pane
        Dimension size = header.getPreferredSize(); //setting the size of the header using the get preferred size method (PRE WRITTEN)
        header.setBounds(200 + insets.left, 40 + insets.top,
                size.width, size.height);                //adding dimensions to the insets and setting up width and height using get preferred size
        size = name.getPreferredSize();
        name.setBounds(200 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = isbn.getPreferredSize();
        isbn.setBounds(550 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = namejt.getPreferredSize();
        namejt.setBounds(290 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = isbnjt.getPreferredSize();
        isbnjt.setBounds(590 + insets.left, 100 + insets.top,
                size.width, size.height);

       size = search.getPreferredSize();
       search.setBounds(450 + insets.left, 135 + insets.top,
                size.width, size.height);

        //DIMENSIONS FOR ABSOLUTE POSITIONING END
    }


//*****************ACTION EVENT CODE ****************//
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() == aBooks) {  //If aBooks (add books button) is clicked do this .....
            JOptionPane.showMessageDialog(null, "Re-directing you to Add Book Page"); //Display the following message

            AddBook add = new AddBook(); //then create an new Add Book page

            add.setVisible(true); //set this new add book page to visible
            this.setVisible(false); //hide this page                                        **SAME FOR THE REST OF THE BUTTONS**
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

    //*****************JMENUBAR METHODS*********************//
    public void createBooksMenu () {

        booksMenu = new JMenu("Books"); //creating books JMenu in JMenubar

        aBooks = new JMenuItem("Add Book"); // creating JMenuItem aBooks(adding books)
        aBooks.addActionListener(this); //adding action listener to the aBooks button
        booksMenu.add(aBooks); //adding the item to the books option in the menu bar  **SAME FOR EACH IN EACH METHOD**

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

        customerMenu = new JMenu("Customers");

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
