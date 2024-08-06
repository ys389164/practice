package com.haru.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="diary")
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
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String filePath1;
    private String filePath2;
    private String filePath3;
}
