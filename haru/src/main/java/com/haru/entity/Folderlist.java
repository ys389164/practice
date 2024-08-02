package com.haru.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "folderlist")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Folderlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folderId;

    private String folderName;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;
}
