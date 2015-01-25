package com.bemail.email;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Class which contains method for sendning emails and receiving emails
 * If you wnat to generate and send email : you need do creat EmailSendingParameters class object
 * If you want to receive emails : you need to create EmailReceivingParameters class object
 * @author Marcin
 *
 */
public class EmailService
{
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
 
	/**
	 * Method for sending emails : EmailSendingParameters class object as a parameters required
	 * @param emailParameters
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void generateAndSendEmail(EmailSendingParameters emailParameters) throws AddressException, MessagingException {
 
		//Step1		
		System.out.println("Setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		//Step2
		System.out.println("Get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailParameters.getEmailReceiverAdress()));
		generateMailMessage.setSubject("Greetings from Crunchify..");
		String emailBody = "EMAIL CONTENT (with html tags)";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		//Step3		
		System.out.println("Get Session	and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		System.out.println("Sending message");
		transport.connect(/*smtp.gmail.com", emailReceiverAdress* emailReceiverPassword*/); 
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		System.out.println("Message sended properly");
		transport.close();
	}
	/**
	 * Function which returns array of unread messages - as array of Messages objects
	 * @param host
	 * @param user
	 * @param password
	 */
	public Message[] readUnseenMessages(EmailReceivingParameters emailReceivingParameters)
	{
		 Message[] messages=null;
		try
		{
			
	      Properties properties = new Properties();

	      properties.put("mail.pop3.host", emailReceivingParameters.getHostName());
	      properties.put("mail.pop3.port", "995");
	      properties.put("mail.pop3.starttls.enable", "true");
	      Session emailSession = Session.getDefaultInstance(properties);
	  
	      //create the POP3 store object and connect with the pop server
	      Store store = emailSession.getStore("pop3s");

	      store.connect(emailReceivingParameters.getHostName(), emailReceivingParameters.getUserName(), emailReceivingParameters.getPassword());

	      //create the folder object and open it
	      Folder emailFolder = store.getFolder("INBOX");
	      emailFolder.open(Folder.READ_ONLY);

	      // retrieve the messages from the folder in an array and print it
	      messages = emailFolder.getMessages();
	      System.out.println("messages.length---" + messages.length);

	      for (int i = 0, n = messages.length; i < n; i++) 
	      {
	         Message message = messages[i];
	         System.out.println("---------------------------------");
	         System.out.println("Email Number " + (i + 1));
	         System.out.println("Subject: " + message.getSubject());
	         System.out.println("From: " + message.getFrom()[0]);
	         System.out.println("Text: " + message.getContent().toString());

	      }

	      emailFolder.close(false);
	      store.close();

	      } 
		  catch (NoSuchProviderException e) 
		  {
	        e.printStackTrace();
	      } 
		  catch (MessagingException e) 
		  {
	         e.printStackTrace();
	      } 
		  catch (Exception e) 
		  {
	         e.printStackTrace();
	      }
		return messages;
	}
}
