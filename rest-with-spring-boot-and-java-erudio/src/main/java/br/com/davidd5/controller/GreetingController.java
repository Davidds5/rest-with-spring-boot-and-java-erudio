package br.com.davidd5.controller;

import br.com.davidd5.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "Word")
            Object name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));

    }
}
