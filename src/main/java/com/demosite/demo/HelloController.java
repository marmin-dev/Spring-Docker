package com.demosite.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    @GetMapping
    public String HelloReturn(){
        return "안녕하세요!";
    }
    @GetMapping("/data")
    public String DataReturn(){
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://newsapi.org/v2/everything?q=tesla&from=2023-02-05&sortBy=publishedAt&apiKey=e5a4e0995eaa4c389c235ca18629912c";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String responseBody = response.getBody();
        return responseBody;
    }
}
