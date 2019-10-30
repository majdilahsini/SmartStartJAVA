package services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import utils.crypter;




public class SmsSender {

    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC5dfeb964bd28258b8e448a8eeb62ce42";
    public static final String AUTH_TOKEN = "4e20739faef240fe55581ee5cf022155";

    public static void SendSMS(String to, String username ,String password){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message
                .creator(new com.twilio.type.PhoneNumber(to),  // to
                         new com.twilio.type.PhoneNumber("+12562903658"),  // from
                         "your login informations are username : "+username+"password : "+password)
                .create();
    }
}