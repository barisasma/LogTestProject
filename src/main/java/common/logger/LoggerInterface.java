package common.logger;

import java.io.IOException;
import java.util.Date;

import org.graylog2.GelfMessage;
import org.graylog2.GelfUDPSender;
import common.model.TestModel;
import common.threadpool.ThreadPool;

public class LoggerInterface {
    
    private static LoggerInterface instance = null; 
    private final static String GRAYLOGHOST= "192.168.56.103" ;
    private final static int GRAYLOGPORT = 12202;
    private static GelfUDPSender gelfUDPSender;
    
    public static LoggerInterface getInstance() throws IOException{

        if(instance == null){
            instance = new LoggerInterface();
            gelfUDPSender = new GelfUDPSender(GRAYLOGHOST, GRAYLOGPORT);
        }

        return instance;

    }
       
    public void sendTestModelMessage(TestModel tm,String shortMessage,String fullMessage, String level, String file){

        GelfMessage message = new GelfMessage(shortMessage, fullMessage, new Date().getTime(), level);
        message.addField("Code: ", tm.getCode()).addField("Name: ", tm.getName()).addField("Id: ", tm.getId());
        message.setHost("localhost");
        message.setFile(file);
        message.setFacility("F");
        
        GraylogMessageSender grayLogMessageSender = new GraylogMessageSender();
        grayLogMessageSender.setMessage(message);
        grayLogMessageSender.setSender(gelfUDPSender);
       
        submitMessage(grayLogMessageSender);
        
        
        
    }
    
    
    private void submitMessage(GraylogMessageSender sender){
        
        ThreadPool.getInstance().getExecutorService().submit(sender);
        
    }
    

}
