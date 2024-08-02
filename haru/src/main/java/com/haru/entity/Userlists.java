package com.haru.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userlists")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Userlists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRandomKey;

    private String nick;
}
