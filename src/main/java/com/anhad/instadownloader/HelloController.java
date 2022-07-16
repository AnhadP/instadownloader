package com.anhad.instadownloader;

import java.lang.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.validator.routines.UrlValidator;

@RestController
public class HelloController {
    @GetMapping("/")
	public String index() {
		return "Hello from Anhad!";
	}

    @GetMapping("/download")
    public String download(@RequestParam(name = "link") String instalink){
        UrlValidator urlValidator = new UrlValidator();
        if(!urlValidator.isValid(instalink)){
            return "URL not valid";
        }
        return instalink;
    }
}
