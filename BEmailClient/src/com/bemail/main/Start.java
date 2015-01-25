package com.bemail.main;

import javax.mail.Message;
import javax.mail.MessagingException;

import com.bemail.email.EmailReceivingParameters;
import com.bemail.email.EmailSendingParameters;
import com.bemail.email.EmailService;
/**
 * Main Class for testing EmailService
 * @author Marcin
 *
 */
public class Start {

	public static void main(String[] args) 
	{
		try
		{	
			EmailSendingParameters emailSendingParameters = new EmailSendingParameters();
				emailSendingParameters.setEmailBody("Some email body");
				emailSendingParameters.setEmailReceiverAdress("lepek007@gmail.com");
				emailSendingParameters.setEmailBody("testowanie");
			
			EmailReceivingParameters emailReceivingParameters = new EmailReceivingParameters();
				emailReceivingParameters.setHostName("pop.gmail.com");
				emailReceivingParameters.setUserName("lepek007@gmail.com");
				emailReceivingParameters.setPassword("testowanie");
				
			EmailService emailService = new EmailService();
			emailService.generateAndSendEmail(emailSendingParameters);

		
			Message[] unreadMessages = emailService.readUnseenMessages(emailReceivingParameters);

		} 
		catch (MessagingException e) 	
		{
			e.printStackTrace();
		}
	}
	
}
