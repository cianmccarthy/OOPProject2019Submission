//ONLY AN EXAMPLE FROM https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/AbsoluteLayoutDemoProject/src/layout/AbsoluteLayoutDemo.java
//https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html




/*
 * AbsoluteLayoutDemo.java requires no other files.
 */

import com.sun.tools.javac.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class HomeScreen extends JFrame implements ActionListener {
    static JFrame frame = new JFrame("McCarthy Book Store");
    JButton response;
    static JButton b1, quitButton;


    public HomeScreen() {
        //Create and set up the window.

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Size and display the window.
        Insets insets = frame.getInsets();
        //frame.setSize(1000 + insets.left + insets.right,
        //       500 + insets.top + insets.bottom);
        frame.setSize(700, 500);
        frame.setVisible(true);


    }

    public void actionPerformed(ActionEvent event) {        //JOHN WALSH NOTES
       String button;
        button = event.getActionCommand(); // what's written on the item that was clicked
         //note the String comparison
        if (button.equals("Quit")) {
            System.exit(0);
        } // end if
       else {
            response.setText("Menu Item '" + button + "' is selected.");
       } // end else
    } // end actionPerform

    public static void addComponentsToPane(Container pane) {
        pane.setLayout(null);
        //pane.setLayout(new BorderLayout());

        b1 = new JButton("Visit Book Store");
        quitButton = new JButton("Quit");

        /*File file = new File(getClass().getName().getResource("books.jpeg").getFile());
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //ImageIcon imageIcon = new ImageIcon("books2.jpeg");
        //System.out.println(imageIcon);


        JLabel jl = new JLabel(new ImageIcon("I:\\Object Orientated Programming\\OOP2019\\OOP Project 2019\\BookStore\\src\\books.png"));
        //JLabel jl = new JLabel(imageIcon);                        //IMAGE REFERENCE: http://www.iconarchive.com/show/my-seven-icons-by-itzikgur/books-1-icon.html
        JLabel label = new JLabel("Welcome to McCarthys Book Store");
        Font font = new Font("monospaced", Font.PLAIN, 24);
        //jl.setIcon(new ImageIcon("books.png"));
        //jl.();

        b1.setSize(30, 50);
        quitButton.setSize(30, 50);
        label.setFont(font);
        //  jl.setSize(10,10);

        //pane.add(jl, BorderLayout.CENTER);


        pane.add(b1);
        pane.add(quitButton);
        pane.add(jl);
        pane.add(label);


        Insets insets = pane.getInsets();
        Dimension size = b1.getPreferredSize();
        b1.setBounds(200 + insets.left, 380 + insets.top,
                size.width, size.height);
        size = quitButton.getPreferredSize();
        quitButton.setBounds(400 + insets.left, 380 + insets.top,
                size.width, size.height);

        size = jl.getPreferredSize();
        jl.setBounds(205 + insets.left, 100 + insets.top,
                size.width, size.height);
        size = label.getPreferredSize();
        label.setBounds(128 + insets.left, 60 + insets.top, size.width, size.height);

          ButtonEventHandler handler = new ButtonEventHandler();
        b1.addActionListener(handler);

        ButtonEventHandler handler2 = new ButtonEventHandler();
        quitButton.addActionListener(handler2);
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        HomeScreen a = new HomeScreen();

    }


    public static class ButtonEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
           if(e.getSource()==b1) {
               MainMenu menu = new MainMenu();
               menu.setVisible(true);

               frame.setVisible(false);
           }
           else if(e.getSource()==quitButton)
           {
               JOptionPane.showMessageDialog(null,"Program quitting now .....");
               System.exit(0);
           }

        }

        public void setVisible(HomeScreen frame) {
            frame.setVisible(false);
        }
    }
}

