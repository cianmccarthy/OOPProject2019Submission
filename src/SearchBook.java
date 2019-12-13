import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//********MAIN CLASS*********//
public class SearchBook extends JFrame implements ActionListener { //SearchBook inherits from the JFrame class (super class inheritance) and implements the ActionListener interface

    //GLOBAL VARIABLES
    JMenu booksMenu; //books JMenu
    JMenu customerMenu; //customer JMenu
    JMenu ordersMenu;   //orders JMenu
    private static JMenuItem aBooks, eBooks, rBooks, sBooks, aCustomers, eCustomers, rCustomers, sCustomers, pOrder, eOrder, rOrder, sOrder;
    JButton search;
    JTextField namejt, isbnjt;

    //*******CONSTRUCTOR*********//
    public SearchBook(){

        Container pane;

        setTitle     ("McCarthys Book Store");
        setSize      (1000,600);
        setResizable (false);                   //window properties
        setLocation  (250,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //CONTENT PANE
        pane = getContentPane();
        pane.setLayout(null);

        //HEADER AND HEADER FONT
        JLabel header = new JLabel("Search For A Book");
        Font font = new Font("monospaced",Font.PLAIN,24);
    
        //JLABELS
        JLabel name = new JLabel("Name of Book");
        JLabel ibsn = new JLabel("IBSN");
        
        //JTEXTFIELDS
        namejt = new JTextField(20);
        isbnjt = new JTextField(13);
        
        //JBUTTON
        search = new JButton("Show Details");
        search.addActionListener(this);

        //CALLING COMPONENT METHODS FOR JMENUBAR
        createBooksMenu(); 
        createCustomerMenu();
        createOrdersMenu();
        
        //JMENUBAR
        JMenuBar menu = new JMenuBar(); //creating the JMenubar
        setJMenuBar(menu);
        menu.add(Box.createHorizontalGlue()); //this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing
        //right aligns menu bar

        //ADDING JMENUBAR COMPONENTS
        menu.setBackground(Color.lightGray);    //added components to the menu bar and their properties
        menu.add(booksMenu);
        menu.add(customerMenu);
        menu.add(ordersMenu);
        
        //ADDING JLABELS
        pane.add(header);
        pane.add(name);
        pane.add(ibsn);
        
        //ADDING JTEXTFIELDS
        pane.add(namejt);
        pane.add(isbnjt);
        pane.add(search);

        //APPLYING HEADER FONT
        header.setFont(font);

        //*********BEGINNING OF ABSOLUTE POSITIONING**********
        Insets insets = pane.getInsets();
        Dimension size = header.getPreferredSize();
        header.setBounds(200 + insets.left, 40 + insets.top,
                size.width, size.height);

        size = name.getPreferredSize();
        name.setBounds(200 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = ibsn.getPreferredSize();
        ibsn.setBounds(550 + insets.left, 100 + insets.top,
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

        //***********END OF ABSOLUTE POSITIONING************
    }


//*************ACTION EVENT HANDLER************//
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() == aBooks) {
            JOptionPane.showMessageDialog(null, "Re-directing you to Add Book Page");
            AddBook add = new AddBook();
            add.setVisible(true);
            this.setVisible(false);
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

        if(e.getSource()==search){ //if 'search' JButton is clicked

                        ArrayList<Book> books = AddBook.getBooks(); //get the books arraylist from the AddBook page //THIS WAS CODED WITH THE HELP OF JOHN BROSNAN

                        for (int i = 0; i < books.size(); i++) //scan through the contents of the arraylist using this for loop
                        {
                            if (namejt.getText().equals(books.get(i).getTitle()) && isbnjt.getText().equals(books.get(i).getIsbn())) { //and if the String in the name and isbn JTexfields equal the title and isbn gotten from the arraylist
                                JOptionPane.showMessageDialog(null, "Book \n\n" + books.get(i)); //display this message and the contents of the book that matches these textfields
                            }
                        }
                    }
                }


    //************METHODS FOR THE COMPONENTS IN THE JMENUBAR***********//
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
    }

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

        ordersMenu = new JMenu("Orders");

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