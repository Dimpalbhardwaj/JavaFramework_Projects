package com.integration.springwithstruts.dto;


public class Login {
	private String userName;
	private String pasword;
	private String successMessage;
	private String unsucessMessage;
	
	
	public Login() {
		System.out.println(this.getClass().getSimpleName()+"\t created....");
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the pasword
	 */
	public String getPasword() {
		return pasword;
	}

	/**
	 * @param pasword the pasword to set
	 */
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	
	
	/**
	 * @return the successMessage
	 */
	public String getSuccessMessage() {
		return successMessage;
	}

	/**
	 * @param successMessage the successMessage to set
	 */
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	/**
	 * @return the unsucessMessage
	 */
	public String getUnsucessMessage() {
		return unsucessMessage;
	}

	/**
	 * @param unsucessMessage the unsucessMessage to set
	 */
	public void setUnsucessMessage(String unsucessMessage) {
		this.unsucessMessage = unsucessMessage;
	}


	public String execute(){  
	    if(pasword.equals("javatpoint")){  
	        return "success";  
	    }  
	    else{  
	        return "error";  
	    }  
	}

}
