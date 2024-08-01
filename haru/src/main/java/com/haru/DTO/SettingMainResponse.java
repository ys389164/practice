package com.haru.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingMainResponse {
    private String userType;
    private String userCode;
    private String nickname;
    private String email;
    private boolean loginRequired;
}
