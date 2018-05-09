package forbeatdev.userrestapi.util;

import java.util.concurrent.TimeUnit;

public class OuterRequest {

    public static void sendRequest(){
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
