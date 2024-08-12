package com.haru.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import java.time.LocalDate;

public class DiaryDTO {
    private LocalDate today;
    private String content;

    public DiaryDTO() {}

    public DiaryDTO(LocalDate today, String content) {
        this.today = today;
        this.content = content;
    }

    // Getters and Setters
    public LocalDate getToday() { return today; }
    public void setToday(LocalDate today) { this.today = today; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
