package hr.danko.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by danko on 4/27/2017.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){

        return "Home";
    }

    @RequestMapping("/new")
        public String getNew(){
            return "New";
        }

    }


