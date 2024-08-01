package com.haru.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping
    public String home() {
        return "Hello World";
    }

    @GetMapping("/recentBundle")
    public String recentBundle() {
//        최근 일기, 메모 가져오기
        return "Hello World";
    }

    @GetMapping("/calendarBundle")
    public String calendarBundle() {
//        diary TF, calendar 일정 가져오기
        return "Hello World";
    }
}
