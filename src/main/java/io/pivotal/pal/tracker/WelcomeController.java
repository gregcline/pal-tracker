package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    HelloService helloService;


    public WelcomeController(@Autowired HelloService helloService) {
        this.helloService = helloService;

    }

    @GetMapping("/")
    public String sayHello() {
        return this.helloService.getMessage();
    }

}
