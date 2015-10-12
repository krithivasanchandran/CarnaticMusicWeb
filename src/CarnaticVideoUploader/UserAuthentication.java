package CarnaticVideoUploader;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class UserAuthentication {
	
	/*
	 * Should be a valid email id. 
	 * 
	 */
	
	private final static Logger LOGGER = Logger.getLogger(UserAuthentication.class.getName()); 
	
	public boolean validateUsername(String user){
		
		if(!user.isEmpty() && user  != null ){
			 if(Pattern.matches(".*[A-Z]*.", user)){
				 if(Pattern.matches(".*[a-z]*.", user)){
					 if(Pattern.matches(".*[0-9]*.", user)){
						 if(Pattern.matches(".*[@.]*.", user)){
							 if(Pattern.matches(".*[$#%!&(]*.", user)){
								 return false;
							 }else{
								 redirect(user);
							 } 
							 }
					 }
				 }
			 }
		 	}
		return false;
	}
	
	private void throwError(){  	LOGGER.severe(" Please enter a valid email address "); }
	
	private boolean redirect(String user){
		
		if(user.contains("@")){
			
			String[] uname = user.split("@");
			String domain = user.substring(user.indexOf("@")+1,user.length());
			
			if(uname[0].length() <= 64 && uname[0].length() == 0 ){
				String[] domainpart = domain.split(".");
				
				if(domainpart[0].length() == 0 ){
					LOGGER.severe("Address has no domain part " + " - > " + UserAuthentication.class);
					return false;
				}
				
				/*
				 * Checks for this validation .test@iana.org - not valid or test.@iani.org
				 */
				Pattern dotPatterns = Pattern.compile("^.+");
				Matcher match = dotPatterns.matcher(uname[0]);
			 	 
			 	if(match.matches() || uname[0].charAt(uname[0].length()) == '.' ){
			 		LOGGER.severe("Neither part of the address may begin with a dot " + " - > " + UserAuthentication.class);
			 		return false;
			 	}
			 	
			 	return true; 
			 	
			}else{
		 		LOGGER.severe("Address has no local part " + " - > " + UserAuthentication.class);
				return false;
			}
			
			// Write the username email id to the database - DAOManager
			
		}else{
			throwError();
			return false;
		}
	}
			
}
