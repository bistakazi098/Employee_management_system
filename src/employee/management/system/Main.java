package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    Main() {
        // Create the JFrame and set its properties
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Home/replicate-prediction-zrzhuzbbhs3cgt7lcwlrrucexe.png"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        // Create and customize the heading label
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340, 155, 600, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);

        // Create "Add Employee" button
        JButton add = new JButton("Add Employee");
        add.setBounds(335, 270, 150, 40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        // Create "View Employee" button
        JButton view = new JButton("View Employee");
        view.setBounds(565, 270, 200, 40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);
            }
        });
        img.add(view);

        // Create "Remove Employee" button
        JButton rem = new JButton("Remove Employee");
        rem.setBounds(440, 370, 200, 40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.BLACK);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        img.add(rem);

        //create a Signout button

        JButton Signout = new JButton("Signout");
        Signout.setBounds(565, 370, 200, 40);
        Signout.setForeground(Color.WHITE);
        Signout.setBackground(Color.BLACK);
        Signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Signout) {
                    setVisible(false);
                    new Login(); // out the program
                }
            }
        });
        img.add(Signout);

        // Set JFrame properties
        setSize(1120, 630);
        setLocation(120, 5);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
