package com.maoyan.util;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;

public class MailUtils {

  public static void sendMail(String email, String emailMsg)
		  throws AddressException, MessagingException {
//创建配置对象，用于连接邮件服务器的参数配置
	Properties props = new Properties();

	// 创建验证器
	Authenticator auth = new Authenticator() {
	  public PasswordAuthentication getPasswordAuthentication() {
		//设置发送人的帐号和密码
		return new PasswordAuthentication("aaa@hutao.com", "aaa");
	  }
	};
//创建一个程序与邮件服务器会话对象 Session
	Session session = Session.getInstance(props, auth);

	// 2.创建一个Message，它相当于是邮件内容
	Message message = new MimeMessage(session);

	//设置发送者
	message.setFrom(new InternetAddress("aaa@hutao.com"));

	//设置发送方式与接收者
	message.setRecipient(RecipientType.TO, new InternetAddress(email));

	//设置邮件主题
	message.setSubject("用户激活");
	// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");
	String url = "http://localhost/store/UserServlet?method=active&code=" + emailMsg;
	String content = "<h1>来自购物天堂的激活邮件!激活请点击以下链接!</h1><h3><a href='" + url + "'>" + url + "</a></h3>";
	//设置邮件内容
	message.setContent(content, "text/html;charset=utf-8");
	// 3.创建 Transport用于将邮件发送
	Transport.send(message);
	System.out.println("发送邮件成功！");
  }
}
