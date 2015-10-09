package CarnaticVideoUploader;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PasswordAuthenticator {
	
	/*
	 *  Should have At least one Uppercase, one lowercase , a special character ( @!&#$% ) , a digit [0-9] and minimum length of 5 .
	 * 
	 */
	private final static Logger LOGGER = Logger.getLogger(PasswordAuthenticator.class.getName()); 
	
	
	private boolean validatePassword(String password){
		
		LOGGER.entering("PasswordAuthenticator class", "validatePassword()");
		
		if(!password.isEmpty() && password != null){
			boolean  b = Pattern.matches("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@!&#$%]).{5,10})", password);
			
		if(!b){
			LOGGER.severe(" Not meeting the password criteria ");
		}else{
			LOGGER.fine(" Success the password matches " + "  Class --->  " + PasswordAuthenticator.class);
			
			// Write the password to the database
			
			return true;
		}}else{
			
			LOGGER.severe(" password cannot be blank ");
		}
		LOGGER.exiting("PasswordAuthenticator class", "validatePassword()");

		return false;
	}
	

}
