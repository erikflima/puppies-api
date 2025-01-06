package com.redthreadinnovations.puppies.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO: Documentar essa classe com JavaDoc.
@RestController
@RequestMapping("teste")
public class TesteController {

    private static final Logger logger = LoggerFactory.getLogger( TesteController.class );

    public TesteController(){

    }


    //TODO: Documentar essa classe com JavaDoc.
    @GetMapping("/hello") 
    public String hello() {

        System.out.println("OHHHHHHH que legal");
        
        return "OHHHHHHH que legal";
    }

}