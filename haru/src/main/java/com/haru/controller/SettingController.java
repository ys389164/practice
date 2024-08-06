package com.haru.controller;

import com.haru.entity.Faq;
import com.haru.entity.Notice;
import com.haru.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
public class SettingController {

    @Autowired
    private SettingService settingService;


    @GetMapping("")
    public String getSettings() {
// 환경 onload
// 로그인을 했는지 안했는지 확인하는 함수
// login true : 유저 닉네임 + 이메일, login false : 게스트 표기, 랜덤 코드 표기
// table에서 가져오기
        return settingService.getSetting();
    }

    @PutMapping("/account/nickname")
    public boolean setNickname(@RequestParam("nickname") String nickname) {
//        로그인 시, 뜨는 버튼 '계정관리'
//        계정관리 창 내부 버튼 '닉네임 변경' 클릭
//        닉네임 변경 후 data 전송 하는 버튼
        return settingService.setNickname(nickname);
    }

    @PutMapping("/account/email")
    public boolean setEmail(@RequestParam("email") String email) {
        //        로그인 시, 뜨는 버튼 '계정관리'
//        계정관리 창 내부 버튼 '이메일 변경' 클릭
//        이메일 변경 후 data 전송 하는 버튼
//        이메일 변경된 이후, 로그아웃 시키기
        return settingService.setEmail(email);
    }

    @DeleteMapping("/account/deleteData")
    public boolean deleteData(@RequestParam("email") String nickname) {
        //        로그인 시, 뜨는 버튼 '계정관리'
//        계정관리 창 내부 버튼 '데이터 삭제' 클릭
//        모달 띄우기
//        모달에서 확인 누를 시, 데이터 삭제 but 계정 정보는 삭제 X
        return settingService.deleteData();
    }

    @PostMapping("/account/logout")
    public boolean logout() {
        //        로그인 시, 뜨는 버튼 '계정관리'
//        계정관리 창 내부 버튼 '로그아웃' 클릭
//        로그아웃, 데이터 삭제 X
        return settingService.logout();
    }

    @DeleteMapping("/account/withdrawal")
    public boolean withdrawal() {
//        회원탈퇴, 데이터 삭제 및 계정 정보 삭제
//        모달 띄우기
//        모달에서 확인 누를 시, 회원 탈퇴.
        return settingService.withdrawal();
    }

    @PostMapping("/backAndRecover/backup")
    public boolean backup() {
//        로그인을 해야한 사용할 수 있는 기능
//        백업 google Drive 사용
        return settingService.backup();
    }

    @PostMapping("/backAndRecover/restore")
    public boolean restore() {
//        로그인을 해야만 사용할 수 있는 기능
//        복구 google Drive 사용, 이전의 데이터는 다 삭제시키기
//          모달 띄우기
        return settingService.restore();
    }

    @GetMapping("/export/{category}")
    public List<Object> export(@RequestParam("type") String type) {
        return settingService.export(type);
        /*byte[] data = settingService.export(type);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("export.txt").build());
        headers.setContentType(MediaType.TEXT_PLAIN);
//        위의 3가지를 묶어서 해도 되는거고?
        return new ResponseEntity<>(data, headers, HttpStatus.OK);*/
    }

    @GetMapping("/faq/{category}")
    public List<Faq> faq(@PathVariable String category) {
//        FAQ 창
//        계정, 메모, 일기, 기타 버튼 보유
//        해당 버튼을 누를 때마다 DB에서 해당 베이터의 Q데이터, A데이터 보내기
        return settingService.faq(category);
    }

    @GetMapping("/notice")
    public List<Notice> notice() {
//        공지사항. 버전 별로 담기
//        버전별 title, contents 데이터 전체 다 보내기
        return settingService.notice();
    }
}