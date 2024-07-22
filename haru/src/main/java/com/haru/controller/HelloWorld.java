package com.haru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloWorld {

    @GetMapping("/showMe")
    public List<String> hello() {
        return Arrays.asList("첫번째 인사", "두번째 인사");
    }

    @GetMapping("/api/hello")
    public String apiHello() {
        return "Hello World";
    }

    @PostMapping("/wal")
    public String wal() {
        return "Hello Wald";
    }
}
