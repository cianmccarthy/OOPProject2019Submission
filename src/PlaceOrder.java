import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaceOrder extends JFrame implements ActionListener {
    JMenu booksMenu; //books JMenu
    JMenu customerMenu; //customer JMenu
    JMenu ordersMenu;   //orders JMenu
    JLabel response; // main JLabel

    public static void main(String[] args) {
        PlaceOrder frame = new PlaceOrder(); //Creating the window
        frame.setVisible(true); //making it visible


    }

    public PlaceOrder(){
        Container pane;

        setTitle     ("McCarthys Book Store");
        setSize      (1000,600);
        setResizable (false);                   //window properties
        setLocation  (250,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = getContentPane();
        pane.setLayout(null);
        JLabel header = new JLabel("Enter A Customer");
        Font font = new Font("monospaced",Font.PLAIN,24);

        JLabel name = new JLabel("Name of Customer");
        JLabel dob = new JLabel("Date of Birth");
        JTextField jt1 = new JTextField(20);
        JTextField jt2 = new JTextField(13);

        JLabel header2 = new JLabel("Order Book");
        Font font2 = new Font("monospaced",Font.PLAIN,24);
        JLabel isbn = new JLabel("ISBN");
        JLabel title = new JLabel("Title");
        JLabel price = new JLabel("Price");
        JLabel id = new JLabel("Order Id");
        JButton order = new JButton("Place Order");
        JTextField jt3 = new JTextField(20);
        JTextField jt4 = new JTextField(13);
        JTextField jt5 = new JTextField(5);
        JTextField jt6 = new JTextField(4);


        //JFrame details = new JFrame("Book Details");
        //details.setBackground(Color.blue);
        //details.setSize(400,400);
        //details.setVisible(true);





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
        pane.add(dob);
        pane.add(jt1);
        pane.add(jt2);
        pane.add(header2);
        pane.add(title);
        pane.add(isbn);
        pane.add(price);
        pane.add(id);
        pane.add(jt3);
        pane.add(jt4);
        pane.add(jt5);
        pane.add(jt6);
        pane.add(order);

        header.setFont(font);
        header2.setFont(font2);

        //DIMENSIONS FOR ABSOLUTE POSITIONING START

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

        size = jt1.getPreferredSize();
        jt1.setBounds(290 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = jt2.getPreferredSize();
        jt2.setBounds(630 + insets.left, 100 + insets.top,
                size.width, size.height);

        //ORDER SECTION

        size = header2.getPreferredSize();
        header2.setBounds(200 + insets.left, 145 + insets.top,
                size.width, size.height);

        size = id.getPreferredSize();
        id.setBounds(250 + insets.left, 205 + insets.top,
                size.width, size.height);

        size = jt6.getPreferredSize();
        jt6.setBounds( 360+ insets.left, 205 + insets.top,
                size.width, size.height);


        size = title.getPreferredSize();
        title.setBounds(250 + insets.left, 245 + insets.top,
                size.width, size.height);

        size = jt3.getPreferredSize();
        jt3.setBounds(360 + insets.left, 245 + insets.top,
                size.width, size.height);

        size = isbn.getPreferredSize();
        isbn.setBounds(250 + insets.left, 285 + insets.top,
                size.width, size.height);

        size = jt4.getPreferredSize();
        jt4.setBounds( 360+ insets.left, 285 + insets.top,
                size.width, size.height);

        size = price.getPreferredSize();
        price.setBounds(250 + insets.left, 325 + insets.top,
                size.width, size.height);

        size = jt5.getPreferredSize();
        jt5.setBounds( 360+ insets.left, 325 + insets.top,
                size.width, size.height);

        size = order.getPreferredSize();
        order.setBounds( 440+ insets.left, 415 + insets.top,
                size.width, size.height);




        //DIMENSIONS FOR ABSOLUTE POSITIONING END
    }



    public void actionPerformed(ActionEvent event) {        //JOHN WALSH NOTES
        String  menuName;
        menuName = event.getActionCommand(); // what's written on the item that was clicked
        // note the String comparison
        if (menuName.equals("Quit")) {                                  //action listener gathered from JW Notes
            System.exit(0);
        } // end if
        else {
            response.setText("Menu Item '" + menuName + "' is selected.");
        } // end else
    } // end actionPerform          JOHN WALSH NOTES END

    public void createBooksMenu() {             //methods written to create items for the JMenuBar
        JMenuItem item1; //item in the menubar variable

        booksMenu = new JMenu("Books"); //creating books

        item1 = new JMenuItem("Add Book");
        item1.addActionListener(this);
        booksMenu.add(item1); //adding the item to the books option in the menu bar

        item1 = new JMenuItem("Edit Book");
        item1.addActionListener(this);
        booksMenu.add(item1);

        item1 = new JMenuItem("Remove Book");
        item1.addActionListener(this);
        booksMenu.add(item1);

        item1 = new JMenuItem("Search Books");
        item1.addActionListener(this);
        booksMenu.add(item1);
    } // end of books menu option

    private void createCustomerMenu(){
        JMenuItem item1; //item in the menubar variable

        customerMenu = new JMenu("Customers"); //creating customer

        item1 = new JMenuItem("Add Customer");
        item1.addActionListener(this);
        customerMenu.add(item1); //adding the item to the customer option in the menu bar

        item1 = new JMenuItem("Edit Customer");
        item1.addActionListener(this);
        customerMenu.add(item1);

        item1 = new JMenuItem("Remove Customer");
        item1.addActionListener(this);
        customerMenu.add(item1);

        item1 = new JMenuItem("Search Customers");
        item1.addActionListener(this);
        customerMenu.add(item1);
    }

    private void createOrdersMenu(){
        JMenuItem item1; //item in the menubar variable

        ordersMenu = new JMenu("Orders"); //creating orders

        item1 = new JMenuItem("Add Order");
        item1.addActionListener(this);
        ordersMenu.add(item1); //adding the item to the orders option in the menu bar

        item1 = new JMenuItem("Edit Order");
        item1.addActionListener(this);
        ordersMenu.add(item1);

        item1 = new JMenuItem("Remove Order");
        item1.addActionListener(this);
        ordersMenu.add(item1);

        item1 = new JMenuItem("Search Orders");
        item1.addActionListener(this);
        ordersMenu.add(item1);
    }



}