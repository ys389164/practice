package com.haru.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    private String userId;

    @ManyToOne
    @JoinColumn(name = "userRandomKey", nullable = false)
    private com.haru.entity.Userlists userlists;

    private String nick;
    private String email;
    private String password;
}
