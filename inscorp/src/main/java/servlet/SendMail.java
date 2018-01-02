package servlet;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 */

/** Class using for send mail 
 * @author shenaikabilova
 *
 */
public class SendMail {
	/** This method sending mail to the specified email contains specified user and pass
	 * @param user string field contains user name
	 * @param pass string field contains password
	 * @param email string field contains email
	 */
	public void sendMail (String user, String pass, String email) {
		final String userName = "meil;
		final String password = "pass";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true"); 

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
        
        try {
        	Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
            message.setSubject("Óñïåøíà ðåãèñòðàöèÿ!");
            message.setText("Ïîòðåáèòåëñêî èìå: " + user + ". Ïàðîëà: " + pass);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}
}
