package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {

    JTable table; // Table to display employee data
    Choice choiceEMP; // Drop-down choice for selecting employee ID
    JButton searchbtn, print, update, back; // Buttons for actions

    View_Employee() {
        getContentPane().setBackground(new Color(115, 104, 248)); // Set background color

        // Create and customize the "Search by employee id" label
        JLabel search = new JLabel("Search by employee id");
        search.setBounds(20, 20, 200, 20);
        add(search);

        // Create and customize the choice dropdown for employee ID selection
        choiceEMP = new Choice();
        choiceEMP.setBounds(220, 20, 100, 20);
        choiceEMP.setBackground(new Color(255,255,255));
        add(choiceEMP);

        try {
            // Populate the choice dropdown with employee IDs from the database
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            //display all the choice from empid
            while (resultSet.next()) {
                choiceEMP.add(resultSet.getString("eid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the table to display employee data
        table = new JTable();
        try {
            // Populate the table with employee data from the database
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create and customize the scroll pane for the table id ovelflow
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        // Create buttons for different actions
        searchbtn = new JButton("Search");
        searchbtn.setBounds(20, 70, 90, 20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(130, 70, 90, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(240, 70, 90, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(350, 70, 90, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn) {
            // Search for and display employee data based on the selected employee ID
            String query = "select * from employee where eid = '" + choiceEMP.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                // Print the contents of the displayed table
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
            // Open the UpdateEmployee frame with the selected employee ID
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
        } else {
            // Return to the main menu
            setVisible(false);
            new Main();
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
