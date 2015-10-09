package CarnaticVideoUploader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.logging.Logger;
import java.util.regex.Pattern;
java.util.logging.Logger;

/*
 *  www.youtube.com/watch?v=Cfd9DOnuF9w
 *  Checks if the parsed URL has one of these mandatory parameters
 *  Connection Time out = 1000 ms
 *  Read Time out = 1000 ms  // Please do change these value if the broadband connection is slow
 *  Strictly not following any redirects
 */

final class ValidateYouTubeURL {
	
	private final static Logger LOGGER = Logger.getLogger(ValidateYouTubeURL.class.getName()); 
	
	
	
	public void validateUrl(String urlString){
		
		
	    String parsedUrlString = (String) urlString.subSequence(0, urlString.indexOf("?"));
		boolean validURL  = Pattern.matches(".*(www{1}+)*.", parsedUrlString);
		if(validURL){
			if(Pattern.matches(".*(youtube{1}+)*.", parsedUrlString)){
				if(Pattern.matches(".*(.com{1}+)*.", parsedUrlString)){
					if(Pattern.matches(".*(http://{1}+)*.", parsedUrlString)){
						if(Pattern.matches(".*(/watch{1}+)*.", parsedUrlString)){
							LOGGER.fine(" THE INPUT URL IS A YOUTUBE URL AND IS A VALID ONE ");
							checkforConnection(urlString);
						}
						
					}
				}
			}
		}}
	
	public void checkforConnection(String uniformLocator ){
		try{
			URL url = new URL(uniformLocator);
		    HttpURLConnection httpconnection = (HttpURLConnection) url.openConnection();
		   
		    httpconnection.setAllowUserInteraction(false);
		    httpconnection.setConnectTimeout(1000);
		    httpconnection.setDefaultUseCaches(true);
		    httpconnection.setReadTimeout(1000);
		    httpconnection.setRequestMethod("GET");
		    httpconnection.setFollowRedirects(false);
		    
		    httpconnection.connect();
		    
		    int responseCode = httpconnection.getResponseCode();
		    
		    if(responseCode  == 200 ){ 
		    	LOGGER.fine("The URL Is a valid one since the response code is 200 OK " );
		    }else{ 
		    	LOGGER.severe("The youtube URL isnt a valid one ");
		    }
		    
			
		}catch(SocketTimeoutException timeOutException){
			LOGGER.severe("Time out exception has occured when checking for the valid URL Please check you internet"
					+ "connection and try attempting it again");
		}catch(MalformedURLException urlException){
			LOGGER.severe(" The URL is not available or doesnot exists in youtube");
		}catch(IOException exception){
			LOGGER.log(LOGGER.getLevel(), "checkforConnection Method in ValidateYouTubeURL class");
			LOGGER.severe("IO Exception has occured " + exception.getMessage());
		}}
}
