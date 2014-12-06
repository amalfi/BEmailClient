package com.bemail.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EmailCreator
{
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
 
	/**
	 * Method which use javax.mail API for sending email to : sEmailReceiver  with sEmailBody param
	 * @param sEmailBody
	 * @param sEmailReceiverAdress
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void generateAndSendEmail(String sEmailBody, String sEmailReceiverAdress, String sEmailReceiverPassword) throws AddressException, MessagingException {
 
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
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sEmailReceiverAdress));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(sEmailReceiverAdress));
		generateMailMessage.setSubject("Greetings from Crunchify..");
		String emailBody = "EMAIL CONTENT (with html tags)";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		//Step3		
		System.out.println("Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		System.out.println("Sending message");
		transport.connect("smtp.gmail.com", sEmailReceiverAdress, sEmailReceiverPassword); 
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		System.out.println("Message sended properly");
		transport.close();
	}
}
