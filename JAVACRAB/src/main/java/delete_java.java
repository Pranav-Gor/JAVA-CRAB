import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import oracle.jdbc.driver.OracleDriver;

public class delete_java {

    JFrame j;
    JTextField txt1;
    JLabel lbl1, lblAdmin;
    JButton btn, btnClear;

    public static void main(String[] args) {
        new delete_java().gg();
    }

    public void gg() {
        j = new JFrame();
        j.setLayout(null);
        j.setSize(500, 500);
        j.setTitle("Delete Data");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.getContentPane().setBackground(Color.BLACK);

        lblAdmin = new JLabel("Admin Delete");
        lblAdmin.setBounds(250, 50, 100, 30);
        lblAdmin.setForeground(Color.WHITE);
        j.add(lblAdmin);

        lbl1 = new JLabel("Email Id:");
        lbl1.setBounds(100, 100, 100, 30);
        lbl1.setForeground(Color.WHITE);
        j.add(lbl1);

        txt1 = new JTextField(20);
        txt1.setBounds(200, 100, 200, 30);
        txt1.setForeground(Color.WHITE);
        txt1.setBackground(Color.BLACK);
        j.add(txt1);

        btn = new JButton("Delete");
        btn.setBounds(150, 250, 100, 30);
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);
        j.add(btn);

        btnClear = new JButton("Clear");
        btnClear.setBounds(250, 250, 100, 30);
        btnClear.setForeground(Color.WHITE);
        btnClear.setBackground(Color.BLACK);
        j.add(btnClear);

        // Add a separator between the buttons
        JSeparator separator = new JSeparator();
        separator.setBounds(220, 250, 30, 30);
        separator.setForeground(Color.WHITE);
        j.add(separator);

        // Add action listeners for the buttons
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txt1.getText();
                if(email!=null  && !email.isEmpty())
                {
                    try
                    {
                        DriverManager.registerDriver(new OracleDriver());
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "manager");
                        String sql = "DELETE FROM email1 WHERE email = ?";
                        java.sql.PreparedStatement pps = con.prepareStatement(sql);
                        pps.setString(1, email);
                        int x = pps.executeUpdate();
                        if(x>0)
                        {
                            JOptionPane.showMessageDialog(j, "Data deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(j, "Invalid data!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    
                    catch (Exception e5) {
                        System.out.println(e5.getMessage());
                    }
                    
                }
                else
                {
                	JOptionPane.showMessageDialog(j, "Cannot Be Empty !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt1.setText("");
            }
        });
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.setVisible(false);
                Login_1 l =new Login_1();
                l.gg();
            }
        });
        back.setBounds(200, 300, 100, 30); // Set the coordinates for the back button
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        j.add(back);

        j.setVisible(true);
    }
}