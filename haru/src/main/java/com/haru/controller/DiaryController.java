package com.haru.controller;

import org.springframework.web.bind.annotation.*;

@RestController("/api/diary")
public class DiaryController {

    @GetMapping("/statusTF")
    public String diaryStatus() {
//        캘린더에 TF status 작성
        return "OK";
    }

    @GetMapping("/consecutive")
    public String diaryConsecutive() {
//        현재 작성 & 연속된 일자 count
        return "OK";
    }

    @GetMapping("/{date}")
    public String diary(@PathVariable String date) {
//        특정 일자의 내용 갖고오기, 없으면 비어있음으로 출력
        return "OK";
    }

    @GetMapping("/checkToday")
    public String diaryCheckToday() {
//        table에 금일 contents가 비어있는 경우, today -> write로 넘어가기
        return "OK";
    }

    @GetMapping("view/{date}")
    public String diaryView(@PathVariable String date) {
//        비어있지 않는 경우, view Page
        return "OK";
    }

    @GetMapping("/view/{date}/navigate")
    public String diaryViewNavigate(@PathVariable String date) {
//        슬라이드로 이전 / 다음 날짜 넘기기
        return "OK";
    }

//    -------------
    @PostMapping("/cancel")
    public String diaryCancel() {
//        작성 페이지에서 취소
        return "OK";
    }

    @PostMapping("/submit")
    public String diarySubmit(@RequestParam String date) {
//        작성 페이지에서 작성, 모달 데이터 확인
        return "OK";
    }

//    --------------------
//    modal
    @PostMapping("/modal/cancel")
    public String diaryModalCancel(@RequestParam String date) {
//        모달에서 취소
        return "OK";
    }

    @PostMapping("/modal/submit")
    public String diaryModalSubmit(@RequestParam String date) {
//        모달에서 등록
        return "OK";
    }

//    ------------------
//    view
    @PostMapping("/view/cancel")
    public String diaryCancelView(@RequestParam String date) {
//        목록으로 돌아가기
        return "OK";
    }

}
