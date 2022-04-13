package com.example.springbootlogging.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogEndpoint {

    @GetMapping
    public String getDetails(){
        log.info("Get Details method BAŞLADIII.");
        return internalMessage();
    }

    private String internalMessage() {
        try {
            log.debug("InternalMessage methodu BAŞLADIII ");
            Thread.sleep(1000);
            return "API Log Message";
        }catch (InterruptedException ex){
            log.error("Hata:{}" ,ex);
        }
    return "";
    }

}
