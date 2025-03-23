package kz.kbtu.consumingrestapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @GetMapping("/boom")
    public Quote quote(@Autowired RestTemplate restTemplate) {
        return restTemplate.getForObject(
                "http://localhost:8080/api/random", Quote.class);
    }
}
