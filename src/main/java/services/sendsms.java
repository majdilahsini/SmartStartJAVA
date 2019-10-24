package services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

class Example {
    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "PNe2bcb6897c840db06fc5989e0ebd7ce0";
    public static final String AUTH_TOKEN = "665ec9681f5f6eb6dafaba85b4f36e6a";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21625695185"),
                new com.twilio.type.PhoneNumber("+12244354506"),
                "Hi there!")
            .create();

        System.out.println(message.getSid());
    }
}