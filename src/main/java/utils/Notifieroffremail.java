/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author firos
 */
import services.*;
import javax.mail.internet.MimeMessage;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Notifieroffremail {

   public static void notifier (String email,String fullname, String titre, String entreprise) throws MessagingException {    
      // Recipient's email ID needs to be mentioned.
            String host ="smtp.gmail.com" ;
            String user = "smartstart.pidev@gmail.com";
            String pass = "/123456789p";
            String to = email ;
            
            String from ="shadow.smart.start@gmail.com" ;
            String subject = "Candidature acceptée";
           
            boolean sessionDebug = false;

            Properties props = System.getProperties();
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            
            Properties properties = System.getProperties();
            
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            
            Session mailSession = Session.getDefaultInstance(properties);
            mailSession.setDebug(sessionDebug);
            
            Message msg = new MimeMessage(mailSession);
            msg.setContent("<p>Bonjour <strong>"+fullname+"</strong></p>\n"+
                            "<p>Suite à candidature à l'offre <em>\""+titre+"\"</em>, L'Équipe <strong>"+entreprise+"</strong> vient d'accepter votre candidature. La date de l'entretien vous sera communiqu&eacute;e le plus t&ocirc;t possible.</p>\n" +
                            "<p>SmartStart.</p>","text/html");
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
