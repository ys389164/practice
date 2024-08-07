package com.haru.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "diary")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Diary {

    @Id
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate today;


    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String contents;

    @Column(columnDefinition = "TEXT")
    private String filePath1;

    @Column(columnDefinition = "TEXT")
    private String filePath2;

    @Column(columnDefinition = "TEXT")
    private String filePath3;
}
