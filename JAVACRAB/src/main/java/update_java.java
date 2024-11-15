import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import oracle.jdbc.driver.OracleDriver;

public class update_java {

    JFrame j;
    JTextField txt1, txt2;
    JLabel lbl1, lbl2, lblAdmin;
    JButton btn, btnClear;

    public static void main(String[] args) {
        new update_java().gg();
    }

    public void gg() {
        j = new JFrame();
        j.setLayout(null);
        j.setSize(500, 500);
        j.setTitle("Update Data");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.getContentPane().setBackground(Color.BLACK);

        lblAdmin = new JLabel("Admin Update");
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

        lbl2 = new JLabel("New Name:");
        lbl2.setBounds(100, 150, 100, 30);
        lbl2.setForeground(Color.WHITE);
        j.add(lbl2);

        txt2 = new JTextField(20);
        txt2.setBounds(200, 150, 200, 30);
        txt2.setForeground(Color.WHITE);
        txt2.setBackground(Color.BLACK);
        j.add(txt2);

        btn = new JButton("Update");
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
                String newName = txt2.getText();
               
                if(email!=null && newName!=null && !email.isEmpty() && !newName.isEmpty())
                {
                	try
                	{
                		DriverManager.registerDriver(new OracleDriver());
                		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "manager");
                		String sql = "UPDATE email1 SET name = ? WHERE email = ?";
                		PreparedStatement pps = con.prepareStatement(sql);
                		pps.setString(1, newName);
                		pps.setString(2, email);
                		int x = pps.executeUpdate();
                		
                		if(x>0)
                		{
                			JOptionPane.showMessageDialog(j, "Data Updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                		}
                		else
                		{
                			JOptionPane.showMessageDialog(j, "Something Went Wrong!", "Error", JOptionPane.INFORMATION_MESSAGE);
                		}
                	}
                	catch (Exception e5) {
					
                		System.out.println(e5.getMessage());
					}
                }
                else
                {
                	JOptionPane.showMessageDialog(j, "Cannot Be Empty  !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt1.setText("");
                txt2.setText("");
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