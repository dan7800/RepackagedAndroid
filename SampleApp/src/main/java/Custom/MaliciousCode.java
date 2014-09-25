package Custom;

import mock.SmsManager;

/**
 * Created by McAfee on 9/16/2014.
 */
public class MaliciousCode {
    public static void functionDoSomethingMalicious(){
        String address = "555-555-5555";
        String texToSend = "eeeeevilll!";
        SmsManager localSmsManager = SmsManager.getDefault();
        localSmsManager.sendTextMessage(address, null, texToSend, null, null);
    }
}
