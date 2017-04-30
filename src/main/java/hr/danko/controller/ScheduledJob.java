package hr.danko.controller;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledJob {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ScheduledJob.class);

    @Scheduled(fixedRate = 5000)
    public void scheduledLogger(){
       log.info("bla");

    }
}
