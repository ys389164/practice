package com.haru.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "adminId", nullable = false)
    private Integer id;

    @Column(name = "adminName")
    private String adminName;

    @OneToMany(mappedBy = "writer")
    private Set<Faq> faqs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "writer")
    private Set<Notice> notices = new LinkedHashSet<>();

}