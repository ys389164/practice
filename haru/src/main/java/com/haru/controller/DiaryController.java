package com.haru.controller;

import com.haru.entity.Diary;
import com.haru.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @GetMapping("/statusTF")
    public Diary diaryStatus() {
        // 캘린더에 TF status 작성
        return diaryService.getStatusTF();
    }

    @GetMapping("/consecutive")
    public Long diaryConsecutive() {
        // 현재 작성 & 연속된 일자 count
        return diaryService.getConsecutive();
    }

    @GetMapping("/{date}")
    public Diary diary(@PathVariable String date) {
        // 특정 일자의 내용 갖고오기, 없으면 비어있음으로 출력
        return diaryService.getDiaryByDate(date);
    }

    @GetMapping("/checkToday")
    public boolean diaryCheckToday() {
        // table에 금일 contents가 비어있는 경우, today -> write로 넘어가기
        return diaryService.checkToday();
    }

    @GetMapping("view/{date}")
    public Diary diaryView(@PathVariable String date) {
        // 비어있지 않는 경우, view Page
        return diaryService.viewDiary(date);
    }

    @GetMapping("/view/{date}/navigate")
    public List<Diary> diaryViewNavigate(@PathVariable String date) {
        // 슬라이드로 이전 / 다음 날짜 넘기기
        return diaryService.navigateDiary(date);
    }

    @PostMapping("/cancel")
    public String diaryCancel() {
        // 작성 페이지에서 취소
        return diaryService.cancelDiary();
    }

    @PostMapping("/submit")
    public Diary diarySubmit(@RequestParam String date) {
        // 작성 페이지에서 작성, 모달 데이터 확인
        return diaryService.submitDiary(date);
    }

    @PostMapping("/modal/cancel")
    public String diaryModalCancel(@RequestParam String date) {
        // 모달에서 취소
        return diaryService.cancelModal(date);
    }

    @PostMapping("/modal/submit")
    public Diary diaryModalSubmit(@RequestParam String date) {
        // 모달에서 등록
        return diaryService.submitModal(date);
    }

    @PostMapping("/view/cancel")
    public String diaryCancelView(@RequestParam String date) {
        // 목록으로 돌아가기
        return diaryService.cancelView(date);
    }
}
