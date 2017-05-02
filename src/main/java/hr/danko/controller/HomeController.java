package hr.danko.controller;

import hr.danko.model.Auto;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Created by danko on 4/27/2017.
 */
@RestController
public class HomeController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String home(){
        log.info("home called");
        return "Home";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    @ResponseBody
        public String getNew(){
            return "New";
        }


   @RequestMapping(value="/getAuto", method=RequestMethod.GET)
   @ResponseBody
        public Auto getAuto(){
            Auto auto=new Auto();
            auto.setId(1);
            auto.setName("Golf");
            return auto;
        }

    @RequestMapping(value="/math", method=RequestMethod.GET)
    @ResponseBody
    public String calculation(){
            return "Math pozvan";
    }
    @RequestMapping(value="/math/zbroj", method = RequestMethod.GET,produces={"application/json"})
    @ResponseBody
        public String suma(@RequestParam("broj") int broj){
            return "Unili ste broj:"+broj;
        }

    @RequestMapping("*")
    @ResponseBody
    public String fallbackMethod(){
        return "fallback method";
    }

}

