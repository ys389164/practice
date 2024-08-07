package com.haru.controller;

import com.haru.entity.Faq;
import com.haru.entity.Notice;
import com.haru.service.SettingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    /*@DeleteMapping("/account/deleteData")
    public boolean deleteData(@RequestParam("userId") Long userId) {
        //        로그인 시, 뜨는 버튼 '계정관리'
//        계정관리 창 내부 버튼 '데이터 삭제' 클릭
//        모달 띄우기
//        모달에서 확인 누를 시, 데이터 삭제 but 계정 정보는 삭제 X
        return settingService.deleteData(userId);
    }*/

    @DeleteMapping("/account/deleteData")
    public ResponseEntity<String> deleteData(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok("데이터 삭제 확인을 위한 모달");
    }

    @PostMapping("/account/deleteData/confirmSuccess")
    public ResponseEntity<String> deleteConfirmSuccess(@RequestParam("userId") Long userId) {
        boolean success = settingService.deleteData(userId);
        if (success) {
            return ResponseEntity.ok("데이터가 성공적으로 삭제되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("데이터 삭제에 실패했습니다.");
        }
    }


    @PostMapping("/account/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        boolean success = settingService.logout(request);
        if (success) {
            return ResponseEntity.ok("로그아웃 되었습니다. 게스트 상태로 돌아갑니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("로그아웃에 실패했습니다.");
        }
        //        로그인 시, 뜨는 버튼 '계정관리'
//        계정관리 창 내부 버튼 '로그아웃' 클릭
//        로그아웃, 데이터 삭제 X
    }

    @DeleteMapping("/account/withdrawal")
    public ResponseEntity<String> withdrawal() {
//        회원탈퇴, 데이터 삭제 및 계정 정보 삭제
//        모달 띄우기
//        모달에서 확인 누를 시, 회원 탈퇴.
        return ResponseEntity.ok("계정 삭제 확인을 위한 모달");
    }

    @PostMapping("/account/withdrawal/confirmSuccess")
    public ResponseEntity<String> withdrawalConfirmSuccess(@RequestParam("userId") Long userId) {
        boolean success = settingService.withdrawal(userId);
        if (success) {
            return ResponseEntity.ok("데이터가 성공적으로 삭제되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("데이터 삭제에 실패했습니다.");
        }
    }


    @PostMapping("/backAndRecover/backup")
    public ResponseEntity<String> backup(@AuthenticationPrincipal UserDetails userDetails) {
//        로그인을 해야한 사용할 수 있는 기능
//        백업 google Drive 사용
        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login required");
        }
        boolean success = settingService.backup();
        if (success) {
            return ResponseEntity.ok("Backup successful");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Backup failed");
        }
    }

    @PostMapping("/backAndRecover/restore")
    public ResponseEntity<String> restore(@AuthenticationPrincipal UserDetails userDetails) {
        //        로그인을 해야만 사용할 수 있는 기능
//        복구 google Drive 사용, 이전의 데이터는 다 삭제시키기
//          모달 띄우기
        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login required");
        }
        boolean success = settingService.restore();
        if (success) {
            return ResponseEntity.ok("Restore successful");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Restore failed");
        }
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