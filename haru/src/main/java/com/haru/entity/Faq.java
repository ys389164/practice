package com.haru.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "faq")
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faqId", nullable = false)
    private Long faqId;

    @Column(name = "groupId")
    private Long groupId;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

}