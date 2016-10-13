package common.controller;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import common.logger.LoggerInterface;
import common.model.TestModel;



@Controller
public class WelcomeController {

    private static final Logger logger = Logger.getLogger(WelcomeController.class);

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView getWelcome() throws IOException{

        TestModel tm = new TestModel(12345, "123456", "TestModel Name");
        LoggerInterface.getInstance().sendTestModelMessage(tm, "Done", "Done is real", "3", this.getClass().getName());


        //logs exception
        logger.error("This is Error message", new Exception("Testing"));


        ModelAndView model = new ModelAndView("welcome");
        model.addObject("msg", "Hello Spring MVC + Log4j");

        return model;

    }


}
