package com.haru.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notice")
public class Notice {

    @Id
    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "contents", columnDefinition = "LONGTEXT")
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writerId")
    private Admin writer;

}