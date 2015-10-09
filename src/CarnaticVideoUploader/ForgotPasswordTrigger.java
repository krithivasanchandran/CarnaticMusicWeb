package CarnaticVideoUploader;

public class ForgotPasswordTrigger {
	 
	/*
	 *  User enters the user name 
	 */
	
	private String username = request.getParameter("UserSuppliedName");
	
	private String fetchUserName(DAO dao){
	   // Use select query to fetch and compare the username
	 
		if(username.equalsIgnoreCase(daousername)){
			// Mail is trigger with the Mail Dispatcher service with the password 
		}
	}
	
	public void ForgotPassword(){
		fetchUserName(dao);
	}

}
