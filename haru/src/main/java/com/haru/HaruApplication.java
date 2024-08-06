package com.haru;

import com.haru.entity.Faq;
import com.haru.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HaruApplication{
    public static void main(String[] args) {
        SpringApplication.run(HaruApplication.class, args);
    }
}
