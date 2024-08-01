package com.haru.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Dairy {
    private Long id;
    private LocalDate today;
    private User user;
    private String title;
    private String content;
    private String filePath1;
    private String filePath2;
    private String filePath3;
}
