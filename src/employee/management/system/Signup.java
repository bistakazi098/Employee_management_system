package employee.management.system;

// Import necessary Java Swing classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

// Define the Signup class that extends JFrame and implements ActionListener
public class Signup extends JFrame implements ActionListener {
    // Declare GUI components
    Choice loginASCho;
    TextField meterText, EmployerText, userNameText, nameText, passwordText;
    JButton create, back;

    // Constructor for the Signup class
    Signup() {
        super("Signup Page");
        getContentPane().setBackground(new Color(255, 255, 255)); // Set background color

        // Create and position "Create Account As" label
        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30, 50, 125, 20);
        add(createAs);

        // Create and position user type choice component
        loginASCho = new Choice();
        loginASCho.add("Admin");
        loginASCho.setBounds(170, 50, 120, 20);
        add(loginASCho);





        // Create and position employer ID label
        JLabel Employer = new JLabel("Employer ID");
        Employer.setBounds(30, 100, 125, 20);
        Employer.setVisible(true);
        add(Employer);

        // Create and position employer ID text field
        EmployerText = new TextField();
        EmployerText.setBounds(170, 100, 125, 20);
        EmployerText.setVisible(true);
        add(EmployerText);

        // Create and position username label
        JLabel userName = new JLabel("UserName");
        userName.setBounds(30, 140, 125, 20);
        add(userName);

        // Create and position username text field
        userNameText = new TextField();
        userNameText.setBounds(170, 140, 125, 20);
        add(userNameText);

        // Create and position name label
        JLabel name = new JLabel("Name");
        name.setBounds(30, 180, 125, 20);
        add(name);

        // Create and position name text field
        nameText = new TextField("");
        nameText.setBounds(170, 180, 125, 20);
        add(nameText);



        // Create and position password label
        JLabel password = new JLabel("Password");
        password.setBounds(30, 220, 125, 20);
        add(password);

        // Create and position password text field
        passwordText = new TextField();
        passwordText.setBounds(170, 220, 125, 20);
        add(passwordText);

        // Add item listener to the user type choice component

        // Create and position "Create" button
        create = new JButton("Create");
        create.setBackground(new Color(66, 127, 219));
        create.setForeground(Color.black);
        create.setBounds(50, 285, 100, 25);
        create.addActionListener(this);
        add(create);

        // Create and position "Back" button
        back = new JButton("Back");
        back.setBackground(new Color(66, 127, 219));
        back.setForeground(Color.black);
        back.setBounds(180, 285, 100, 25);
        back.addActionListener(this);
        add(back);

        // Load and display boy icon
        ImageIcon boyIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Signup/download.png"));
        Image boyImg = boyIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImg);
        JLabel boyLabel = new JLabel(boyIcon2);
        boyLabel.setBounds(320, 30, 250, 250);
        add(boyLabel);

        // Set JFrame size, location, layout, and visibility
        setSize(600, 380);
        setLocation(500, 200);
        setLayout(null);
        setVisible(true);
    }

    // ActionListener interface method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
          //
            String sloginAs = loginASCho.getSelectedItem();
            String  semployeid = EmployerText.getText();
            String susername = userNameText.getText();
            String sname = nameText.getText();
            String spassword = passwordText.getText();

            try{
                Conn c = new Conn();
                String query= null;
                if (sloginAs.equals("Admin")) {
                    query = "INSERT INTO Signup (employe_id, username, user, password) VALUES ('" + semployeid + "', '" + susername + "', '" + sname + "', '" + spassword + "')";
                } else {
                    query = "UPDATE Signup SET username = '" + susername + "', password = '" + spassword + "' WHERE employe_id = '" + semployeid + "'";

                }
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created");
                setVisible(false);
                new Login();

            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        new Signup();
    }
}
