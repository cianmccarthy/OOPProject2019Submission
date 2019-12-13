import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveOrder extends JFrame implements ActionListener {
    JMenu booksMenu; //books JMenu
    JMenu customerMenu; //customer JMenu
    JMenu ordersMenu;   //orders JMenu
    private static JMenuItem aBooks, eBooks, rBooks, sBooks, aCustomers, eCustomers, rCustomers, sCustomers, pOrder, eOrder, rOrder, sOrder;
    JButton search;
    JTextField orderId;

    public RemoveOrder(){
        Container pane;

        setTitle     ("McCarthys Book Store");
        setSize      (1000,600);
        setResizable (false);                   //window properties
        setLocation  (250,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = getContentPane();
        pane.setLayout(null);
        JLabel header = new JLabel("Remove An Order");
        Font font = new Font("monospaced",Font.PLAIN,24);

        JLabel name = new JLabel("Order Id");
        orderId = new JTextField(4);
        search = new JButton("Search Orders");
        search.addActionListener(this);

        createBooksMenu(); //calling books, customer and orders methods for to add the JMenubar
        createCustomerMenu();
        createOrdersMenu();


        JMenuBar menu = new JMenuBar(); //creating the JMenubar
        setJMenuBar(menu);
        menu.add(Box.createHorizontalGlue()); //this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing
        //right aligns menu bar

        menu.setBackground(Color.lightGray);    //added components to the menu bar and their properties
        menu.add(booksMenu);
        menu.add(customerMenu);
        menu.add(ordersMenu);
        pane.add(header);
        pane.add(name);
        pane.add(orderId);
        pane.add(search);

        header.setFont(font);

        //DIMENSIONS FOR ABSOLUTE POSITIONING START
        Insets insets = pane.getInsets();
        Dimension size = header.getPreferredSize();
        header.setBounds(200 + insets.left, 40 + insets.top,
                size.width, size.height);

        size = name.getPreferredSize();
        name.setBounds(360 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = orderId.getPreferredSize();
        orderId.setBounds(480 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = search.getPreferredSize();
        search.setBounds(450 + insets.left, 145 + insets.top,
                size.width, size.height);

        //DIMENSIONS FOR ABSOLUTE POSITIONING END
    }


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

         if (e.getSource() == search) {//if search button is clicked
             JOptionPane.showMessageDialog(null, "Removing Order");

        ArrayList<Order> orders = PlaceOrder.getOrders();    //get the ORDERS arraylist


                 for (int i = 0; i < orders.size(); i++) {
                     if(orderId.getText().equals(orders.get(i).getOrderId())) {
                         orders.remove(orders.get(i));

                     JOptionPane.showMessageDialog(null, "Order Removed");
                 }
             }
         }
    }


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