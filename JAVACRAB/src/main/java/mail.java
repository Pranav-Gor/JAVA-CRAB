import javax.mail.*
;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


//password has been changed so application password is also reset so it wont send the email to send write the correct application password 

public class mail 
{
	
	 public void sendEmail(String subject, String body) {
		    String data = "";
		    try {
		        DriverManager.registerDriver(new OracleDriver());
		        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "manager");

		        String sql = "select * from email1";
		        PreparedStatement pps = con.prepareStatement(sql);
		        ResultSet rs = pps.executeQuery();

		        while (rs.next()) {
		            data += rs.getString(1) + "\n";
		        }
		        System.out.println(data);

		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }

		   
		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");

		   
		   //use your own username and the password (Application Password) here we have used the gmail service so generate it from the Google
		    String username;
		    
		    
		    String password;

		    
		    Session session = Session.getInstance(props, new Authenticator() 
		    {
		        @Override
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(username, password);
		        }
		    });

		    // Send the email
		    String[] toEmails = data.split("\\s+"); // split the data string into an array of email addresses
		    try {
		        // Create a new MimeMessage instance
		        MimeMessage msg = new MimeMessage(session);

		        // Set the message headers
		        msg.setFrom(new InternetAddress("pranavgor7777@gmail.com"));

		        // Add multiple recipients
		        for (String toEmail : toEmails) {
		            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail.trim()));
		        }

		        msg.setSubject(subject);

		        // Set the message content
		        msg.setText(body);

		        // Send the email
		        Transport.send(msg);
		        System.out.println("Email sent successfully!");

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
    public static void main(String[] args) 
    {
       
    }
    
   
}
