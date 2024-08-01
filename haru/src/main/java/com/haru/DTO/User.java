package com.haru.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String userId;
    private Long userRandomKey;
    private String nick;
    private String email;
    private String password;
}
