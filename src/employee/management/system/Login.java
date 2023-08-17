package employee.management.system;
// Import necessary Java Swing and AWT classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// Define the Login class that extends JFrame and implements ActionListener
public class Login extends JFrame implements ActionListener {
    // Declare GUI components
    JTextField userText, passwordText;
    Choice loginChoice;
    JButton loginButton, cancelButton, signupButton;

    // Constructor for the Login class
    Login() {
        // Set JFrame title and background color
        super("Login");
        getContentPane().setBackground(Color.white);

        // Create and position username label
        JLabel username = new JLabel("UserName");
        username.setBounds(300, 60, 100, 20);
        add(username);

        // Create and position username text field
        userText = new JTextField();
        userText.setBounds(400, 60, 150, 20);
        add(userText);

        // Create and position password label
        JLabel password = new JLabel("Password");
        password.setBounds(300, 100, 100, 20);
        add(password);

        // Create and position password text field
        passwordText = new JTextField();
        passwordText.setBounds(400, 100, 150, 20);
        add(passwordText);

        // Create and position "Loggin In As" label
        JLabel loggin = new JLabel("Loggin In As");
        loggin.setBounds(300, 140, 100, 20);
        add(loggin);

        // Create and position user type choice component
        loginChoice = new Choice();
        loginChoice.add("Admin");

        loginChoice.setBounds(400, 140, 150, 20);
        add(loginChoice);

        // Create and position login button
        loginButton = new JButton("Login");
        loginButton.setBounds(330, 180, 100, 20);
        loginButton.addActionListener(this);
        add(loginButton);

        // Create and position cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(460, 180, 100, 20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        // Create and position signup button
        signupButton = new JButton("Signup");
        signupButton.setBounds(400, 215, 100, 20);
        signupButton.addActionListener(this);
        add(signupButton);

        // Load and display profile picture
        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icon/Login/vecteezy_cloud-computing-modern-flat-concept-for-web-banner-design_5879539.jpg"));
        Image profileTwo = profileOne.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTwo);
        JLabel profileLabel = new JLabel(fprofileOne);
        profileLabel.setBounds(5, 5, 250, 250);
        add(profileLabel);

        // Set JFrame size, location, layout, and visibility
        setSize(640, 300);
        setLayout(null);
        setLocation(400, 200);
        setVisible(true);
    }

    // ActionListener interface method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            /*  */ try {
                String username = userText.getText();
                String password = passwordText.getText();

                Conn conn = new Conn();
                String query = "select * from Signup where username = '"+ username +"' and password = '"+password+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);

                    new Main();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == cancelButton) {
            // Hide the login window
            setVisible(false);
        } else if (e.getSource() == signupButton) {
            // Hide the login window and open Signup window
            setVisible(false);
            new Signup();
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        new Login();
    }
}
