package employee.management.system;

import javax.swing.*;
import java.awt.*;

// Splash class extends JFrame to create a splash screen
public class Splash extends JFrame {

    // Constructor for the Splash class
    Splash() {

        // Load the image for the splash screen
        //getting the image icon
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/Employee-Management-System-Apps.png"));
        // Scale the image to the desired size
        Image imageOne = imageIcon.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageOne);

        // Create a JLabel to dispdday the scaled image
        JLabel imageLabel = new JLabel(imageIcon2);
        add(imageLabel);

        // Set the size and position of the splash screen
        setSize(800, 600);
        setLocation(300, 70);
        setVisible(true);

        try {
            // Pause the execution for 10 seconds (10000 milliseconds)
            Thread.sleep(6000);
            setVisible(false); // Hide the splash screen

            // Create a new instance of the Login class
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        new Splash(); // Create an instance of the Splash class
    }
}
