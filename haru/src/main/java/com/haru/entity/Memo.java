package com.haru.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "memo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memoId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "folderId", nullable = false)
    private Folderlist folderlist;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String contents;

    @Temporal(TemporalType.DATE)
    private Date writeDate;

    @Column(columnDefinition = "TEXT")
    private String filePath;
}
