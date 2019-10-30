/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author radhwen
 */
import javax.mail.internet.MimeMessage;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class sendReclamation {
    
        public static void sendRc(String email ,String Recl)throws MessagingException{
            String host ="smtp.gmail.com" ;
            String user = "firas.trabelsi.1@esprit.tn";
            String pass = "183JMT3413";
            String to =email ;
            String from ="shadow.smart.start@gmail.com" ;
            String subject = "reclamation sur un commentaire ";
            
            Properties props = System.getProperties();
            Properties properties = System.getProperties();
            Session mailSession = Session.getDefaultInstance(properties);
            Message msg = new MimeMessage(mailSession);
            msg.setText("salut admin ce message est envoyer par \n "+email+"a envoyer une reclamation \n"+Recl);


            
            boolean sessionDebug = false;

          //  Properties props = System.getProperties();
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
 //Properties properties = System.getProperties();
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
           // Session mailSession = Session.getDefaultInstance(properties);
            mailSession.setDebug(sessionDebug);
          //  Message msg = new MimeMessage(mailSession);
            /*msg.setContent("<html><head></head><body><img src=\"https://i.imgur.com/qhhfrRM.png\" alt=\"\" border=\"0\" style=\"width:143px;height:143px;\" data-pagespeed-url-hash=\"2423233612\" onload=\"pagespeed.CriticalImages.checkImageForCriticality(this);\">\n" +
"\n" +
"<br>Hello Adim , this a reclamation /n "+Recl+""+
"\n" +
"\n" +
"<br><br>\n" +
"\n" +
"this is automated mail from our server .\n" +
"\n" +
"Thanks ,\n" +
"<br><br>\n" +
"<div style=\"font-size:9px;font-family:Arial;color:#959595;margin-left:10px;margin-right:30px;\">\n" +
"<br><p>\n" +
"This email w<span><font>a</font></span>s sent to Your Em<span><font>a</font></span>il, bec<span><font>a</font></span>use your em<span><font>a</font></span>il preferences <span><font>a</font></span>re set to receive \"News <span><font>a</font></span>nd Promotions\". Click here to Unsubscribe.<br></p>\n" +
"<p>Copyright © 2019 Inc. <span><font></font></span></p></div></body></html>","text/html");*/
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
}
        }

