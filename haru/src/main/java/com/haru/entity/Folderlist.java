package com.haru.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

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
    private int folderId;

    private String folderName;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "folderlist")
    private Set<Memo> memos = new LinkedHashSet<>();

}
