package com.anhad.instadownloader;

//package com.javaguides.okhttp.tutorial.crud;

import java.io.IOException; //okhttp import packages
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.net.*;
import java.util.*;
//import java.io.*;
import org.apache.http.client.utils.URIBuilder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 
import org.apache.commons.validator.routines.UrlValidator; //package for checking URL

@RestController //Spring annotation for RESTful API,REST: representational state transfer
public class HelloController {
    @GetMapping("/")
	public String index() {
		return "Welcome to Instagram Downloader !!";
	}

    @GetMapping("/download")
    public String linkValidityCheck(@RequestParam(name = "link") String instalink) throws Exception{
        UrlValidator urlValidator = new UrlValidator();
        if(!urlValidator.isValid(instalink)){
            return "URL not valid";
        }
        //String path = instagramPath(instalink);
        return instaLinkAppend(instalink);
    }
    // private String getImageFromInstaLink(String instalink){
    //     return instalink;
    // }
    //    @Putmapping("/")
    // public static String instagramPath(String instalink) throws Exception {
    //     URL instalinkurl = new URL(instalink);
    //     return instalinkurl.getPath();
    // }
    // public static String getInstagramIDFromPath(String path) {
    //     String[] arr = path.split("/");
    //     return arr[0];
    // }
    // public static void accessToken(){
    //     InstagramService service = new InstagramAuthService();
    //         service.apiKey("your_client_id");
    //         service.apiSecret("your_client_secret");
    //         service.callback("your_callback_url");     
    //         service.build(); 
    //}
    @GetMapping("/append")
    public static String instaLinkAppend(@RequestParam(name = "link") String instalink) throws Exception{
        
        String str = new String("/media");
        String finalUrl = instalink + str;
        return finalUrl;
    }



}
