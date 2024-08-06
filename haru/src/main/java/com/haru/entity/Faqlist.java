package com.haru.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "faqlist")
public class Faqlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupId", nullable = false)
    private Integer groupId;

    @Column(name = "name")
    private String name;

}