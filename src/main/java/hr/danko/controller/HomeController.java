package hr.danko.controller;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by danko on 4/27/2017.
 */
@RestController
public class HomeController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home(){
        log.info("home called");
        return "Home";
    }




    @RequestMapping("/new")
        public String getNew(){
            return "New";
        }

    }


