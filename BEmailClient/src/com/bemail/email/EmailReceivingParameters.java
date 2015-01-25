package com.bemail.email;

/**
 * Object which contains information which are neccesary for receiving
 * @author Marcin
 *
 */

public class EmailReceivingParameters 
{
	private String hostName;
	private String userName;
	private String password;
	
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
