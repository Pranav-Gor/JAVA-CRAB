import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login_1 {

    JFrame j;
    JButton btn1, btn2, btn3, btn4, btn5, btn6;

   
    public static void main(String[] args) {
        new Login_1().gg();
    }

    public void gg() {
        j = new JFrame();
        j.setLayout(null);
        j.setSize(500, 500);
        j.setTitle("Login System");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.getContentPane().setBackground(Color.BLACK);

       
        btn1 = new JButton("Insert");
        btn1.setBounds(50, 150, 100, 30);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.BLACK);
        j.add(btn1);

        btn2 = new JButton("Update");
        btn2.setBounds(170, 150, 100, 30);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.BLACK);
        j.add(btn2);

        btn3 = new JButton("Delete");
        btn3.setBounds(290, 150, 100, 30);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.BLACK);
        j.add(btn3);

        btn4 = new JButton("Display");
        btn4.setBounds(50, 200, 100, 30);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.BLACK);
        j.add(btn4);

        btn5 = new JButton("Send Email");
        btn5.setBounds(170, 200, 100, 30);
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(Color.BLACK);
        j.add(btn5);

       
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	j.setVisible(false);
                insert_java i= new insert_java();
                i.gg();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               update_java u =new  update_java();
               u.gg();
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               delete_java d =new delete_java();
               d.gg();
         
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                display_java d4 = new display_java();
                d4.display();
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
          
            	Mail_Gui hh = new Mail_Gui();
            	hh.createGUI();
            }
        });

       

        j.setVisible(true);
    }
}