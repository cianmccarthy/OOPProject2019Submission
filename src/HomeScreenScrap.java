import javax.swing.*;
import java.awt.*;

public class HomeScreenScrap extends JFrame {
    private ImageIcon image1;
    private JLabel label9;

  //  private JMenu fileMenu;
 //   private JMenu editMenu;

    public HomeScreenScrap() {

        GridLayout gridLayout = new GridLayout(3,3,0,0);



        setTitle("McCarthys Book Store");
        setSize(800,500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        image1 = new ImageIcon(getClass().getResource("books.JPEG"));
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel("McCarthy Book");
        JLabel label6 = new JLabel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        label9 = new JLabel(image1);
        add(label9);
        add(label6);
        add(label7);
        add(label8);

        setLayout(gridLayout);


        //invoke a user-written method create two menus and their menu items
        // done by separate method to make the constructor shorter
       // createFileMenu();
        //createEditMenu();

        //and add them to the menubar
       // JMenuBar menuBar = new JMenuBar();
       // setJMenuBar(menuBar);
       // menuBar.setBackground(Color.yellow);
      //  menuBar.add(fileMenu);
       // menuBar.add(editMenu);


    }

public static void main(String[] args) {

    HomeScreenScrap homeWindow = new HomeScreenScrap();
    homeWindow.setVisible(true);

}

}

