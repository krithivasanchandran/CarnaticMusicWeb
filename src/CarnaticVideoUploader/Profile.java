package CarnaticVideoUploader;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/*
 *  Premium - 1 Year ($99.00) Premium - 2 Year ($179.00)
 *  
 */

// Blocker need to perform OAUTH for this particular profile class

final class Profile  {
	
	private final static Logger LOGGER = Logger.getLogger(Profile.class.getName()); 
	
	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private String role;
	private int level;
	private String memberships;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		if(id < 1){
			LOGGER.fine("The id is less than 0" + Profile.class);
		}else{
			this.id = id;
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if(new UserAuthentication().validateUsername(username)
				&& username != null && !username.isEmpty()){
			this.username = username;
		}else{
			LOGGER.severe("USERNAME ISNT A VALID ONE ENTER YOUR VALID EMAIL ID AGAIN");
		}
		
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		if(Pattern.matches("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,10})" , firstname)){
			this.firstname = firstname;
		}else{
		     System.out.println(" Your firstname should not contain any special characters and should be atleast 5 letters ");
		}
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		if(Pattern.matches("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,10})" , firstname)){
			this.lastname = lastname;
		}else{
		System.out.println(" Your lastname should not contain any special characters and should be atleast 5 letters ");
		}
	
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getMembership() {
		return memberships;
	}
	public void setMembership(int membership) {
		if(membership == 1){
			memberships = "Premium - 1 Year";
		}else if(membership == 2){
			memberships = "Premium - 2 Year";
		}
	}

}
