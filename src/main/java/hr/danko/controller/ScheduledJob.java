package hr.danko.controller;

import hr.danko.RESTClient.UserRestClient;
import hr.danko.model.Auto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ScheduledJob {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ScheduledJob.class);

    @Autowired
    UserRestClient user;

    @Autowired
    RestTemplate restTemplate;

    //schedulirano svakih 500 sekundi
    @Scheduled(fixedRate = 500000)
    public void scheduledLogger(){
       log.info("bla");
    }

    //schedulirano svakih 300 sekundi
    @Scheduled(fixedRate = 300000)
    public void scheduledLogger2(){
            log.info("debug");
        }

    @Scheduled(fixedRate = 5000)
    public void printAuto(){
        Auto auto=restTemplate.getForObject("http://localhost:8080/getAuto", Auto.class);
        log.info(auto.toString());

    }

}
