package APIJsonSI.APIUtility;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.testng.annotations.Test;


public class sendmail {
	
	public static void mail(String subject) {

	// Recipient's email ID needs to be mentioned.
//		String to = "aijaz@singleinterface.com, abhinav.singh@singleinterface.com, abhishek.jaiswal@singleinterface.com, aman.sharma@singleinterface.com,parul.kapoor@singleinterface.com, deepika.sheoran@singleinterface.com, ritu@singleinterface.com, deepak.ghorela@singleinterface.com ,naval.upadhyay@singleinterface.com ,ashish.tomar@singleinterface.com, bhaskar.vishwakarma@singleinterface.com, dinesh@singleinterface.com, sambhaturu.lokesh@singleinterface.com, nancey.srivastava@singleinterface.com, deepak.ghorela@singleinterface.com, khushboo.kashyap@singleinterface.com, dheeraj.bhatt@singleinterface.com, aashita.bhayana@singleinterface.com, priyanka.rautela@singleinterface.com";
			String to = "ritu@singleinterface.com";

			// Sender's email ID needs to be mentioned
			String from = "automationtestmail0204@gmail.com";

			final String username = "siclientsupport@singleinterface.com";//change accordingly
		    final String password = "M*A$97#DvP17*";//change accordingly

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
				messageBodyPart.setText("Hi Team, Please check Header and Footer API result report.");


				// Create a multipar message
				Multipart multipart = new MimeMultipart();

				//	         // Set text message part
				multipart.addBodyPart(messageBodyPart);

				// Part two is attachment
//		         messageBodyPart = new MimeBodyPart();
//		         String filename = System.getProperty("user.dir")+"\\src\\test\\java\\APIJsonSI\\APIUtility\\writeapiurl.xls";
//		         DataSource source = new FileDataSource(filename);
//		         messageBodyPart.setDataHandler(new DataHandler(source));
//		         messageBodyPart.setFileName(filename);
//		         multipart.addBodyPart(messageBodyPart);

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



