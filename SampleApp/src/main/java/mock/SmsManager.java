package mock;

/**
 * Created by McAfee on 9/21/2014.
 */
public class SmsManager {

    public static SmsManager getDefault(){
        return new SmsManager();
    }

    public void sendTextMessage(String destinationAddress, String scAddress, String text, Object sentIntent, Object deliveryIntent){
        //STUB
    }
}
