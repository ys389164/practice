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
    public List<String> diaryStatus() {
        // 캘린더에 TF status 작성
//        오늘 날짜에서 이전의 것들은 전부 F, 만약 일기가 있다면 T
//        return 형태는 list 형으로
        return diaryService.getStatusTF();
    }

    @GetMapping("/consecutive")
    public Long diaryConsecutive() {
        // 오늘 날짜에서 바로 전 날부터 count, 이전 날에 일기가 있으면 +1, f가 나올 때 까지 +1, f면 break
//        return 형태는 정수형으로
        return diaryService.getConsecutive();
    }

    @GetMapping("/{date}")
    public Diary diary(@PathVariable String date) {
//        캘린더 클릭 시, 해당 날짜를 받아오기
        // 특정 일자의 내용 갖고오기, 없으면 비어있음으로 출력
        return diaryService.getDiaryByDate(date);
    }

    @GetMapping("/checkToday")
    public boolean diaryCheckToday() {
//        @GetMapping("/{date}") 가 "비어있음"으로 출력되는 경우
//        해당 칸을 클릭하면 금일 날짜를 가져간 상태로 write 페이지로 넘어가기
        return diaryService.checkToday();
    }


//    조회페이지
    @GetMapping("view/{date}")
    public Diary diaryView(@PathVariable String date) {
        // 비어있지 않는 경우, view Page
        return diaryService.viewDiary(date);
    }

    @GetMapping("/view/{date}/navigate")
    public List<Diary> diaryViewNavigate(@PathVariable String date) {
        // 슬라이드로 이전 / 다음 날짜 넘기기
//        비어있지 않은 이전 페이지, 다음 페이지로 넘어가기
//        만약 끝이면 슬라이드가 불가능하게끔.

        return diaryService.navigateDiary(date);
    }

    @PostMapping("/view/cancel")
    public String diaryCancelView(@RequestParam String date) {
        // 목록으로 돌아가기
        // redirect? history.go(-1) ? 이런걸 써서 전으로 못돌리나
        return diaryService.cancelView(date);
    }

//    작성 페이지
    @PostMapping("/cancel")
    public String diaryCancel() {
        // 작성 페이지에서 취소, history.go(-1) 이런 걸 써서 뒤로가기로 데이터 복구 못하게 막기
        return diaryService.cancelDiary();
    }

    @PostMapping("/submit")
    public Diary diarySubmit(@RequestParam String date) {
        // 작성 페이지에서 작성 이후 데이터를 등록하는 버튼,
        // 처음 등록하는 경우, 모달 창 띄우기
        // 만약 전에 모달에 '다시보지 않기'를 체크한 경우, 모달없이 바로 데이터 저장, 다이어리 메인 페이지로 넘어가기
        return diaryService.submitDiary(date);
    }

    @PostMapping("/modal/cancel")
    public String diaryModalCancel(@RequestParam String date) {
        // 모달에서 취소
//        작성 페이지에 계속 남아있기
        return diaryService.cancelModal(date);
    }

    @PostMapping("/modal/submit")
    public Diary diaryModalSubmit(@RequestParam String date) {
        // 모달에서 등록
//        다이어리 메인 페이지로 넘어가기
//        다시보지않기 체크? 했는지 확인하게 될 창
//        이전페이지, 뒤로가기 등으로 데이터 복구하거나 할 수 없게하기 '잘못된 접근입니다' 같은 창 띄워주기
        return diaryService.submitModal(date);
    }

}
