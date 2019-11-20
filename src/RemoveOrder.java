import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveOrder extends JFrame implements ActionListener {
    JMenu booksMenu; //books JMenu
    JMenu customerMenu; //customer JMenu
    JMenu ordersMenu;   //orders JMenu
    JLabel response; // main JLabel

    public static void main(String[] args) {
        RemoveOrder frame = new RemoveOrder(); //Creating the window
        frame.setVisible(true); //making it visible


    }

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
        JTextField jt1 = new JTextField(4);
        JButton search = new JButton("Search Orders");
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
        pane.add(jt1);
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

        size = jt1.getPreferredSize();
        jt1.setBounds(480 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = search.getPreferredSize();
        search.setBounds(450 + insets.left, 145 + insets.top,
                size.width, size.height);




        //  size = details.getPreferredSize();
        //  details.setBounds(500 + insets.left, 600 + insets.top,
        //       size.width, size.height);





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