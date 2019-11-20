import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener
{
    JMenu booksMenu; //books variable
    JMenu customerMenu; //customer variable
    JMenu ordersMenu;
    JLabel response; // main JLabel

    public static void main(String[] args) {
        MainMenu frame = new MainMenu(); //Creating the window
        frame.setVisible(true); //making it visible
    }

    public MainMenu(){
        Container pane;

        setTitle     ("McCarthys Main Menu");
        setSize      (600,200);
        setResizable (false);                   //window properties
        setLocation  (250,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = getContentPane();
        pane.setLayout(new FlowLayout());

        createBooksMenu(); //calling books and customer methods
        createCustomerMenu();
        createOrdersMenu();

        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        menu.add(Box.createHorizontalGlue()); //this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing
                                                //right aligns menu bar

        menu.setBackground(Color.lightGray);    //added components to the menu bar and their properties
        menu.add(booksMenu);
        menu.add(customerMenu);
        menu.add(ordersMenu);

        JLabel label = new JLabel("Welcome to Mc Carthys Book Store");
        Font font = new Font("monospaced",Font.PLAIN,24);
        label.setFont(font);
        pane.add(label); //adding label to the frame
    }

   public
   void actionPerformed(ActionEvent event) {        //JOHN WALSH NOTES
        String  menuName;
      menuName = event.getActionCommand(); // what's written on the item that was clicked
       // note the String comparison
       if (menuName.equals("Quit")) {
           System.exit(0);
        } // end if
        else {
            response.setText("Menu Item '" + menuName + "' is selected.");
       } // end else
    } // end actionPerform          JOHN WALSH NOTES END

    public void createBooksMenu() {
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

        customerMenu = new JMenu("Customers"); //creating books

        item1 = new JMenuItem("Add Customer");
        item1.addActionListener(this);
        customerMenu.add(item1); //adding the item to the books option in the menu bar

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

        ordersMenu = new JMenu("Orders"); //creating books

        item1 = new JMenuItem("Add Order");
        item1.addActionListener(this);
        ordersMenu.add(item1); //adding the item to the books option in the menu bar

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
