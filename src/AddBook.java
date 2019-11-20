import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBook extends JFrame implements ActionListener
{
    JMenu booksMenu; //books JMenu
    JMenu customerMenu; //customer JMenu
    JMenu ordersMenu;   //orders JMenu
    JLabel response; // main JLabel
    

    public static void main(String[] args) {
        AddBook frame = new AddBook(); //Creating the window
        frame.setVisible(true); //making it visible
    }

    public AddBook(){
        Container pane;

        setTitle     ("McCarthys Book Store");
        setSize      (1000,600);
        setResizable (false);                   //window properties
        setLocation  (250,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = getContentPane();
        pane.setLayout(null);
        JLabel header = new JLabel("Add A Book");
        Font font = new Font("monospaced",Font.PLAIN,24);

        JLabel name = new JLabel("Name");
        JLabel author = new JLabel("Author");
        JLabel ibsn = new JLabel("ISBN");
        JLabel pages = new JLabel("Number of Pages");
        JLabel price = new JLabel("Price");
        JTextField jt1 = new JTextField(20);
        JTextField jt2 = new JTextField(18);
        JTextField jt3 = new JTextField(13);
        JTextField jt4 = new JTextField(4);
        JTextField jt5 = new JTextField(6);
        JButton add = new JButton("Add Book");

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
        pane.add(header);
        pane.add(name);
        pane.add(author);
        pane.add(ibsn);
        pane.add(pages);
        pane.add(add);
        pane.add(price);



    //DIMENSIONS FOR ABSOLUTE POSITIONING START
        Insets insets = pane.getInsets();
        Dimension size = header.getPreferredSize();
        header.setBounds(200 + insets.left, 40 + insets.top,
                size.width, size.height);

        size = jt1.getPreferredSize();
        jt1.setBounds(400+ insets.left, 100+ insets.top,
                size.width, size.height);
        size = name.getPreferredSize();
        name.setBounds(325+ insets.left, 100+ insets.top,
                size.width, size.height);

        size = jt2.getPreferredSize();
        jt2.setBounds(400+ insets.left, 150+ insets.top,        //https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/AbsoluteLayoutDemoProject/src/layout/AbsoluteLayoutDemo.java
                                                                        //https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
               size.width, size.height);
        size = author.getPreferredSize();
        author.setBounds(325+ insets.left, 150+ insets.top,
                size.width, size.height);

        size = jt3.getPreferredSize();
        jt3.setBounds(400 + insets.left, 200 + insets.top,   //insets act as borders
                size.width, size.height);
        size = ibsn.getPreferredSize();
        ibsn.setBounds(325+ insets.left, 200+ insets.top,
                size.width, size.height);

        size = jt4.getPreferredSize();
        jt4.setBounds(400 + insets.left, 250 + insets.top,    //getPreferredSize() is a pre written method that gives a suitable size to the components
                size.width, size.height);
        size = pages.getPreferredSize();
        pages.setBounds(256+ insets.left, 250+ insets.top,
                size.width, size.height);

        size = jt5.getPreferredSize();
        jt5.setBounds(400 + insets.left, 300 + insets.top,    //getPreferredSize() is a pre written method that gives a suitable size to the components
                size.width, size.height);
        size = price.getPreferredSize();
        price.setBounds(325+ insets.left, 300+ insets.top,
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