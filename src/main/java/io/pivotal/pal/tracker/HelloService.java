package io.pivotal.pal.tracker;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class HelloService {


   public String getMessage() {
       return "Hello from Cloud Foundry";

    }
}
