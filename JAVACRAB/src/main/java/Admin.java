import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin {

    JFrame j;
    JTextField txt1;
    JPasswordField txt2;
    JLabel lbl1, lbl2, lbl3;

    public static void main(String[] args) {
        new Admin().login();
    }

    public void login() {
        j = new JFrame();
        j.setLayout(null);
        j.setSize(500, 500);
        j.setTitle("Login Admin");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.getContentPane().setBackground(Color.BLACK);

        lbl1 = new JLabel("Username:");
        lbl1.setBounds(100, 100, 100, 30);
        lbl1.setForeground(Color.WHITE);
        j.add(lbl1);

        txt1 = new JTextField(20);
        txt1.setBounds(200, 100, 200, 30);
        txt1.setForeground(Color.WHITE);
        txt1.setBackground(Color.BLACK);
        j.add(txt1);

        lbl2 = new JLabel("Password:");
        lbl2.setBounds(100, 150, 100, 30);
        lbl2.setForeground(Color.WHITE);
        j.add(lbl2);

        txt2 = new JPasswordField(20);
        txt2.setBounds(200, 150, 200, 30);
        txt2.setForeground(Color.WHITE);
        txt2.setBackground(Color.BLACK);
        j.add(txt2);

        javax.swing.JButton btn = new javax.swing.JButton("Login");
        btn.setBounds(200, 250, 100, 30);
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);
        j.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txt1.getText();
                String password = new String(txt2.getPassword());

                if (username.equals("admin@lol32") && password.equals("system32")) {
                    JOptionPane.showMessageDialog(j, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Login_1 a = new Login_1();
                    a.gg();
                    j.setVisible(false);
                    
                    
                } else {
                    JOptionPane.showMessageDialog(j, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        j.setVisible(true);
    }
}