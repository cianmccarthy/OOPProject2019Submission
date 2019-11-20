import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener
{
    JMenu booksMenu; //books JMenu
    JMenu customerMenu; //customer JMenu
    JMenu ordersMenu;   //orders JMenu
    JLabel response; // main JLabel

    public static void main(String[] args) {
        AddCustomer frame = new AddCustomer(); //Creating the window
        frame.setVisible(true); //making it visible
    }

    public AddCustomer(){
        Container pane;

        setTitle     ("McCarthys Book Store");
        setSize      (1000,525);
        setResizable (false);                   //window properties
        setLocation  (250,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = getContentPane();
        pane.setLayout(null);
        JLabel header = new JLabel("Add A Customer");
        Font font = new Font("monospaced",Font.PLAIN,24);

        JLabel name = new JLabel("Name");
        JLabel dob = new JLabel("Date of Birth");
        JLabel address1 = new JLabel("Address Line 1");
        JLabel address2 = new JLabel("Address Line 2");
        JLabel town = new JLabel("Town");
        JLabel county = new JLabel("County");
        JLabel phone = new JLabel("Phone");
        JTextField jt1 = new JTextField(20);
        JTextField jt2 = new JTextField(10);
        JTextField jt3 = new JTextField(20);
        JTextField jt4 = new JTextField(20);
        JTextField jt5 = new JTextField(15);
        JTextField jt6 = new JTextField(15);
        JTextField jt7 = new JTextField(10);
        JButton add = new JButton("Add Customer");

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

        header.setFont(font);

        pane.add(jt1);
        pane.add(jt2);      //adding textfields, labels and other text to the frame
        pane.add(jt3);
        pane.add(jt4);
        pane.add(jt5);
        pane.add(jt6);
        pane.add(jt7);
        pane.add(header);
        pane.add(name);
        pane.add(dob);
        pane.add(address1);
        pane.add(address2);
        pane.add(town);
        pane.add(county);
        pane.add(phone);
        pane.add(add);



        //DIMENSIONS FOR ABSOLUTE POSITIONING START
        Insets insets = pane.getInsets();
        Dimension size = header.getPreferredSize();
        header.setBounds(200 + insets.left, 20 + insets.top,
                size.width, size.height);



        size = jt1.getPreferredSize();
        jt1.setBounds(400+ insets.left, 70+ insets.top,
                size.width, size.height);
        size = name.getPreferredSize();
        name.setBounds(325+ insets.left, 70+ insets.top,
                size.width, size.height);

        size = jt2.getPreferredSize();
        jt2.setBounds(400+ insets.left, 110+ insets.top,        //https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/AbsoluteLayoutDemoProject/src/layout/AbsoluteLayoutDemo.java
                //https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
                size.width, size.height);
        size = dob.getPreferredSize();
        dob.setBounds(288+ insets.left, 110+ insets.top,
                size.width, size.height);

        size = jt3.getPreferredSize();
        jt3.setBounds(400 + insets.left, 145 + insets.top,   //insets act as borders
                size.width, size.height);
        size = address1.getPreferredSize();
        address1.setBounds(274+ insets.left, 145+ insets.top,
                size.width, size.height);

        size = jt4.getPreferredSize();
        jt4.setBounds(400 + insets.left, 185 + insets.top,   //insets act as borders
                size.width, size.height);
        size = address2.getPreferredSize();
        address2.setBounds(274+ insets.left, 185+ insets.top,
                size.width, size.height);

        size = jt5.getPreferredSize();
        jt5.setBounds(400 + insets.left, 225 + insets.top,   //insets act as borders
                size.width, size.height);
        size = town.getPreferredSize();
        town.setBounds(326+ insets.left, 225+ insets.top,
                size.width, size.height);

        size = jt6.getPreferredSize();
        jt6.setBounds(400 + insets.left, 265 + insets.top,   //insets act as borders
                size.width, size.height);
        size = county.getPreferredSize();
        county.setBounds(320+ insets.left, 265+ insets.top,
                size.width, size.height);

        size = jt7.getPreferredSize();
        jt7.setBounds(400 + insets.left, 305 + insets.top,    //getPreferredSize() is a pre written method that gives a suitable size to the components
                size.width, size.height);
        size = phone.getPreferredSize();
        phone.setBounds(322+ insets.left, 305+ insets.top,
                size.width, size.height);

        size = add.getPreferredSize();
        add.setBounds(400+ insets.left, 375+ insets.top,
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