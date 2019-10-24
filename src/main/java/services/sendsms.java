package services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

class Example {
    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "AC9ab48ebae0622c629adccf761e1c593e";
    public static final String AUTH_TOKEN = "ac147608d2fc4db2bfebf619d9db1c06";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+12244354506"),
                new com.twilio.type.PhoneNumber("+21625695185"),
                "Hi there!")
            .create();

        System.out.println(message.getSid());
    }
}