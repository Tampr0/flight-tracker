package flighttracker;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class WhatsAppTest {
    public static void main(String[] args) {
        String accountSid = System.getenv("TWILIO_ACCOUNT_SID");
        String authToken  = System.getenv("TWILIO_AUTH_TOKEN");
        String from       = System.getenv("WHATSAPP_FROM");
        String to         = System.getenv("WHATSAPP_TO");

        if (from == null || from.isBlank()) {
            from = "whatsapp:+14155238886"; // Twilio Sandbox domyślnie
        }

        if (accountSid == null || authToken == null || to == null) {
            System.err.println("Brak ENV: TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN, WHATSAPP_TO");
            System.exit(1);
        }

        Twilio.init(accountSid, authToken);

        Message msg = Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(from),
                "✅ Test z Twilio Sandbox (Java / flight-tracker)"
        ).create();

        System.out.println("Wysłano. SID: " + msg.getSid());
    }
}
