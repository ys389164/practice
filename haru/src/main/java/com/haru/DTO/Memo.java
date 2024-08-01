package com.haru.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Memo {
    private Long memoId;
    private String userId;
    private Long folderId;
    private String title;
    private String content;
    private Date writeDate;
    private String filePath;
}
