package hr.danko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = "hr.danko")
@SpringBootApplication
@EnableScheduling
public class Main {

    public static void main(String[] args){

        SpringApplication.run(Main.class,args);
    }
}
