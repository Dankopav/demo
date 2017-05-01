package hr.danko.RESTClient;

import hr.danko.controller.HomeController;
import hr.danko.model.Auto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by danko on 4/30/2017.
 */
/*Component*/
public class UserRestClient {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserRestClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public final static String userServiceUrl = "http://localhost:8080/getAuto";


    public Auto getAuto(){
        return this.restTemplate.getForObject(userServiceUrl,Auto.class);
    }


}
