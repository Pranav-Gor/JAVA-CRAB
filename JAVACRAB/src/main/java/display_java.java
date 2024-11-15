import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import oracle.jdbc.driver.OracleDriver;

public class display_java {

    JFrame j;
    JTable jt;
    JScrollPane jp;
    JButton back;

    public static void main(String[] args) {
        new display_java().display();
    }

    public void display() {
        j = new JFrame();
        j.setLayout(null);
        j.setSize(500, 500);
        j.setTitle("Display Data");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.getContentPane().setBackground(Color.BLACK);

        String[] title = {"Email"};
        String[][] data = new String[0][1];

        try {
            DriverManager.registerDriver(new OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "manager");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT email FROM email1");

            int count = 0;
            while (rs.next()) {
                count++;
            }

            // Initialize the data array with the correct size
            data = new String[count][1];

            // Reset the result set to the beginning
            rs = stmt.executeQuery("SELECT email FROM email1");

            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                i++;
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        jt = new JTable(data, title);
        jt.setForeground(Color.white); // Change the foreground color to blue
        jt.setBackground(Color.black); // Change the background color to red
       
        jp = new JScrollPane(jt);
        jp.setBounds(50, 50, 400, 350);
        j.add(jp);

        back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.setVisible(false);
                Login_1 l =new Login_1();
                l.gg();
            }
        });
        back.setBounds(200, 410, 100, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        j.add(back);

        j.setVisible(true);
    }
}