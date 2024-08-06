package com.haru.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Column(name = "contents")
    private String contents;

}