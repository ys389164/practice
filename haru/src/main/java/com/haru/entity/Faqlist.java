package com.haru.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "faqlist")
public class Faqlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupId", nullable = false)
    private int groupId;

    @Column(name = "groupName")
    private String groupName;

    @OneToMany(mappedBy = "group")
    private Set<Faq> faqs = new LinkedHashSet<>();

}
