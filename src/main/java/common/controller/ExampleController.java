package common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import common.model.TestModel;

@Controller
public class ExampleController {
    private static final Logger logger = Logger.getLogger(WelcomeController.class);
    
    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public ModelAndView getExample(){
        
        //logs debug message 
        if(logger.isInfoEnabled()){
            logger.info("pnrNO: B9W67L");
        }

        //logs exception
        logger.error("This is Error message", new Exception("Testing"));
       
        TestModel tm = new TestModel(12345, "123456", "TestModel Name");
        System.out.println(tm);
        
        System.setProperty("userfilename", "BARIS");
        logger.error("AKIN SARIGUL");
        
        logger.info(tm + " is calculated");
        

        ModelAndView model = new ModelAndView("Example");
        model.addObject("msg", "Example MVC + LOG4J Graylog");

        return model;

    }
}
