package br.com.davidd5.controller;

import br.com.davidd5.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String testLog(){
        logger.debug("This in an DEBUG log");
        logger.info("This in an INFO log");
        logger.warn("This in an WARN log");
        logger.info("This in an INFO log");
        logger.error("This in an ERROR log");
        return "Logger generated successfully";
    }
}
