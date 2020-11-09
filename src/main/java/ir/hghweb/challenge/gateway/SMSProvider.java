package ir.hghweb.challenge.gateway;

import java.util.Random;

public class SMSProvider {

    private String baseUrl = "https://sms-provider/messages/send-sms";

    public boolean sendSms(String msg, String target){
        Random random = new Random();
        int n = random.nextInt(50);
        return n < 35;
    }
}
