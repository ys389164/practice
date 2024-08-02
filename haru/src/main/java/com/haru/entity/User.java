package com.haru.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
