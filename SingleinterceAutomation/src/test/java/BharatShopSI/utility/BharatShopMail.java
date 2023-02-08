package BharatShopSI.utility;

import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

public class BharatShopMail {
	
	public static void mail(String subject, URL fileurl) {

	     // Recipient's email ID needs to be mentioned.
//		String to = "aijaz@singleinterface.com, sambhaturu.lokesh@singleinterface.com, shailendra@singleinterface.com, dheeraj.bhatt@singleinterface.com, vikas.upadhyay@singleinterface.com, aman.sharma@singleinterface.com,parul.kapoor@singleinterface.com, deepika.sheoran@singleinterface.com, ritu@singleinterface.com, naval.upadhyay@singleinterface.com, aashita.bhayana@singleinterface.com, khushboo.kashyap@singleinterface.com, priyanka.rautela@singleinterface.com";
		String to = "ritu@singleinterface.com";
	    
		// Sender's email ID needs to be mentioned
	      String from = "automationscripts@singleinterface.com";

	      final String username = "automationscripts@singleinterface.com";//change accordingly
	      final String password = "ZZH3=uAe1";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
	         });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(subject);

	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText("Hi Team,"+"\n"+"\n"+"Please click on the link to check Bharat Shop URL result report."+"\n"+"\n"+fileurl);
	        

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

//	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

//	         // Part two is attachment
//	         messageBodyPart = new MimeBodyPart();
//	         String filename = "D:\\DDWorkspace\\Bharat.Shop\\src\\main\\java\\Singleinterface\\BharatShop\\excel\\write.xls";
//	         DataSource source = new FileDataSource(filename);
//	         messageBodyPart.setDataHandler(new DataHandler(source));
//	         messageBodyPart.setFileName(filename);
//	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");
	  
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	   }

}
