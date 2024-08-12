package com.haru.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String randomKey;

    @Column(unique = true)
    private String email;

    private String nickName;

    @Column(unique = true)
    private String googleId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference // Prevents infinite recursion in the Diary side
    private Set<Diary> diaries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Folderlist> folderlists = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Memo> memos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Session> sessions = new LinkedHashSet<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}