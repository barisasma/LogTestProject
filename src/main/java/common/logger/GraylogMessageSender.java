package common.logger;

import java.io.IOException;

import org.graylog2.GelfMessage;
import org.graylog2.GelfSenderResult;
import org.graylog2.GelfUDPSender;

public class GraylogMessageSender implements Runnable{

    private GelfMessage message;
    private GelfUDPSender sender;
    private GelfSenderResult gelfResult;

    public void setMessage(GelfMessage message) {
        this.message = message;
    }

    public void setSender(GelfUDPSender sender) {
        this.sender = sender;
    }
    
    public void run() {
       
        if(message.isValid())
            gelfResult=sender.sendMessage(message);
        
        if(gelfResult.equals(GelfSenderResult.OK)){
            System.out.println("ok");
        }
        
        try {
            sender.getChannel().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }


}
