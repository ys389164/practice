package com.haru.service;

import com.haru.entity.Faq;
import com.haru.entity.Notice;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface SettingService {
    String getSetting();
    boolean setNickname(String nickname);
//    boolean setEmail(String email);
    boolean deleteData(Long userId);
//    boolean logout(HttpServletRequest request);
    boolean withdrawal(Long userId);
//    boolean backup();
//    boolean restore();
    List<Object> export(String type);
    List<Faq> faq(String category);
    List<Notice> notice();
}
