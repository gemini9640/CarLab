package com.carlab.vo;

import java.util.Properties;

public class MailVo {
	private String fromAddress;
	private String toAddress;
	private String senderName;
	private String userName;
	private String password;
	private boolean validate = false;
	private String subject;
	private String content;
	private Properties properties;

	public MailVo(MailType mail) {
		setProperties(mail);
	}
	public MailVo(String fromAddress, String toAddress, String userName,
			String password, String subject, String content, MailType mail) {
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.userName = userName;
		this.password = password;
		this.subject = subject;
		this.content = content;
		setProperties(mail);
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String textContent) {
		this.content = textContent;
	}

	public Properties getProperties() {
		return properties;
	}
	
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setProperties(MailType mail) {
		Properties p = null;
		switch(mail) {
			case GMAIL_TLS : 
				setValidate(true);
				p = new Properties();
				p.put("mail.smtp.host", "smtp.gmail.com");    
		      	p.put("mail.smtp.port", "587");    
		      	p.put("mail.smtp.auth", this.validate);   
		      	p.put("mail.smtp.starttls.enable", "true");
		      	break;
			case HOTMAIL : 
				break;
			case GMAIL_SSL : 
				break;
			default:
				break;
		} 
		this.properties = p;
	}

	public enum MailType {
		GMAIL_TLS, GMAIL_SSL, HOTMAIL
	}
}
