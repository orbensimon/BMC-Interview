import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
public class MailSender 
{

	public static void send(Email email)
	{  
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", email.serverAddress);    
        props.put("mail.smtp.socketFactory.port", email.port);    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", email.port);    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(email.src,email.password);  
         }    
        });    
        try 
        {    
            MimeMessage message = new MimeMessage(session);    
            message.setFrom(new InternetAddress(email.src));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email.dest));        
            message.setText(email.body);    
            //send message  
            Transport.send(message);    
            System.out.println("message sent successfully");    
         }
         catch (MessagingException e)
         {
        	 System.out.println("Problem occured during mail sent");
        	 e.printStackTrace();
         }    
        
              
     }  
}