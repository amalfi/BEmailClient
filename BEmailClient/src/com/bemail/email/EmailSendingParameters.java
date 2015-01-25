package com.bemail.email;

/**
 * Object which contains information which are neccesary for sending emails
 * @author Marcin
 *
 */
public class EmailSendingParameters 
{

	private String emailBody;
	private String emailReceiverAdress;
	private String emailReceiverPassword;
	
	
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	public String getEmailReceiverAdress() {
		return emailReceiverAdress;
	}
	public void setEmailReceiverAdress(String emailReceiverAdress) {
		this.emailReceiverAdress = emailReceiverAdress;
	}
	public String getEmailReceiverPassword() {
		return emailReceiverPassword;
	}
	public void setEmailReceiverPassword(String emailReceiverPassword) {
		this.emailReceiverPassword = emailReceiverPassword;
	}

	
	
}
