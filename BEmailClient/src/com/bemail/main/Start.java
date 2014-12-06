package com.bemail.main;

import javax.mail.Message;
import javax.mail.MessagingException;

import com.bemail.email.EmailCreator;
import com.bemail.email.EmailReceiver;
/**
 * Main Class
 * @author Marcin
 *
 */
public class Start {

	public static void main(String[] args) 
	{
		try
		{	
			EmailCreator emailCreator = new EmailCreator();
			emailCreator.generateAndSendEmail("Some email body <br> Greetings  : MB", "someemail@email.com", "somePassword");
		
			EmailReceiver emailReceiver = new EmailReceiver();
			/*Example properties for readUnseenMessages method
			 *String host = "pop.gmail.com";// change accordingly
		      String mailStoreType = "pop3";
		      String username = "yourmail@gmail.com";// change accordingly
		      String password = "*****";// change accordingly
			 */
			Message[] unreadMessages = emailReceiver.readUnseenMessages("pop.gmail.com", "someemail@email.com", "somePassword");
			//message.getFrom - to read who send email
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
	}

}
