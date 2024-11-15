import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import oracle.jdbc.driver.OracleDriver;

public class insert_java {

    JFrame j;
    JTextField txt1, txt2;
    JLabel lbl1, lbl2, lblAdmin;
    JButton btn, btnClear;

    public static void main(String[] args) {
        new insert_java().gg();
    }

    public void gg() {
    	
    	    j = new JFrame();
    	    j.setLayout(null);
    	    j.setSize(500, 500);
    	    j.setTitle("Insert Data");
    	    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    j.getContentPane().setBackground(Color.BLACK);

    	    lblAdmin = new JLabel("Admin Insert");
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

    	    lbl2 = new JLabel("Name:");
    	    lbl2.setBounds(100, 150, 100, 30);
    	    lbl2.setForeground(Color.WHITE);
    	    j.add(lbl2);

    	    txt2 = new JTextField(20);
    	    txt2.setBounds(200, 150, 200, 30);
    	    txt2.setForeground(Color.WHITE);
    	    txt2.setBackground(Color.BLACK);
    	    j.add(txt2);

    	    btn = new JButton("Insert");
    	    btn.setBounds(150, 250, 100, 30);
    	    btn.setForeground(Color.WHITE);
    	    btn.setBackground(Color.BLACK);
    	    j.add(btn);

    	    btnClear = new JButton("Clear");
    	    btnClear.setBounds(290, 250, 100, 30);
    	    btnClear.setForeground(Color.WHITE);
    	    btnClear.setBackground(Color.BLACK);
    	    j.add(btnClear);

    	    
    	    
    	
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txt1.getText();
                String name = txt2.getText();
                

                if (validateEmail(email)) {
                    System.out.println("Email Id: " + email + ", Name: " + name);
                    
                    try
                    {
                    	DriverManager.registerDriver(new OracleDriver());
                    	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "manager");
                    	String sql = "insert into email1 values(?)";
                    	PreparedStatement pps = con.prepareStatement(sql);
                    	
                    	pps.setString(1, email);
                    	int x = pps.executeUpdate();
                    	
                    	if(x>0)
                    	{
                    		JOptionPane.showMessageDialog(j, "Data inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    	}
                    	else
                    	{
                    		 JOptionPane.showMessageDialog(j, "invalid Data !", "Error", JOptionPane.ERROR_MESSAGE);
                    	}
                    	
                    }
                    catch(Exception e5)
                    {
                    	System.out.println(e5.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(j, "Invalid email address!", "Error", JOptionPane.ERROR_MESSAGE);
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

    public boolean validateEmail(String email) {
        String regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}