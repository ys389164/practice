package com.haru;

import com.haru.entity.Faq;
import com.haru.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HaruApplication implements CommandLineRunner {

    @Autowired
    private FaqRepository faqRepository;

    public static void main(String[] args) {
        SpringApplication.run(HaruApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Faq> faqs = faqRepository.findByCategory(1);
        if (faqs.isEmpty()) {
            System.out.println("No FAQs found with groupId = 1");
        } else {
            faqs.forEach(faq -> System.out.println(faq.getTitle()));
        }
    }
}
