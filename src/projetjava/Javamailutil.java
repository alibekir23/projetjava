/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author msi
 */
public class Javamailutil {
    public static PasswordAuthentication sendMail(String Recipient,String msg ) throws Exception{
    
        System.out.print("preparing");
        
        Properties properties =new Properties();
    properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

  properties.put("mail.smtp.host", "smtp.gmail.com");

  properties.put("mail.smtp.port", "587");
                
                
  String myAccountEmail="elitschool202@gmail.com";
String password ="ELITESPRIT";



        Session session = Session.getInstance(properties, new Authenticator() {
 @Override
        protected  PasswordAuthentication getPasswordAuthentication ()
{
       return new PasswordAuthentication(myAccountEmail, password );
                }
        });



        Message message =prepareMessage (session, myAccountEmail, Recipient,msg);
        Transport.send(message );
                System.out.print("ok");
        return null;

        
    }
    
    
    private static Message prepareMessage (Session session ,String myAccountEmail , String Recipient,String msg ) 
    {
        try 
        {
            Message message =new MimeMessage (session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(Recipient));
            message.setSubject("Elit school");
            message.setText(msg);
            return message ; 
            
        
        
        } catch (Exception ex) {
            Logger.getLogger(Javamailutil.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return null ; 
    
        
    }

    
    
    
}

