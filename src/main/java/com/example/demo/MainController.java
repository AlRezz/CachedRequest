package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/")
    public ResponseEntity<String> pay(@RequestBody MyBody myBody) {
        System.out.println(myBody);
        return ResponseEntity.ok("SUCCESS");
    }
}
