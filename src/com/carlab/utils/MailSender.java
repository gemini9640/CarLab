package com.carlab.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.carlab.vo.MailVo;

public class MailSender {
	public boolean sendTextMail(final MailVo mailInfo) throws Exception{    
	      Properties pro = mailInfo.getProperties();
	      if(pro ==null) 
	    	  	return false; 
	      Session sendMailSession = Session.getDefaultInstance(pro,mailInfo.isValidate()?null:new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailInfo.getUserName(), mailInfo.getPassword());
				}
	      });     
	      Message mailMessage = new MimeMessage(sendMailSession);    
	      Address from = new InternetAddress(mailInfo.getFromAddress(), mailInfo.getSenderName()==null?mailInfo.getFromAddress():mailInfo.getSenderName());    
	      mailMessage.setFrom(from);    
	      Address to = new InternetAddress(mailInfo.getToAddress()); 
	      mailMessage.setRecipient(Message.RecipientType.TO,to);    
	      mailMessage.setSubject(mailInfo.getSubject());    
	      mailMessage.setSentDate(new Date());    
	      mailMessage.setText(mailInfo.getContent());    
	      Transport.send(mailMessage); 
	      return true;    
	    }    
	       
	    public  boolean sendHtmlMail(final MailVo mailInfo) throws Exception{    
	      Properties pro = mailInfo.getProperties();  
	      if(pro ==null) 
	    	  	return false; 
	      Session sendMailSession = Session.getDefaultInstance(pro,mailInfo.isValidate()?null:new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailInfo.getUserName(), mailInfo.getPassword());
				}
	      });    
	      Message mailMessage = new MimeMessage(sendMailSession);    
	      Address from = new InternetAddress(mailInfo.getFromAddress(), mailInfo.getSenderName()==null?mailInfo.getFromAddress():mailInfo.getSenderName());    
	      mailMessage.setFrom(from);    
	      Address to = new InternetAddress(mailInfo.getToAddress());    
	      mailMessage.setRecipient(Message.RecipientType.TO,to);    
	      mailMessage.setSubject(mailInfo.getSubject());    
	      mailMessage.setSentDate(new Date());    
	      Multipart mainPart = new MimeMultipart();    
	      BodyPart html = new MimeBodyPart();    
	      html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");    
	      mainPart.addBodyPart(html);    
	      mailMessage.setContent(mainPart);    
	      Transport.send(mailMessage);    
	      return true;    
	    }    
}
