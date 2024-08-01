package com.haru.controller;

import com.haru.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
public class SettingController {

    @Autowired
    private SettingService settingService;


    @GetMapping("")
    public String getSettings() {
//        환경 onload
        return "ook";
    }

    @PutMapping("/account/nickname")
    public String setNickname(@RequestParam("nickname") String nickname) {
//        닉네임 변경
        return "";
    }

    @PutMapping("/account/email")
    public String setEmail(@RequestParam("email") String email) {
//        이메일 변경? 얘는 로그아웃 시킬지 고민 중
        return "";
    }

    @PostMapping("/backup")
    public String backup() {
//        백업 google Drive 사용
        return "";
    }

    @PostMapping("/restore")
    public String restore() {
//        복구 google Drive 사용, 이전의 데이터는 다 삭제시키기
        return "";
    }

    @GetMapping("/export/memo")
    public String exportMemo() {
        return "";
    }

    @GetMapping("/export/diary")
    public String exportDiary() {
        return "";
    }

    @GetMapping("/export/all")
    public String exportAll() {
        return "";
    }

    @GetMapping("/export")
    public String export(@RequestParam("type") String type) {

        return "";
    }

    @GetMapping("/faq/{category}")
    public String faq(@PathVariable String category) {
        return "";
    }

    @GetMapping("/notice")
    public String notice() {
        return "";
    }
}