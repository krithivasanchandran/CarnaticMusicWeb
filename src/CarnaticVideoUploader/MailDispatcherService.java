package CarnaticVideoUploader;

import java.util.Properties;
import java.util.Random;

public class MailDispatcherService {
	
	private static String constant = "FRKalyan"; 
	
	 Properties props = new Properties();
     Session session = Session.getDefaultInstance(props, null);
     
     String body = "Please enter  the Activation code : " + ActivationCodeGenerator();

     try{
    	 Message msg = new MimeMessage(session);
         msg.setFrom(new InternetAddress("flute raman email id ", "Status message "));
         
         // Use DAO object or other getter method to the username or email id 
         
         msg.addRecipient(Message.RecipientType.TO,
                          new InternetAddress(" user name i.e. email id from the DAO object ", "Mr. User"));
         msg.setSubject("Flute Raman Kalyan videos User activation code ");
         msg.setText(body);
         Transport.send(msg);
         
     } catch (AddressException e) {
         System.out.println(  " ----> Address not a valid email addresss ");
     } catch (MessagingException e) {
         System.out.println(" Failed to send the email addresss ");
         // Request redirect after this.
         
     }
     
     // Creating a random activation code 
     
    
	synchronized String ActivationCodeGenerator(){
		
		Random rand = new Random();
	    int gen = rand.nextInt();	
	    
	    restart:
	    while(gen < 0 ){
	    	gen = rand.nextInt();
	    	continue restart;
	    }
	    
	    String activatorCode = constant+gen+"";
	    // Write activator code to DAO
	    
	    return activatorCode;
	}}
