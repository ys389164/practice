package com.haru.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "folderlist")
@Getter
@Setter
public class Folderlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folderId;

    private String folderName;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;
}
