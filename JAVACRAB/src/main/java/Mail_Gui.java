import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mail_Gui {

    JFrame frame;
    JTextField subjectField;
    JTextArea bodyArea;
    JButton sendButton, clearButton, backButton;

    public Mail_Gui() {
        createGUI();
    }

    public void createGUI() {
        frame = new JFrame("Email Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        // Create subject field
        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(20, 20, 100, 30);
        subjectLabel.setForeground(Color.WHITE);
        frame.add(subjectLabel);

        subjectField = new JTextField();
        subjectField.setBounds(120, 20, 250, 30);
        subjectField.setForeground(Color.WHITE);
        subjectField.setBackground(Color.BLACK);
        frame.add(subjectField);

        // Create body area
        JLabel bodyLabel = new JLabel("Body:");
        bodyLabel.setBounds(20, 60, 100, 30);
        bodyLabel.setForeground(Color.WHITE);
        frame.add(bodyLabel);

        bodyArea = new JTextArea(5, 5);
        bodyArea.setForeground(Color.WHITE);
        bodyArea.setBackground(Color.BLACK);
        bodyArea.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        // Add JScrollPane
        JScrollPane scrollPane = new JScrollPane(bodyArea);
        scrollPane.setBounds(20, 90, 350, 160);
        frame.add(scrollPane);

        // Create buttons
        sendButton = new JButton("Send");
        sendButton.setBounds(20, 270, 100, 30);
        sendButton.setForeground(Color.WHITE);
        sendButton.setBackground(Color.BLACK);
        sendButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    String subject = subjectField.getText();
                    String body = bodyArea.getText();

                    mail m = new mail();
                    m.sendEmail(subject, body);
                 
                }
            }
        });
        frame.add(sendButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(140, 270, 100, 30);
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLACK);
        clearButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subjectField.setText("");
                bodyArea.setText("");
            }
        });
        frame.add(clearButton);

        backButton = new JButton("Back");
        backButton.setBounds(260, 270, 100, 30);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Login_1 l = new Login_1();
                l.gg();
            }
        });
        frame.add(backButton);

        frame.setVisible(true);
    }

    private boolean validateInput() {
        String subject = subjectField.getText();
        String body = bodyArea.getText();

        if (subject.isEmpty() || body.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (subject.length() > 500) {
            JOptionPane.showMessageDialog(frame, "Subject is too long", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (body.length() > 1000) {
            JOptionPane.showMessageDialog(frame, "Body is too long", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        new Mail_Gui();
    }
}