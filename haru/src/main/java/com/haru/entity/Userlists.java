package com.haru.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userlists")
@Getter
@Setter
public class Userlists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRandomKey;

    private String nick;
}
