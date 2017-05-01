package hr.danko.Config;

import hr.danko.RESTClient.UserRestClient;
import hr.danko.controller.ScheduledJob;
import hr.danko.model.Auto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by danko on 5/1/2017.
 */
@Configuration
public class ConfigApp {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ConfigApp.class);

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public UserRestClient user(){
        return new UserRestClient();
    }


    @Autowired
    private Environment env;

    @PostConstruct
    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
    /* Auto auto=new Auto();
       auto=this.restTemplate().getForObject("http://localhost:8080/getAuto",Auto.class);
       log.info(auto.toString());*/
       log.info("huhuuhu");
    }

    //DataSource config
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        log.info("Datasource created succesfully");
        return dataSource;
    }

}